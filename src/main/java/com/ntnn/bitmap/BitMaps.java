import java.util.Scanner;

public class BitMaps {
  static char m;
  static int r, c;
  static String parse, res;
  static int idx = 0;

  public static void toDecomposeMap(int rowStart, int rowEnd, int colStart, int colEnd) {
    if (rowStart > rowEnd || colStart > colEnd)
      return;
    int totalSize = (rowEnd - rowStart + 1) * (colEnd - colStart + 1);
    int bitCount = 0;
    for (int i = rowStart; i <= rowEnd; i++)
      for (int j = colStart; j <= colEnd; j++)
        bitCount += (parse.charAt(i * c + j) - '0');
    if (bitCount == totalSize) {
      res += '1';
    } else if (bitCount == 0) {
      res += '0';
    } else {
      res += 'D';
      // top left
      toDecomposeMap(rowStart, (rowStart + rowEnd) / 2, colStart, (colStart + colEnd) / 2);
      // top right
      toDecomposeMap(rowStart, (rowStart + rowEnd) / 2, (colStart + colEnd) / 2 + 1, colEnd);
      // btm left
      toDecomposeMap((rowStart + rowEnd) / 2 + 1, rowEnd, colStart, (colStart + colEnd) / 2);
      // btm right
      toDecomposeMap((rowStart + rowEnd) / 2 + 1, rowEnd, (colStart + colEnd) / 2 + 1, colEnd);
    }
  }

  public static void toBitMap(int rowStart, int rowEnd, int colStart, int colEnd) {
    if (rowStart > rowEnd || colStart > colEnd)
      return;
    char ch = parse.charAt(idx++);
    if (ch == 'D') {
      // top left
      toBitMap(rowStart, (rowStart + rowEnd) / 2, colStart, (colStart + colEnd) / 2);
      // top right
      toBitMap(rowStart, (rowStart + rowEnd) / 2, (colStart + colEnd) / 2 + 1, colEnd);
      // btm left
      toBitMap((rowStart + rowEnd) / 2 + 1, rowEnd, colStart, (colStart + colEnd) / 2);
      // btm right
      toBitMap((rowStart + rowEnd) / 2 + 1, rowEnd, (colStart + colEnd) / 2 + 1, colEnd);
    } else {
      StringBuilder sb = new StringBuilder(res);
      for (int i = rowStart; i <= rowEnd; i++)
        for (int j = colStart; j <= colEnd; j++)
          sb.setCharAt(i * c + j, ch);
      res = sb.toString();
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      m = scanner.next().charAt(0);
      if (m == '#')
        break;
      r = scanner.nextInt();
      c = scanner.nextInt();
      parse = scanner.next();
      while (m == 'B' && parse.length() != r * c) {
        res = scanner.next();
        parse += res;
      }
      idx = 0;
      if (m == 'D') {
        res = "";
        toBitMap(0, r - 1, 0, c - 1);
      } else {
        res = "";
        toDecomposeMap(0, r - 1, 0, c - 1);
      }

      System.out.printf("%c%4d%4d\n", (m == 'D' ? 'B' : 'D'), r, c);
      for (int i = 0; i < res.length(); i++) {
        if (i % 50 == 0 && i > 0)
          System.out.println();
        System.out.print(res.charAt(i));
      }
      System.out.println();
    }
    scanner.close();
  }
}