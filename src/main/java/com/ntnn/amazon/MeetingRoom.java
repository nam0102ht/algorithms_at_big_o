package com.ntnn.amazon;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoom {
//  Given meeting intervals:
//
//  [[0, 30], [5, 10], [15, 20]]
//
//  find the minimum number of conference rooms required so that all meetings can happen.
//
//  Expected output:
//
//      2
//
//  Because:
//
//  Room 1: [0,30]
//  Room 2: [5,10] → [15,20]
//
//  Another example:
//
//      [[7,10], [2,4]]
//  Output: 1
//
//  Implement:
//
//  int minMeetingRooms(int[][] intervals)

  public static void main(String[] args) {
    int[][] meetings = {
        {0, 30},
        {5, 10},
        {15, 20}
    };

    System.out.println(minMeetingRooms(meetings)); // 2
  }

  public static int minMeetingRooms(int[][] intervals) {
    // sort meetings
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int[] meeting: intervals) {
      int start = meeting[0];
      int end = meeting[1];
      if (!minHeap.isEmpty() && minHeap.peek() == start) {
        minHeap.poll();
      }
      minHeap.offer(end);
    }
    return minHeap.size();
  }
}
