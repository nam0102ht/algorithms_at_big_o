import java.util.Arrays;

/**
 * Solution for the Number Game problem.
 * 
 * Problem: Alice and Bob play a game where they alternately remove minimum elements
 * from an array. Alice removes first, then Bob. After both remove, Bob appends his
 * element to the result array first, then Alice appends hers.
 * 
 * Key Insight: When we sort the array, each pair of consecutive elements represents
 * one round. For each pair (smaller, larger), Alice gets the smaller and Bob gets
 * the larger. Since Bob appends first, the result for each pair is [larger, smaller].
 * 
 * Time Complexity: O(n log n) for sorting
 * Space Complexity: O(n) for the result array
 * 
 * Example:
 * Input: [5,4,2,3]
 * Sorted: [2,3,4,5]
 * Pairs: (2,3) -> [3,2], (4,5) -> [5,4]
 * Output: [3,2,5,4]
 */
class Solution {
    public int[] numberGame(int[] nums) {
        // Sort the array to get elements in ascending order
        Arrays.sort(nums);
        
        // Create result array
        int[] arr = new int[nums.length];
        
        // For each pair, swap positions: Bob's element (larger) goes first,
        // Alice's element (smaller) goes second
        for (int i = 0; i < nums.length; i += 2) {
            arr[i] = nums[i + 1];     // Bob's element (larger of the pair)
            arr[i + 1] = nums[i];     // Alice's element (smaller of the pair)
        }
        
        return arr;
    }
}