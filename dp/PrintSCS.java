package com.sandeepprabhakula.dp;

import java.io.*;

public class PrintSCS {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String []temp = br.readLine().split(" ");
        String a = temp[0];
        String b = temp[1];
        int n = a.length();
        int m = b.length();
        lcs(a,b,n,m);
        String res = printSCS(a,b,n,m);
        StringBuilder sb = new StringBuilder(res);
        bw.write(sb.reverse() +"\n");
        bw.flush();
    }
    static int[][] dp;
    public static int lcs(String a,String b,int n,int m){
        dp = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0||j==0)dp[i][j] = 0;
                else if(a.charAt(i-1)==b.charAt(j-1))dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
    public static String printSCS(String a,String b,int n, int m){
        int i = n;
        int j = m;
        String res = "";
        while(i>0 || j>0){
            if(a.charAt(i-1)==b.charAt(j-1)){
                res+=a.charAt(i-1);
                i--;
                j--;
            }else {
                if(dp[i][j-1]>dp[i-1][j]){
                    res+=b.charAt(j-1);
                    j--;
                }else{
                    res+=a.charAt(i-1);
                    i--;
                }
            }
        }
        while(i>0){
            res+=a.charAt(i-1);
            i--;
        }
        while(j>0){
            res+=b.charAt(j-1);
            j--;
        }
        return res;
    }
}
