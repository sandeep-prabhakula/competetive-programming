package com.sandeepprabhakula.dp;

import java.io.*;
import java.util.Arrays;

public class MatrixChainMultiplication {

    // Format for solving mcm questions
    // 1. choose appropriate i and j values;
    // 2. find a base condition
    // 3. Iterate k between appropriate range between [i,j]
    // 4. solve the sub problems using recursion and apply the appropriate action for approaching the answer

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tem = br.readLine().split(" ");
        int n = tem.length;
        for(int []ar:dp){
            Arrays.fill(ar,-1);
        }
        int [] ar = new int[n];
        for(int i=0;i<n;i++)ar[i] = Integer.parseInt(tem[i]);
        bw.write(mcmMemo(ar,1,n-1)+"\n");
        bw.flush();
    }

    static int [][]dp = new int[101][101];
    private static int mcm(int[] ar, int i, int j) {
        if(i>=j)return 0;
        int min = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
          int tempAns = mcm(ar,i,k)+mcm(ar,k+1,j)+ar[i-1]*ar[k]*ar[j];
          if(min>tempAns)min = tempAns;
        }
        return min;
    }

    private static int mcmMemo(int[] ar, int i, int j) {
        if(i>=j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int tempAns = mcm(ar,i,k)+mcm(ar,k+1,j)+ar[i-1]*ar[k]*ar[j];
            if(min>tempAns)min = tempAns;
        }
        return dp[i][j] = min;
    }
}
