package com.ntnn.dynamicprogramming;

/*
* Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.

A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.



Example 1:

Input: n = 1
Output: 5
Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].
Example 2:

Input: n = 2
Output: 15
Explanation: The 15 sorted strings that consist of vowels only are
["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.
Example 3:

Input: n = 33
Output: 66045
*
* (a, e, i, o, u) => just included 5 values
* create one cache with cache[n + 1][5]
* current value + prev vowel - 1
* formula is dp[i][j] = dp[i][j-1] - dp[i-1][j-1]
* */

public class CountSortedVowelStrings {
    public static int countVowelStrings(int n) {
        if(n == 1) return 5;
        int[][] dp = new int[n+1][5];
        int currSum=5;
        for(int i=0;i<5;i++) {
            dp[0][i]=1; //denotes no. of strings for n=1
        }

        for (int i=1; i<n; i++) {
            dp[i][0]=currSum;
            for(int j=1;j<5;j++) {
                dp[i][j] = dp[i][j-1]- dp[i-1][j-1];
                currSum += dp[i][j];
            }
        }
        return currSum;
    }

    public static void main(String[] args) {
        System.out.println(countVowelStrings(4));
    }
}
