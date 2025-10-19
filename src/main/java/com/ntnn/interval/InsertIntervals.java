package com.ntnn.interval;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervals {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> answer = new ArrayList<>();

    int n = intervals.length;
    int i = 0;
    // 1. Add intervals before newInterval (no overlap)
    while (i < n && intervals[i][1] < newInterval[0]) {
      answer.add(intervals[i]);
      i++;
    }

    // 2. Merge overlapping intervals with newInterval
    while (i < n && intervals[i][0] <= newInterval[1]) {
      newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
      newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
      i++;
    }
    answer.add(newInterval); // insert the merged newInterval

    // 3. Add the rest of the intervals
    while (i < n) {
      answer.add(intervals[i]);
      i++;
    }

    return answer.toArray(new int[answer.size()][]);
  }
}
