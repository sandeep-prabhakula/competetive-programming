package com.sandeepprabhakula.dp;

import java.io.*;

public class ShortestCommonSuperSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String a = br.readLine();
        String b = br.readLine();
        bw.write((a.length()+b.length())-lcs(a,b,a.length(),b.length())+" ");
        bw.flush();
    }
    public static int lcs(String a,String b,int n,int m){
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0||j==0)dp[i][j] = 0;
                else if(a.charAt(i-1)==b.charAt(j-1))dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
}
