package com.ntnn.backtracking;

import java.util.*;

public class TheBoggleGame {
  private static final int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
  private static final int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

  private static boolean[][] visit = new boolean[4][4];
  private static List<Character> vowels = List.of('A', 'E', 'I', 'O', 'U', 'Y');

  private static void DFS(int i, int j, char[][] board, StringBuilder word, List<String> pigEwu) {
    word.append(board[i][j]);

    if (word.length() == 4) {
      if (NumOfVowel(word.toString()) == 2) {
        pigEwu.add(word.toString());
      }
      word.deleteCharAt(word.length() - 1);
      return;
    }

    visit[i][j] = true;
    for (int x = 0; x < 8; ++x) {
      int nxt_i = i + dx[x];
      int nxt_j = j + dy[x];
      if (nxt_i < 0 || nxt_i == 4 || nxt_j < 0 || nxt_j == 4) continue;

      if (!visit[nxt_i][nxt_j])
        DFS(nxt_i, nxt_j, board, word, pigEwu);
    }
    visit[i][j] = false;
    word.deleteCharAt(word.length() - 1);
  }

  private static int NumOfVowel(String a) {
    int count = 0;
    for (int i = 0; i < 4; ++i) {
      if (vowels.contains(a.charAt(i))) {
        ++count;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int caseCount = 0;
    while (true) {
      caseCount++;
      char[][] board1 = new char[4][4];
      char[][] board2 = new char[4][4];
      List<String> pigEwu1 = new ArrayList<>();
      List<String> pigEwu2 = new ArrayList<>();
      List<String> ans = new ArrayList<>();
      StringBuilder word = new StringBuilder();

      for (int i = 0; i < 4; ++i) {
        for (int j = 0; j < 4; ++j) {
          board1[i][j] = scanner.next().charAt(0);
          if (board1[i][j] == '#') System.exit(0);
        }
        for (int j = 0; j < 4; ++j)
          board2[i][j] = scanner.next().charAt(0);
      }

      // Find all possible answers for both boards using DFS
      for (int i = 0; i < 4; ++i) {
        for (int j = 0; j < 4; ++j) {
          DFS(i, j, board1, word, pigEwu1);
          DFS(i, j, board2, word, pigEwu2);
        }
      }
      for (String a : pigEwu1) {
        for (String b : pigEwu2) {
          if (a.equals(b)) {
            ans.add(a);
            break;
          }
        }
      }

      Collections.sort(ans);

      if (caseCount != 1)
        System.out.println();

      if (ans.isEmpty())
        System.out.println("There are no common words for this pair of boggle boards.");
      else {
        System.out.println(ans.get(0));
        for (int i = 1; i < ans.size(); ++i) {
          if (!ans.get(i).equals(ans.get(i - 1))) {
            System.out.println(ans.get(i));
          }
        }
      }
    }
  }

}
