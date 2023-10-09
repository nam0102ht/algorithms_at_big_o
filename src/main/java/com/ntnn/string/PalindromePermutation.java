package com.ntnn.string;

import java.util.HashMap;

public class PalindromePermutation {

    public static boolean isPermutationOfPalindrome(String phrase) {
        int[] table = buildCharFrequencyTable(phrase);
        boolean foundOdd = false;
        for (int i = 0; i < table.length; i++) {
            if (table[i] % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    private static int[] buildCharFrequencyTable(String phrase) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
            }
        }
        return table;
    }

    private static int getCharNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);

        if ( a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    static boolean isPermutationOfPalindrome2(String phrase) {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (int i = 0; i < phrase.length(); i++) {
            int x = getCharNumber(phrase.toCharArray()[i]);
            if ( x != -1) {
                table[x]++;
                if (table[x] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }

    static boolean isPermutationOfPalindromeHashMap(String phrase) {
        int countOdd = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if ( x != -1) {
                map.put(c, map.getOrDefault(c, 1) + 1);
                if (map.get(c) % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }

    public static void main(String[] args) {
        String str = "Tact coa";

        System.out.println(isPermutationOfPalindrome(str));
        System.out.println(isPermutationOfPalindrome2(str));
        System.out.println(isPermutationOfPalindromeHashMap(str));
    }
}
