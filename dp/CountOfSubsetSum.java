package com.sandeepprabhakula.dp;

import java.io.*;

public class CountOfSubsetSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String [] temp = br.readLine().split(" ");
        int sum = Integer.parseInt(br.readLine());
        int[]a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = Integer.parseInt(temp[i]);
        }
        bw.write(subsetSum(a,n,sum)+"\n");
        bw.flush();

    }
    static int [][]dp = new int[1002][1002];
    public static int subsetSum(int[]a,int n,int s){
        for(int i=0;i<n;i++){
            for(int j=0;j<s;j++){
                if(i==0)dp[i][j] = 0;
                if(j==0)dp[i][j] = 1;
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<s+1;j++){

                // check if the
                if(a[i-1]<=j)dp[i][j] = dp[i-1][j-a[i-1]] + dp[i-1][j];
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][s];
    }
}
