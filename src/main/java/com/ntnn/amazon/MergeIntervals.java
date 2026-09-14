package com.ntnn.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
  //Pattern: Sorting + Intervals
  //Core idea: Sort by start time, then merge overlapping intervals.
  //
  //Given an array of intervals where:
  //
  //intervals[i] = [start, end]
  //
  //merge all overlapping intervals.
  //
  //Example:
  //
  //Input:
  //[[1,3], [2,6], [8,10], [15,18]]
  //Output:
  //[[1,6], [8,10], [15,18]]
  //
  //Because:
  //
  //[1,3]
  //   [2,6]
  //    ↑
  // overlap
  //→ [1,6]
  //
  //Another example:
  //
  //Input:
  //[[1,4], [4,5]]
  //Output:
  //[[1,5]]
  //
  //Touching intervals count as overlapping here.
  //
  //Implement:
  //
  //int[][] merge(int[][] intervals)
  //
  //Interview questions
  //
  //1. What would a brute-force approach look like, and what would its complexity be?
  //2. Why does sorting by interval start make this problem easier?
  //3. After sorting, suppose the current merged interval is [currentStart, currentEnd] and the next interval is [nextStart, nextEnd]. What condition tells you they overlap?
  //4. If they overlap, how do you calculate the merged interval?
  //5. If they don’t overlap, what should you do with the current interval?
  //6. What are the final time and space complexities?
  //
  //Start with questions 1 and 2 only. Don’t code yet.

  public static void main(String[] args) {
    int[][] intervals = {
        {1, 3},
        {2, 6},
        {8, 10},
        {15, 18}
    };

    int[][] result = merge(intervals);
    for (int[] interval : result) {
      System.out.println(Arrays.toString(interval));
    }
  }

  public static int[][] merge(int[][] intervals) {
    // First sorting by start time
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    List<int[]> result = new ArrayList<>();
    int currentStart = intervals[0][0];
    int currentEnd = intervals[0][1];
    // 2. Scan from left to right

    for (int i = 1; i < intervals.length; i++) {
      int nextStart = intervals[i][0];
      int nextEnd = intervals[i][1];

      // Overlap
      if (nextStart <= currentEnd) {
        currentEnd = Math.max(currentEnd, nextEnd);
      } else {
        // No overlap -> finalize current interval
        result.add(new int[]{currentStart, currentEnd});
        currentStart = nextStart;
        currentEnd = nextEnd;
      }
    }

    // 3. Don't forget the last interval
    result.add(new int[] {currentStart, currentEnd});

    return result.toArray(new int[result.size()][]);
  }
}
