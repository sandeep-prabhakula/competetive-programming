package com.sandeepprabhakula.dp;

import java.io.*;
import java.util.Arrays;

public class KnapSackMemoization {
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
        bw.write(ks(val,wts,wt,n)+" ");
        bw.flush();
    }
    static int[][] t = new int[1002][1002];
    public static int ks(int[]val, int[]wt, int C,int N){
        if(N==0 || C== 0)return 0;
        if(t[N][C]!=-1)return t[N][C];
        if(wt[N-1]<=C){
            return t[N][C] = Math.max(val[N-1]+ks(val,wt,C-wt[N-1],N-1),
                    ks(val,wt,C,N-1));
        }
        else return t[N][C] = ks(val,wt,C,N-1);
    }
}
