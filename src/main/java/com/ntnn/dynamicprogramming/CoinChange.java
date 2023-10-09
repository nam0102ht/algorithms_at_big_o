package com.ntnn.dynamicprogramming;


import java.util.Arrays;

/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.



Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
* */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0 || coins.length == 0 || coins == null) {
            return 0;
        }

        // create a table save each value start from 1 to amount
        int[] dp = new int[amount + 1];
        // init dp is amount
        Arrays.fill(dp, amount + 1);
        // set up first value is equal 0
        dp[0] = 0;

        // start from 1
        for (int i=1; i<=amount; i++) {
            for (int coin : coins) {
                if (i - coin >=0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] != (amount + 1) ? dp[amount] : -1;

    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(new int[] {1,2,5}, 11));
    }
}
