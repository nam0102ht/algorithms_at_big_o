import numpy as np
import pandas as pd
import yfinance as yf
import statsmodels.api as sm

# ---------------------------------
# 1. Download data with Adj Close
# ---------------------------------
tickers = ["AAPL", "SPY"]

data = yf.download(
    tickers,
    start="2023-01-01",
    end="2024-12-31",
    auto_adjust=False     # <-- FIX
)["Adj Close"]

# Compute log returns
returns = np.log(data).diff().dropna()

# Use the first 20 observations
Y = returns["AAPL"].iloc[:20]
X = returns["SPY"].iloc[:20]

df = pd.DataFrame({"Y": Y, "X": X})
df.index = range(1, 21)

# ---------------------------------
# 2. Create dummy and interaction
# ---------------------------------
df["D"] = (df.index > 10).astype(int)
df["Z"] = df["D"] * df["X"]

# ---------------------------------
# 3. Regression: Y = alpha + B X + γ Z
# ---------------------------------
X_reg = sm.add_constant(df[["X", "Z"]])
model = sm.OLS(df["Y"], X_reg)
results = model.fit()

print(results.summary())

# ---------------------------------
# 4. Test for structural break
# ---------------------------------
gamma_t = results.tvalues["Z"]
gamma_p = results.pvalues["Z"]

print("\nStructural break test (γ = change in slope):")
print(f"  t-statistic: {gamma_t:.4f}")
print(f"  p-value: {gamma_p:.4f}")

if gamma_p < 0.05:
    print("=> Reject H0: break in slope B at t=10")
else:
    print("=> Fail to reject H0: no significant break")