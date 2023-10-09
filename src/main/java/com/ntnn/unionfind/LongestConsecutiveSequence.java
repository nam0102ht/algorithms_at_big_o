package com.ntnn.unionfind;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestConsecutiveSequence {

    static class DisjointSet {
        HashMap<Integer, Integer> id = new HashMap<>();
        HashMap<Integer, Integer> size = new HashMap<>();

        public int find(int x) {
            if (id.get(x) == x) return x;
            id.put(x, id.get(x));
            return id.get(x);
        }

        public void union(int u, int v) {
            int idU = find(u);
            int idV = find(v);
            if (idU == idV) return;

            if (size.get(idU) < size.get(idV)) {
                id.put(idU, idV);
                size.put(idV, size.get(idU) + size.get(idV));
            } else {
                id.put(idV, idU);
                size.put(idU, size.get(idU) + size.get(idV));
            }
        }
    }

    public static int longestString(int[] nums) {
        DisjointSet ds = new DisjointSet();
        for(int i = 0; i < nums.length; i++){
            if(!ds.id.containsKey(nums[i])){
                ds.id.put(nums[i], nums[i]);
                ds.size.put(nums[i], 1);

                if(ds.id.containsKey(nums[i] + 1)) ds.union(nums[i], nums[i] + 1);
                if(ds.id.containsKey(nums[i] - 1)) ds.union(nums[i], nums[i] - 1);
            }
        }

        int longest = 0;

        for(Map.Entry<Integer, Integer> entry : ds.size.entrySet()){
            longest = Math.max(longest, entry.getValue());
        }

        return longest;
    }

    // hashset way
    public static int longestStringHashSet(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        // initial hashset
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        // find longest
        int longest = 0;
        for (int i : set) {
            if (!set.contains(i - 1)) {
                int currNum = i;
                int currStreak = 1;
                while (set.contains(currNum + 1)) {
                    currNum++;
                    currStreak++;
                }
                longest = Math.max(longest, currStreak);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(longestString(new int[] {9,-1,4,-9,-3,0,-8,2,6,-4,-3,4,1,3,5,5,-7,-7,1,-9,-3,3,8,4,1,2}));
        System.out.println(longestStringHashSet(new int[] {0,3,7,2,5,8,4,6,0,1}));
        System.out.println(longestStringHashSet(new int[] {100,4,200,1,3,2}));
    }
}
