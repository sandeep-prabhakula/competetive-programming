package com.sandeepprabhakula.graphs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GraphImplementation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[]temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        // Adjacency Matrix

        int [][]mat = new int[n+1][n+1];
        for(int i=0;i<m;i++){
            String[]edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            adjMat(u,v,mat);
        }
        for (int[] ints : mat) {
            for (int anInt : ints) {
                bw.write(anInt + " ");
            }
            bw.write("\n");
        }

        List<List<Integer>>adj = new ArrayList<>();
        // Adjacency List
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            String[]edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            adjList(u,v,adj);
        }
        for(List<Integer>lis :adj){
            for(int i:lis)bw.write(i+" ");
            bw.write("\n");
        }
        bw.flush();
    }
    private static void adjMat(int u, int v, int [][]mat) {
        mat[u][v] = 1;
        mat[v][u] = 1;
    }
    public static void adjList(int u, int v, List<List<Integer>>adj){
        adj.get(u).add(v);
        adj.get(v).add(v);
    }
}