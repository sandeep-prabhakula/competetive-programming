package com.sandeepprabhakula.dp;

import java.io.*;

public class CountTheNumberOfSubsetWithAGivenDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String [] temp = br.readLine().split(" ");
        int diff = Integer.parseInt(br.readLine());
        int sum = 0;
        int[]a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = Integer.parseInt(temp[i]);
            sum += a[i];
        }
        int s1 = (diff+sum)/2;
        bw.write(countSubsetSum(a,s1)+"\n");
        bw.flush();

    }
    private static int countSubsetSum(int[] a, int sum) {
        int[][]dp = new int[a.length+1][sum+1];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<sum;j++){
                if(i==0)dp[i][j] = 0;
                if(j==0)dp[i][j] = 1;
            }
        }
        for(int i=1;i<a.length+1;i++){
            for(int j=1;j<sum+1;j++){
                if(a[i-1]<=j)dp[i][j] = dp[i-1][j]+dp[i-1][j-a[i-1]];
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[a.length][sum];
    }
}
