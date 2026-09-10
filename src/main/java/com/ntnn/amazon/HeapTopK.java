package com.ntnn.amazon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class HeapTopK {
  /*
  * Let’s move away from graph traversal and test another high-value Amazon pattern: Top K + Heap.
  * Amazon has a stream of product IDs representing customer purchases:
  * products = [1, 1, 1, 2, 2, 3, 3, 3, 3, 4]
  * k = 2
  * Return the k most frequently purchased products.
  * For this example:
  * Product 1 → 3 purchases
  * Product 2 → 2 purchases
  * Product 3 → 4 purchases
  * Product 4 → 1 purchase
  * Therefore a valid result is:
  * [3, 1]
  * 1. How would you count the frequency of each product? ->
  *         1 -> 3
  *         2 -> 2
  *         3 -> 4
  *         4 -> 1
  * 2. Would you sort all products by frequency, or use another data structure? I will use the PriorityQueue for that.
  *         I’ll first count frequencies with a HashMap.
  *         Since I only need the top K products, instead of sorting all unique products or maintaining a max-heap containing all of them,
  *         I’ll maintain a min-heap of size K. When its size exceeds K, I remove the smallest-frequency product.
  *         After processing all products, the heap contains the K most frequent products
  * 3. Would you use a min-heap or max-heap? Why? -> I would use a min-heap of size K. Even though I’m looking for the largest frequencies,
  *         the min-heap allows me to efficiently remove the smallest candidate whenever the heap exceeds K elements.
  *         This keeps only the K largest frequencies and gives O(u log k) instead of sorting all unique products.
  *
  *         Add 1:3 → [1:3]
  *         Add 2:2 → [2:2, 1:3]
  *         Add 3:4
  *         → size 3
  *         → remove 2:2
  *         → [1:3, 3:4]
  *         Add 4:1
  *         → size 3
  *         → remove 4:1
  *         → [1:3, 3:4]
  * 4. What should each heap element contain?
  *         “Each heap element contains the product ID and its frequency. The heap comparator orders elements by frequency.
  *          Since I’m maintaining a min-heap of size K, the product with the smallest frequency among the current top-K candidates stays at the root.”
  * 5. Why should the heap contain at most k elements?
  *         The heap should contain at most k elements because I only need the top k results.
  *         When the heap exceeds k, I remove the smallest-frequency element. This keeps only the best k candidates and reduces heap operations from O(log u) to O(log k)
  * 6. What are the time and space complexities?
  * */

  public static void main(String[] args) {
    int[] products = new int[] { 1, 1, 1, 2, 2, 3, 3, 3, 3, 4 };
    int k = 2;
    System.out.println("top k frequent: " + topKFrequent(products, k));
  }


  public static List<Integer> topKFrequent(int[] products, int k) {
    Map<Integer, Integer> frequently = new HashMap<>();
    for (int i : products) {
      frequently.put(i, frequently.getOrDefault(i, 0) + 1);
    }
    List<Integer> result = new ArrayList<>();
    PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
        new PriorityQueue<>(
            Comparator.comparingInt(Map.Entry::getValue)
        );
    frequently.forEach((key, value) -> {
      minHeap.offer(Map.entry(key, value));
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    });

    while (!minHeap.isEmpty()) {
      result.add(minHeap.poll().getKey());
    }

    return result;
  }
}
