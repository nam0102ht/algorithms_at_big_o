package com.ntnn.twopoints;

import java.util.*;
import java.util.stream.Collectors;

public class Permutation {
    // Solution O(n^2) with nextPermutation
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        String firstList = Arrays.toString(nums);
        while(true) {
            List<Integer> output = Arrays.stream(nums).boxed().collect(Collectors.toList());
            result.add(output);
            nextPermutation(nums);
            if(firstList.equals(Arrays.toString(nums))) {
                break;
            }
        }

        return result;
    }

    public void nextPermutation(int[] nums) {
        int j = 0;
        int i = nums.length - 2;
        while(i >=0 && nums[i+1] <= nums[i]) i--;
        if (i>=0) {
            j = nums.length - 1;
            while(nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1);
    }

    void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length -1;
        while(i<j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    void swap(int[] nums, int x, int y) {
        nums[x] = nums[x] ^ nums[y] ^ (nums[y] = nums[x]);
    }

    //Solution O(n) with use dfs
    public void dfs(List<Integer> path, boolean[] used, List<List<Integer>> res, int[] nums) {
        if(path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < used.length; i++) {
            if(used[i]) continue;
            path.add(nums[i]);
            used[i] = true;
            dfs(path, used, res, nums);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }


    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        // count the occurrence of each number
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            if (!counter.containsKey(num))
                counter.put(num, 0);
            counter.put(num, counter.get(num) + 1);
        }

        LinkedList<Integer> comb = new LinkedList<>();
        this.backtrack(comb, nums.length, counter, results);
        return results;
    }

    protected void backtrack(
            LinkedList<Integer> comb,
            Integer N,
            HashMap<Integer, Integer> counter,
            List<List<Integer>> results) {

        if (comb.size() == N) {
            // make a deep copy of the resulting permutation,
            // since the permutation would be backtracked later.
            results.add(new ArrayList<Integer>(comb));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            if (count == 0)
                continue;
            // add this number into the current combination
            comb.addLast(num);
            counter.put(num, count - 1);

            // continue the exploration
            backtrack(comb, N, counter, results);

            // revert the choice for the next exploration
            comb.removeLast();
            counter.put(num, count);
        }
    }
}
