package com.ntnn.divideAndConquer;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.LinkedList;

public class TreeSumming {
  boolean found = false;

  public static void main(String[] args) throws IOException {
    int count = 0;
    int sum = 0;
    int c;
    int data;
    int num = 0;
    LinkedList<String> stack = new LinkedList<String>();
    StreamTokenizer in = new StreamTokenizer(new InputStreamReader(System.in));
    boolean flag = false;
    while ((c = in.nextToken()) != StreamTokenizer.TT_EOF) {
      if (stack.size() == 0) {
        num = (int) in.nval;
        c = in.nextToken();
      }

      if (c == StreamTokenizer.TT_NUMBER) {
        data = (int) in.nval;
        sum += data;
        stack.push(data + "");
        count = 0;
      }
      if (c != StreamTokenizer.TT_NUMBER) {
        if ((char) c == '(') {
          stack.push( "(");
        } else if ((char) c == ')') {
          if (stack.getFirst().equals("(")) {
            count++;
            stack.pop();
            if (count == 2) {
              if (sum ==  num) flag = true;
              count = 0;
            }
          } else  {
            sum -= Integer.parseInt(stack.pop());
            stack.pop();
            count = 0;
          }
        }
        if (stack.size() == 0) {
          System.out.println(flag ? "yes" : "no");
          sum = 0;
          flag = false;
          count = 0;
        }
      }
    }
  }
}