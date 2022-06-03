package com.sandeepprabhakula.dp;

import java.io.*;
import java.util.Arrays;

public class UnBoundedKnapSack {
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String [] tempVal = br.readLine().split(" ");
        String [] tempWt = br.readLine().split(" ");
        int wt = Integer.parseInt(br.readLine());
        int[]val = new int[n];
        int[]wts = new int[n];
        for(int i=0;i<n;i++){
            val[i] = Integer.parseInt(tempVal[i]);
        }
        for(int i=0;i<n;i++){
            wts[i] = Integer.parseInt(tempWt[i]);
        }
        for(int []i:t){
            Arrays.fill(i,-1);
        }
        bw.write(uks(val,wts,wt,n)+" ");
        bw.flush();
    }

    private static int uks(int[] val, int[] wt, int w, int n) {
        for(int i=0;i<n+1;i++){
            for(int j=0;j<w+1;j++){
                if(i==0||j==0)t[i][j] = 0;
            }
        }

        // convert recursive code to iterative
        for(int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){
                // use "t[i][j]" array instead of function call as in like "knapsack(val,wt,w,n-1)"

                // if wt[i-1] is valid
                if(wt[i-1]<=j)
                    t[i][j] = Math.max(val[i-1]+t[i][j-wt[i-1]],t[i-1][j]);

                    // if wt is not valid
                else
                    t[i][j] = t[i-1][j];
            }
        }
        return t[n][w];
    }

    static int[][] t = new int[1002][1002];
}
