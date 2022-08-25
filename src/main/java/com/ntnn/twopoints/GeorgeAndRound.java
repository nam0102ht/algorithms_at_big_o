package com.ntnn.twopoints;
import java.util.*;
import java.util.stream.Collectors;

/*
George decided to prepare a Codesecrof round, so he has prepared m problems for the round. Let's number the problems with integers 1 through m. George estimates the i-th problem's complexity by integer bi.

To make the round good, he needs to put at least n problems there. Besides, he needs to have at least one problem with complexity exactly a1, at least one with complexity exactly a2, ..., and at least one with complexity exactly an. Of course, the round can also have problems with other complexities.

George has a poor imagination. It's easier for him to make some already prepared problem simpler than to come up with a new one and prepare it. George is magnificent at simplifying problems. He can simplify any already prepared problem with complexity c to any positive integer complexity d (c≥d), by changing limits on the input data.

However, nothing is so simple. George understood that even if he simplifies some problems, he can run out of problems for a good round. That's why he decided to find out the minimum number of problems he needs to come up with in addition to the m he's prepared in order to make a good round. Note that George can come up with a new problem of any complexity.

Input
The first line contains two integers n and m (1≤n,m≤3000) — the minimal number of problems in a good round and the number of problems George's prepared. The second line contains space-separated integers a1,a2,...,an (1≤a1<a2<...<an≤106) — the requirements for the complexity of the problems in a good round. The third line contains space-separated integers b1,b2,...,bm (1≤b1≤b2...≤bm≤106) — the complexities of the problems prepared by George.

Output
Print a single integer — the answer to the problem.

Examples
inputCopy
3 5
1 2 3
1 2 2 3 3
outputCopy
0
inputCopy
3 5
1 2 3
1 1 1 1 1
outputCopy
2
inputCopy
3 1
2 3 4
1
outputCopy
3
* */
public class GeorgeAndRound {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s3 = sc.nextLine();
        String s4 = sc.nextLine();
        int[] lens = java.util.Arrays.stream(s1.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr1 = java.util.Arrays.stream(s3.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr2 = java.util.Arrays.stream(s4.split(" ")).mapToInt(Integer::parseInt).toArray();


        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int j = 0;
        int ans = 0;
        for(int i =0; i < lens[0]; i++) {
            while(j < lens[1] && arr2[j] < arr1[i] ) {
                j++;
            }
            if(j >= lens[1]){
                ans++;
            }
            j++;
        }
        System.out.println(ans);

    }
}
