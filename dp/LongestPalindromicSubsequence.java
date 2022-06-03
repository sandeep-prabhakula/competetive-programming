package com.sandeepprabhakula.dp;

import java.io.*;

public class LongestPalindromicSubsequence {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String a = br.readLine();
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        String b = sb.reverse().toString();
        bw.write(lcs(a,b,a.length(),b.length())+" ");
        bw.flush();
    }

    private static int lcs(String a, String b, int n, int m) {
        int [][]dp = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0 || j==0)dp[i][j] = 0;
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(a.charAt(i-1)==b.charAt(j-1))dp[i][j] = 1+dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][m];
    }

}
