package com.sandeepprabhakula.dp;

import java.io.*;
import java.util.Arrays;

public class PalindromePartitioning {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int i = 0;
        int j = s.length()-1;
        for(int []ar:dp) Arrays.fill(ar,-1);
        bw.write(ppMemOptimized(s,i,j)+"\n");
        bw.flush();
    }

    private static int pp(String s, int i, int j) {
        if(i>j)return 0;
        if(isPalindrome(s,i,j))return 0;
        int ans = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int temp = pp(s,i,k)+pp(s,k+1,j)+1;
            ans = Math.min(temp,ans);
        }
        return ans;
    }
     private static boolean isPalindrome(String s,int i,int j){
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j))return false;
            i++;
            j--;
        }
        return true;
     }
     static int[][]dp = new int[101][101];
     private static int ppMem(String s,int i,int j){
        if(i>j)return 0;
        if(isPalindrome(s,i,j))return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int temp = 1+ppMem(s,i,k)+ppMem(s,k+1,j);
            ans = Math.min(ans,temp);
        }
        return dp[i][j] = ans;
     }

     private static int ppMemOptimized(String s,int i,int j){
         if(i>j)return 0;
         if(isPalindrome(s,i,j))return 0;
         if(dp[i][j]!=-1)return dp[i][j];
         int ans = Integer.MAX_VALUE;
         for(int k=i;k<=j-1;k++){
             int left = 0;
             if(dp[i][k]!=-1)left = dp[i][k];
             else left = ppMemOptimized(s,i,k);
             int right = 0;
             if(dp[k+1][j]!=-1)right = dp[k+1][j];
             else right = ppMemOptimized(s,k+1,j);
             int temp = 1+left+right;
             ans = Math.min(ans,temp);
         }
         return dp[i][j] = ans;
     }
}
