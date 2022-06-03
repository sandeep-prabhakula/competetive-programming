package com.sandeepprabhakula.dp;

import java.io.*;
import java.util.Stack;

public class LCS2 {
    // Longest Common Subsequence of two integer arrays
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[]dims = br.readLine().split(" ");
        int n = Integer.parseInt(dims[0]);
        int m = Integer.parseInt(dims[1]);
        int[] a = new int[n];
        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < n; ++i) {
            a[i] = Integer.parseInt(temp[i]);
        }
        String[] temps = br.readLine().split(" ");
        int[] b = new int[m];
        for (int i = 0; i < m; ++i) {
            b[i] = Integer.parseInt(temps[i]);
        }
        int[][] opt = new int[n + 1][m + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (a[i - 1] == b[j - 1]) {
                    opt[i][j] = opt[i - 1][j - 1] + 1;
                } else {
                    opt[i][j] = Math.max(opt[i][j - 1], opt[i - 1][j]);
                }
            }
        }
        //System.out.println(opt[n][m]);
        int i = n, j = m;
        Stack<Integer> stack = new Stack<>();
        while (i > 0 && j > 0) {
            if (a[i - 1] == b[j - 1]) {
                stack.push(a[i - 1]);
                i -= 1;
                j -= 1;
            } else if (opt[i][j - 1] >= opt[i - 1][j]) {
                j -= 1;
            } else if (opt[i][j - 1] < opt[i - 1][j]) {
                i -= 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        bw.write(sb.toString().trim()+"\n");
        bw.flush();
    }
}
