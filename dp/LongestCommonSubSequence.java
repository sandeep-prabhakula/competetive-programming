package com.sandeepprabhakula.dp;

import java.io.*;

public class LongestCommonSubSequence {
    // subsequence may not be in the contiguous order but should be in the sequential order
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String t = br.readLine();
        String s = br.readLine();
        int m = t.length();
        int n = s.length();
        bw.write(lcsMem(t, s, n, m) + "\n");
        bw.flush();
    }

    public static int lcsRec(String t, String s, int n, int m) {
        if (m == 0 || n == 0) return 0;
        if (s.charAt(n - 1) == t.charAt(m - 1)) {
            return 1 + lcsRec(t, s, n - 1, m - 1);
        }
        return Math.max(lcsRec(t, s, n - 1, m), lcsRec(t, s, n, m - 1));
    }

    static int dp[][] = new int[1006][1006];

    public static int lcsMem(String a, String b, int n, int m) {
        if (n == 0 || m == 0) return 0;
        if (dp[n][m] != -1) return dp[n][m];
        if (a.charAt(n - 1) == b.charAt(m - 1)) return dp[n][m] = 1 + lcsMem(a, b, n - 1, m - 1);
        return dp[n][m] = Math.max(lcsMem(a, b, n - 1, m), lcsMem(a, b, n, m - 1));
    }

    public static int lcsTab(String a,String b,int n,int m){
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
        return dp[n][m];
    }
}
