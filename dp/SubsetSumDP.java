package com.sandeepprabhakula.dp;

import java.io.*;

public class SubsetSumDP {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            String[] vals = br.readLine().split(" ");
            int n = Integer.parseInt(vals[0]);
            int s = Integer.parseInt(vals[1]);
            String[]temp = br.readLine().split(" ");
            int[] a = new int[n];
            for(int i=0;i<n;i++){
                a[i] = Integer.parseInt(temp[i]);
            }
            bw.write(subsetSum(a,n,s)+"\n");
        }
        bw.flush();
    }
    static boolean[][] dp = new boolean[1002][1002];
    public static String subsetSum(int[]a,int n,int s){
        for(int i=0;i<n;i++){
            for(int j=0;j<s;j++){
                if(i==0)dp[i][j] = false;
                if(j==0)dp[i][j] = true;
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<s+1;j++){

                // check if the
                if(a[i-1]<=j)dp[i][j] = dp[i-1][j-a[i-1]] || dp[i-1][j];
                else dp[i][j] = dp[i-1][j];
            }
        }
        if(dp[n][s])return "YES";
        return "NO";
    }
}