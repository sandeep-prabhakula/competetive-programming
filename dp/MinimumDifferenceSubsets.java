package com.sandeepprabhakula.dp;

import java.io.*;
import java.util.ArrayList;

public class MinimumDifferenceSubsets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String [] temp = br.readLine().split(" ");
        ArrayList<Integer>a = new ArrayList<>();
        int sum = 0;
        for(int i=0;i<n;i++){
            a.add(Integer.parseInt(temp[i]));
            sum+=a.get(i);
        }
        ArrayList<Integer>ar;
        ar = subsetSum(a,sum);
        int min = Integer.MAX_VALUE;
        for(int i:ar){
            // subsetsum1+subsetsum2 = sum;
            // subsetSum2 = sum-subsetSum1
            //subsetsum1 + sum - subsetsum1 = sum;
            //sum = sum-2*subsetsum1;
            min = Math.min(min,Math.abs(sum-2*i));
        }
        bw.write(min+"\n");
        bw.flush();
    }
    public static ArrayList<Integer> subsetSum(ArrayList<Integer>a,int sum){
        boolean [][] dp = new boolean[a.size()+1][sum+1];
        for(int i=0;i<a.size();i++){
            for(int j=0;j<sum+1;j++){
                if(i==0 && j==0)dp[i][j] = true;
                else if(i==0)dp[i][j] = false;
                else if(j==0)dp[i][j] = true;
            }
        }
        for(int i=1;i<a.size()+1;i++){
            for(int j=1;j<sum+1;j++){
                if(a.get(i-1)<=j)dp[i][j] = dp[i-1][j]||dp[i-1][j-a.get(i-1)];
                else dp[i][j] = dp[i-1][j];
            }
        }
        ArrayList<Integer>list = new ArrayList<>();
        for(int i=0;i<sum+1;i++){
            if(dp[a.size()][i])list.add(i);
        }
        return list;
    }
}
