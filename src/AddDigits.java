/**
 * Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
 * 
 * Example 1:
 * Input: num = 38
 * Output: 2
 * Explanation: The process is
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2
 * Since 2 has only one digit, return it.
 * 
 * Example 2:
 * Input: num = 0
 * Output: 0
 * 
 * Constraints:
 * 0 <= num <= 2^31 - 1
 * 
 * Follow-up: Could you do it without any loop/recursion in O(1) runtime?
 */
public class AddDigits {
    
    /**
     * Iterative approach - repeatedly sum digits until single digit.
     * Time Complexity: O(log num) - number of digits in num
     * Space Complexity: O(1)
     * 
     * @param num the input integer
     * @return the single digit result after repeatedly adding digits
     */
    public int addDigitsIterative(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }
    
    /**
     * Mathematical approach using digital root formula.
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * The digital root of a number follows a pattern based on modulo 9:
     * - If num == 0, the digital root is 0
     * - If num is divisible by 9 (and not 0), the digital root is 9
     * - Otherwise, the digital root is num % 9
     * 
     * This can be expressed as: 1 + (num - 1) % 9 for num > 0
     * 
     * @param num the input integer
     * @return the single digit result (digital root)
     */
    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        return 1 + (num - 1) % 9;
    }
    
    // Test method
    public static void main(String[] args) {
        AddDigits solution = new AddDigits();
        
        // Test case 1: num = 38
        int num1 = 38;
        System.out.println("Test 1: Input = " + num1 + ", Output = " + solution.addDigits(num1));
        System.out.println("Expected: 2");
        System.out.println("Iterative result: " + solution.addDigitsIterative(num1));
        System.out.println();
        
        // Test case 2: num = 0
        int num2 = 0;
        System.out.println("Test 2: Input = " + num2 + ", Output = " + solution.addDigits(num2));
        System.out.println("Expected: 0");
        System.out.println("Iterative result: " + solution.addDigitsIterative(num2));
        System.out.println();
        
        // Test case 3: num = 9 (divisible by 9)
        int num3 = 9;
        System.out.println("Test 3: Input = " + num3 + ", Output = " + solution.addDigits(num3));
        System.out.println("Expected: 9");
        System.out.println("Iterative result: " + solution.addDigitsIterative(num3));
        System.out.println();
        
        // Test case 4: num = 18 (divisible by 9)
        int num4 = 18;
        System.out.println("Test 4: Input = " + num4 + ", Output = " + solution.addDigits(num4));
        System.out.println("Expected: 9");
        System.out.println("Iterative result: " + solution.addDigitsIterative(num4));
        System.out.println();
        
        // Test case 5: num = 12345
        int num5 = 12345;
        System.out.println("Test 5: Input = " + num5 + ", Output = " + solution.addDigits(num5));
        System.out.println("Expected: 6 (1+2+3+4+5=15, 1+5=6)");
        System.out.println("Iterative result: " + solution.addDigitsIterative(num5));
    }
}