package com.sandeepprabhakula.dp;

import java.io.*;
import java.util.Arrays;

public class ScrambledString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String []temp = br.readLine().split(" ");
        String A = temp[0];
        String B = temp[1];
        bw.write(scrambledString(A,B)+"\n");
        bw.flush();
    }
    public static int scrambledString(String A,String B){

        return 1;
    }
}
