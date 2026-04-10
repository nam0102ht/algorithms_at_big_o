import java.util.*;

/**
 * Solution for finding the minimum distance of a good tuple.
 * 
 * A good tuple (i, j, k) has three distinct indices where nums[i] == nums[j] == nums[k].
 * The distance is defined as abs(i - j) + abs(j - k) + abs(k - i).
 * 
 * Key insight: For a sorted tuple (i < j < k), the distance simplifies to 2 * (k - i).
 * This means we need to find three indices of the same value that are closest together.
 * 
 * Algorithm:
 * 1. Group indices by their corresponding values
 * 2. For each group with at least 3 indices, find the minimum distance among consecutive triples
 * 3. Return the overall minimum distance, or -1 if no valid tuples exist
 * 
 * Time Complexity: O(n) where n is the length of nums
 * Space Complexity: O(n) for storing indices
 */
public class MinimumGoodTupleDistance {
    
    /**
     * Finds the minimum possible distance of a good tuple.
     * 
     * @param nums the input integer array
     * @return the minimum distance of a good tuple, or -1 if no good tuples exist
     */
    public int minimumDistance(int[] nums) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        
        // Group indices by value
        Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            valueToIndices.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        int minDistance = Integer.MAX_VALUE;
        
        // Check each group of indices
        for (List<Integer> indices : valueToIndices.values()) {
            if (indices.size() >= 3) {
                // For minimum distance, check consecutive triples
                // Distance = 2 * (max_index - min_index) for sorted triple
                for (int i = 0; i < indices.size() - 2; i++) {
                    int first = indices.get(i);
                    int third = indices.get(i + 2);
                    int distance = 2 * (third - first);
                    minDistance = Math.min(minDistance, distance);
                }
            }
        }
        
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
    
    /**
     * Main method with test cases.
     */
    public static void main(String[] args) {
        MinimumGoodTupleDistance solution = new MinimumGoodTupleDistance();
        
        // Test case 1: nums = [1,2,1,1,3] -> Expected: 6
        int[] nums1 = {1, 2, 1, 1, 3};
        System.out.println("Test 1: " + solution.minimumDistance(nums1)); // Expected: 6
        
        // Test case 2: nums = [1,1,2,3,2,1,2] -> Expected: 8
        int[] nums2 = {1, 1, 2, 3, 2, 1, 2};
        System.out.println("Test 2: " + solution.minimumDistance(nums2)); // Expected: 8
        
        // Test case 3: nums = [1] -> Expected: -1
        int[] nums3 = {1};
        System.out.println("Test 3: " + solution.minimumDistance(nums3)); // Expected: -1
        
        // Test case 4: nums = [1,1,1] -> Expected: 4
        int[] nums4 = {1, 1, 1};
        System.out.println("Test 4: " + solution.minimumDistance(nums4)); // Expected: 4
        
        // Test case 5: nums = [1,2,3,4,5] -> Expected: -1
        int[] nums5 = {1, 2, 3, 4, 5};
        System.out.println("Test 5: " + solution.minimumDistance(nums5)); // Expected: -1
    }
}