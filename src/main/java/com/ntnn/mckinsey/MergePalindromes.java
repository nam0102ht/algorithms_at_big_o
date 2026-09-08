package com.ntnn.mckinsey;

import java.util.ArrayList;
import java.util.List;

public class MergePalindromes {
  public static String mergePalindromes(String s1, String s2) {
    // ── 1. Build frequency maps ───────────────────────────────────────────
    int[] freq1 = new int[26];
    int[] freq2 = new int[26];
    for (char c : s1.toCharArray()) freq1[c - 'a']++;
    for (char c : s2.toCharArray()) freq2[c - 'a']++;

    // ── 2. Base counts (largest even ≤ freq) ─────────────────────────────
    int[] base1 = new int[26];
    int[] base2 = new int[26];
    for (int i = 0; i < 26; i++) {
      base1[i] = (freq1[i] / 2) * 2;
      base2[i] = (freq2[i] / 2) * 2;
    }

    // ── 3. Characters with odd frequency (palindrome center candidates) ──
    //       -1 means "no center chosen" (even-length palindrome)
    List<Integer> odds1 = new ArrayList<>();
    List<Integer> odds2 = new ArrayList<>();
    odds1.add(-1);   // choice: no center
    odds2.add(-1);
    for (int i = 0; i < 26; i++) {
      if (freq1[i] % 2 == 1) odds1.add(i);
      if (freq2[i] % 2 == 1) odds2.add(i);
    }

    // ── 4. Enumerate all (~27 × 27 = 729) center combinations ────────────
    String best = "";
    int bestLen = -1;

    for (int c1 : odds1) {
      for (int c2 : odds2) {

        // Combined multiset
        int[] combined = new int[26];
        for (int i = 0; i < 26; i++) {
          combined[i] = base1[i] + base2[i];
        }
        if (c1 >= 0) combined[c1]++;
        if (c2 >= 0) combined[c2]++;

        // Smallest odd-count char becomes the palindrome center
        int center = -1;
        for (int i = 0; i < 26; i++) {
          if (combined[i] % 2 == 1) { center = i; break; }
        }

        // Build palindrome: sorted pairs on left + center + mirror
        StringBuilder left = new StringBuilder();
        for (int i = 0; i < 26; i++) {
          for (int k = 0; k < combined[i] / 2; k++) {
            left.append((char) ('a' + i));
          }
        }
        String right = left.reverse().toString();
        left.reverse(); // restore

        String pal = left.toString()
            + (center >= 0 ? (char)('a' + center) : "")
            + right;

        if (pal.length() > bestLen ||
            (pal.length() == bestLen && pal.compareTo(best) < 0)) {
          bestLen = pal.length();
          best = pal;
        }
      }
    }

    return best;
  }

  public static void main(String[] args) {
    String[][] cases = {
        {"aab",   "cca",     "acaca"},
        {"adaab", "cac",     "aaccaa"},
        {"aabbc", "ddefefq", "abdefcfedba"},
        {"a",     "b",       "a"},
        {"aa",    "bb",      "abba"},
        {"abc",   "abc",     "aa"},
        {"z",     "z",       "zz"},
    };

    int pass = 0;
    for (String[] tc : cases) {
      String result = mergePalindromes(tc[0], tc[1]);
      boolean ok = result.equals(tc[2]);
      System.out.printf("%s mergePalindromes(%s, %s)%n",
          ok ? "✓" : "✗", tc[0], tc[1]);
      if (!ok) {
        System.out.printf("   expected: %s%n", tc[2]);
        System.out.printf("   got:      %s%n", result);
      } else {
        System.out.printf("   → %s%n", result);
        pass++;
      }
    }
    System.out.printf("%nPassed %d / %d%n", pass, cases.length);
  }
}
