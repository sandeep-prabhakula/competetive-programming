package com.sandeepprabhakula.dp;

import java.io.*;

public class CoinChange1 {

    // find the number of ways to pick the coins so the sum of the coins is equal to "K"

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String [] temp = br.readLine().split(" ");
        int[]ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i] = Integer.parseInt(temp[i]);
        }
        int k = Integer.parseInt(br.readLine());
        bw.write(subsetSum(ar,k)+"\n");
        bw.flush();
    }
    public static int subsetSum(int[]ar,int k){
        int n = ar.length;
        int [][]dp = new int[n+1][k+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++){
                if(i==0)dp[i][j] = 0;
                if(j==0)dp[i][j] = 1;
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<k+1;j++){
                if(ar[i-1]<=j){
                    dp[i][j] = dp[i-1][j]+dp[i][j-ar[i-1]];
                }else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][k];
    }
}
