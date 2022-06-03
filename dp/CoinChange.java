package com.sandeepprabhakula.dp;

import java.io.*;

public class CoinChange {
    // pick min no. of coins
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String []temp = br.readLine().split(" ");
        int[] ar = new int[temp.length];
        for(int i=0;i<ar.length;i++){
            ar[i] = Integer.parseInt(temp[i]);
        }
        int ans = minCoins(ar.length,ar,n);
        bw.write(ans+"\n");
        bw.flush();
    }
    public static int minCoins(int M, int[] coins,int V){
        int[][] dp = new int[M+1][V+1];
        for(int i=0;i<M+1;i++){
            for(int j=0;j<V+1;j++){
                if(i==0)dp[i][j] = Integer.MAX_VALUE;
                if(j==0)dp[i][j] = 0;
            }
        }
        for(int j=1;j<V+1;j++){
            if(j%coins[0]==0)dp[1][j] = j/coins[0];
            else dp[1][j] = Integer.MAX_VALUE-1;
        }
        for(int i=2;i<M+1;i++){
            for(int j=1;j<V+1;j++){
                if(coins[i-1]<=j){
                    dp[i][j] = Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
                }else dp[i][j] = dp[i-1][j];
            }
        }
        if(dp[M][V]==Integer.MAX_VALUE-1)return -1;
        return dp[M][V];
    }
}
