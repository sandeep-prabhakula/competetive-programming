package com.sandeepprabhakula.dp;

import java.io.*;

public class LongestCommonSubstring {
    // Substring the string must be contiguous
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String a = br.readLine();
        String b = br.readLine();
        int n = a.length();
        int m = b.length();
        bw.write(longestCommonSubString(a,b,n,m)+"\n");
        bw.flush();
    }

    private static int longestCommonSubString(String a, String b, int n, int m) {
        int [][]dp = new int[n+1][m+1];
        int max =0;
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0 || j==0)dp[i][j] = 0;
            }
        }
        for(int i=1;i<n+1;i++){
            for (int j=1;j<m+1;j++){
                if(a.charAt(i-1)==b.charAt(j-1))dp[i][j] = 1+dp[i-1][j-1];
                else dp[i][j] = 0;
                max = Math.max(dp[i][j],max);
            }
        }
        return max;
    }
}
