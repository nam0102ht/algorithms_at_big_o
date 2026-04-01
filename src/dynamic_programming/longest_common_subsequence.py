def longest_common_subsequence(text1: str, text2: str) -> int:
    """
    Returns the length of the longest common subsequence between two strings.
    
    A subsequence is a sequence that can be derived from another sequence 
    by deleting some elements without changing the order of the remaining elements.
    
    Args:
        text1: First input string
        text2: Second input string
        
    Returns:
        The length of the longest common subsequence
        
    Examples:
        >>> longest_common_subsequence("abcde", "ace")
        3
        >>> longest_common_subsequence("abc", "abc")
        3
        >>> longest_common_subsequence("abc", "def")
        0
    """
    m, n = len(text1), len(text2)
    
    # Create a 2D DP table where dp[i][j] represents the length of the 
    # longest common subsequence of text1[0:i] and text2[0:j]
    dp = [[0] * (n + 1) for _ in range(m + 1)]
    
    # Fill the DP table
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            # If characters match, extend the LCS by 1
            if text1[i - 1] == text2[j - 1]:
                dp[i][j] = dp[i - 1][j - 1] + 1
            # If characters don't match, take the maximum of:
            # - LCS without current character from text1
            # - LCS without current character from text2
            else:
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
    
    return dp[m][n]


# Test cases
if __name__ == "__main__":
    # Test case 1
    assert longest_common_subsequence("abcde", "ace") == 3
    
    # Test case 2
    assert longest_common_subsequence("abc", "abc") == 3
    
    # Test case 3
    assert longest_common_subsequence("abc", "def") == 0
    
    print("All test cases passed!")
