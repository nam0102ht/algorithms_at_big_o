package com.ntnn.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();

        Deque<Integer> q = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (!q.isEmpty() && q.peekFirst() < i - k + 1) q.pollFirst();
            while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) q.pollLast();
            q.offer(i);

            if (i >= k - 1) res.add(nums[q.peekFirst()]);
        }

        return res.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int [] {1,3,-1,-3,5,3,6,7}, 3)));
    }
}
