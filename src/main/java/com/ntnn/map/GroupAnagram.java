package com.ntnn.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {
  /*
  * Input: strs = ["eat","tea","tan","ate","nat","bat"]
  * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
  * */

  public static List<List<String>> groupAnagram(List<String> groups) {
    Map<String, List<String>> map = new HashMap<>();
    groups.forEach(v -> {
      char[] arr = v.toCharArray();
      int[] count = new int[26];
      for (char c : arr) {
        count[c - 'a']++;
      }

      StringBuilder builder = new StringBuilder();
      for (int i = 0; i < 26; i++) {
        builder.append('#');  // separator to avoid ambiguity
        builder.append(count[i]);
      }

      String key = builder.toString();

      map.computeIfAbsent(key, k -> new ArrayList<>()).add(v);
    });
    return new ArrayList<>(map.values());
  }

}
