package com.sandeepprabhakula.dp;

import java.io.*;
public class KnapSack01Recursion {
    public static void main(String[]args)throws IOException{
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
        bw.write(knapSack(val,wts,wt,n)+" ");
        bw.flush();
    }
    public static int knapSack(int[]val,int[]wts,int wt,int n){
        if(n==0 || wt==0)return 0;
        if(wts[n-1]<=wt){
            return Math.max(val[n-1]+knapSack(val,wts,wt-val[n-1],n-1),knapSack(val,wts,wt,n-1));
        }
        else return knapSack(val,wts,wt,n-1);
    }
}
