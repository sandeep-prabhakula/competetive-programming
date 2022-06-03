package com.sandeepprabhakula.dp;

import java.io.*;

public class EqualSumPartition {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String [] temp = br.readLine().split(" ");
        int[]a = new int[n];
        int sum = 0;
        for(int i=0;i<n;i++){
            a[i] = Integer.parseInt(temp[i]);
            sum+=a[i];
        }
        if((sum&1)!=0)bw.write(false+"\n");
        else bw.write(equalPartition(a,sum/2)+"\n");
        bw.flush();
    }
    static boolean [][]dp = new boolean[1002][1002];
    public static boolean equalPartition(int[]a,int s){
        int n = a.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<s;j++){
                if(i==0)dp[i][j] = false;
                if(j==0)dp[i][j] = true;
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<s+1;j++){
                if(a[i-1]<=j)dp[i][j] = dp[i-1][j-a[i-1]] || dp[i-1][j];
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][s];
    }
}
