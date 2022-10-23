package com.ntnn.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class HackingTheRandomNumberGenerator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int res = 1;
        for(int i=0;i<n;i++)
        {
            int flag=0,mid;
            //binary search//
            int lb=0,ub=n-1;
            while(lb<=ub)
            {
                mid=(lb+ub)/2;
                if(arr[mid]==arr[i]+k)
                {
                    flag=1;
                    break;
                }
                else if(arr[mid]>arr[i]+k)
                    ub=mid-1;
                else
                    lb=mid+1;
            }
            if(flag==1)
                res+=1;
        }
        System.out.println(res);

    }
}
