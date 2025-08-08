package com.ntnn.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
 *
 * You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
 *
 * You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
 * Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
 * Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
 * Given the integer array fruits, return the maximum number of fruits you can pick.
 *
 *
 *
 * Example 1:
 *
 * Input: fruits = [1,2,1]
 * Output: 3
 * Explanation: We can pick from all 3 trees.
 * Example 2:
 *
 * Input: fruits = [0,1,2,2]
 * Output: 3
 * Explanation: We can pick from trees [1,2,2].
 * If we had started at the first tree, we would only pick from trees [0,1].
 * Example 3:
 *
 * Input: fruits = [1,2,3,2,2]
 * Output: 4
 * Explanation: We can pick from trees [2,3,2,2].
 * If we had started at the first tree, we would only pick from trees [1,2].
 *
 */


public class FruitIntoBaskets {
  public static int totalFruit(int[] fruits) {
    int maxLength = 0;
    int start = 0;
    Map<Integer, Integer> listFrequences = new HashMap<>();
    //try to extend the range
    for (int end = 0; end < fruits.length; end++) {
      int endFruits = fruits[end];
      listFrequences.put(endFruits, listFrequences.getOrDefault(endFruits, 0) + 1);
      // shrink the sliding window, until we are left with '2' fruits in the fruitFrequen
      while (listFrequences.size() > 2) {
        var startFruit = fruits[start];
        listFrequences.put(startFruit, listFrequences.getOrDefault(startFruit, 0) - 1);
        if(listFrequences.get(startFruit) == 0) {
          listFrequences.remove(startFruit);
        }
        start++;
      }
      maxLength = Math.max(maxLength, end - start + 1);
    }
    return maxLength;
  }

  public static void main(String[] args) {
    int[] fruits = new int[] {1, 2, 1};
    System.out.println(totalFruit(fruits));
  }
}
