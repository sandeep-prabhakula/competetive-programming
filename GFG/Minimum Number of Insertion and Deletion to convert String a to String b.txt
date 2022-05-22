package com.sandeepprabhakula.dp;

import java.io.*;

public class MinNumberOfDeletionAndInsertion {
    // Find the minimum number of insertions and deletions to convert String a -> String b
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[]temp = br.readLine().split(" ");
        String a = temp[0];
        String b = temp[1];
        int n = a.length();
        int m = b.length();
        int l = lcs(a,b,n,m);
        bw.write(l+"\n");
        bw.write("Deletion : "+(n-l)+"\n");
        bw.write("Insertion : "+(m-l)+"\n");
        bw.flush();
    }
    public static int lcs(String a,String b,int n,int m){
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0 || j==0)dp[i][j] = 0;
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(a.charAt(i-1)==b.charAt(j-1))dp[i][j] = 1+dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[n][m];
    }
}
