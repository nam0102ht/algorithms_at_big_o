package com.ntnn.interval;

import java.util.LinkedList;

public class MergeIntervals {
  public int[][] merge(int[][] intervals) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    // find the bounder min and max
    for (int i = 0; i < intervals.length; i++) {
      min = Math.min(min, intervals[i][0]);
      max = Math.max(max, intervals[i][0]);
    }

    // initialy the range to store the max and min values
    // this one is applying the dynamic programming
    int[] range = new int[max - min + 1];
    for (int i = 0; i < intervals.length; i++) {
      range[intervals[i][0] - min] = Math.max(intervals[i][1] - min, range[intervals[i][0] - min]);
    }

    int start = 0, end = 0;
    // start and end is the range of the array
    LinkedList<int[]> result = new LinkedList<>();
    for (int i = 0; i < range.length; i++) {
      if (range[i] == 0) {
        continue;
      }
      if (i <= end) {
        end = Math.max(range[i], end);
      } else {
        result.add(new int[] {start + min, end + min});
        start = i;
        end = range[i];
      }
    }
    result.add(new int[] {start + min, end + min});
    return result.toArray(new int[result.size()][]);
  }
}
