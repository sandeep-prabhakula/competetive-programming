package com.sandeepprabhakula.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int n = 6;
        int a[] = {5,8,3,7,9,1};
        int res = longestIncreasingSubsequence(n, a);
        System.out.println(res);
    }

    public static int longestIncreasingSubsequence(int n, int[] a) {
        int[][] dp = new int[n][n + 1];
        for(int i[]:dp)Arrays.fill(i, -1);
        return f(a, 0, -1, dp, n);
    }

    public static int f(int[] a, int i, int prev, int[][] dp, int n) {
        if (i == n) return 0;
        if (dp[i][prev+1] != -1) return dp[i][prev+1];

        int nt = f(a,i+1,prev,dp,n);
        if (prev==-1 ||a[i] > a[prev]) {

            nt = Math.max(nt,1 + f(a, i + 1, i, dp, n));
        }

        return dp[i][prev+1] = nt;
    }
}
