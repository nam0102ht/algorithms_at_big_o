import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    /**
     * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
     * 
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 
     * For example, 2 is written as II in Roman numeral, just two ones added together.
     * 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
     * 
     * Roman numerals are usually written largest to smallest from left to right. However,
     * the numeral for four is not IIII. Instead, the number four is written as IV.
     * Because the one is before the five we subtract it making four. The same principle
     * applies to the number nine, which is written as IX. There are six instances where
     * subtraction is used:
     * 
     * - I can be placed before V (5) and X (10) to make 4 and 9.
     * - X can be placed before L (50) and C (100) to make 40 and 90.
     * - C can be placed before D (500) and M (1000) to make 400 and 900.
     * 
     * Given a roman numeral, convert it to an integer.
     * 
     * Example 1:
     * Input: s = "III"
     * Output: 3
     * Explanation: III = 3.
     * 
     * Example 2:
     * Input: s = "LVIII"
     * Output: 58
     * Explanation: L = 50, V= 5, III = 3.
     * 
     * Example 3:
     * Input: s = "MCMXCIV"
     * Output: 1994
     * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     * 
     * Constraints:
     * - 1 <= s.length <= 15
     * - s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
     * - It is guaranteed that s is a valid roman numeral in the range [1, 3999].
     * 
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(1) since the map size is fixed (7 symbols)
     */
    
    // Map to store Roman numeral values
    private static final Map<Character, Integer> ROMAN_VALUES = new HashMap<>();
    
    static {
        ROMAN_VALUES.put('I', 1);
        ROMAN_VALUES.put('V', 5);
        ROMAN_VALUES.put('X', 10);
        ROMAN_VALUES.put('L', 50);
        ROMAN_VALUES.put('C', 100);
        ROMAN_VALUES.put('D', 500);
        ROMAN_VALUES.put('M', 1000);
    }
    
    public int romanToInt(String s) {
        int result = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            int currentValue = ROMAN_VALUES.get(s.charAt(i));
            
            // If the current value is less than the next value, subtract it
            // This handles cases like IV (4), IX (9), XL (40), XC (90), CD (400), CM (900)
            if (i < n - 1 && currentValue < ROMAN_VALUES.get(s.charAt(i + 1))) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
        }
        
        return result;
    }
    
    // Test method
    public static void main(String[] args) {
        RomanToInteger solution = new RomanToInteger();
        
        // Test case 1: III = 3
        String s1 = "III";
        int result1 = solution.romanToInt(s1);
        System.out.println("Test 1: Input: \"" + s1 + "\" -> Output: " + result1 + " (Expected: 3)");
        
        // Test case 2: LVIII = 58
        String s2 = "LVIII";
        int result2 = solution.romanToInt(s2);
        System.out.println("Test 2: Input: \"" + s2 + "\" -> Output: " + result2 + " (Expected: 58)");
        
        // Test case 3: MCMXCIV = 1994
        String s3 = "MCMXCIV";
        int result3 = solution.romanToInt(s3);
        System.out.println("Test 3: Input: \"" + s3 + "\" -> Output: " + result3 + " (Expected: 1994)");
        
        // Additional test cases
        // Test case 4: IV = 4
        String s4 = "IV";
        int result4 = solution.romanToInt(s4);
        System.out.println("Test 4: Input: \"" + s4 + "\" -> Output: " + result4 + " (Expected: 4)");
        
        // Test case 5: IX = 9
        String s5 = "IX";
        int result5 = solution.romanToInt(s5);
        System.out.println("Test 5: Input: \"" + s5 + "\" -> Output: " + result5 + " (Expected: 9)");
        
        // Test case 6: XL = 40
        String s6 = "XL";
        int result6 = solution.romanToInt(s6);
        System.out.println("Test 6: Input: \"" + s6 + "\" -> Output: " + result6 + " (Expected: 40)");
        
        // Test case 7: CM = 900
        String s7 = "CM";
        int result7 = solution.romanToInt(s7);
        System.out.println("Test 7: Input: \"" + s7 + "\" -> Output: " + result7 + " (Expected: 900)");
    }
}