package com.sandeepprabhakula.dp;

import java.io.*;

public class PrintLCS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String a = br.readLine();
        String b = br.readLine();
        int n = a.length();
        int m = b.length();
        bw.write(printLcs(a,b,n,m)+"\n");
        bw.flush();
    }

    private static String printLcs(String a, String b, int n, int m) {
        int [][]dp = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0 || j==0)dp[i][j] = 0;
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(a.charAt(i-1)==b.charAt(j-1))dp[i][j] = 1+dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        int i = n;
        int j = m;
        String res = "";
        while (i>0 && j>0){
            if(a.charAt(i-1)==b.charAt(j-1)){
                res+=a.charAt(i-1);
                i--;
                j--;
            }else{
                if(dp[i][j-1]>dp[i][j])j--;
                else i--;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(res);
        return sb.reverse().toString();
    }
}
