package com.ntnn.twopoints;

import java.util.*;

/*
When Valera has got some free time, he goes to the library to read some books. Today he's got TT free minutes to read. That's why Valera took NN books in the library and for each book he estimated the time he is going to need to read it. Let's number the books by integers from 11 to NN. Valera needs A_iA
​i
  minutes to read the ii-th book.

Valera decided to choose an arbitrary book with number ii and read the books one by one, starting from this book. In other words, he will first read book number ii, then book number i + 1i+1, then book number i + 2i+2 and so on. He continues the process until he either runs out of the free time or finishes reading the NN-th book. Valera reads each book up to the end, that is, he doesn't start reading the book if he doesn't have enough free time to finish reading it.

Print the maximum number of books Valera can read.

Input Format
The first line contains two integers NN and TT (1 \leq N \leq 10^5; 1 \leq T \leq 10^9)(1≤N≤105;1≤T≤109)— the number of books and the number of free minutes Valera's got. The second line contains a sequence of NN integers A_1,A1,A_2A2,...,A_NAN(1 \leq A_i \leq 10^4)(1≤Ai≤10^4), where number A_iAi
  shows the number of minutes that the boy needs to read the ii-th book.

Output Format
Print a single integer — the maximum number of books Valera can read.
* */
public class Books {
    public static void main(String ...args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s3 = sc.nextLine();
        int[] lens = java.util.Arrays.stream(s1.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr = java.util.Arrays.stream(s3.split(" ")).mapToInt(Integer::parseInt).toArray();

        int count = 0;
        int maxbook = 0;
        int readbook = 0;

        for(int i=0; i < lens[0]; i++) {
            readbook += arr[i];
            while(readbook >= lens[1]) {
                readbook -= arr[count];
                count++;
            }
            maxbook = Math.max(maxbook, i - count + 1);
        }
        System.out.println(maxbook);
    }
}
