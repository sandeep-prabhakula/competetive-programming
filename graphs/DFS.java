package com.sandeepprabhakula.graphs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DFS {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[]temp = br.readLine().trim().split("\\s+");
//        int n = Integer.parseInt(temp[0]);
//        int m = Integer.parseInt(temp[1]);
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>>list = new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
//            String[]edge = br.readLine().trim().split(" ");
//            int u = Integer.parseInt(edge[0]);
//            int v = Integer.parseInt(edge[1]);
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjList(u,v,list);
        }
        boolean []vis = new boolean[n+1];
        for(int i=1;i<=n;i++){
            if(!vis[i]){
                dfs(i,list,vis);
                bw.write("\n");
            }
        }
        bw.flush();
    }

    private static void dfs(int i, List<List<Integer>> list, boolean[] vis) throws IOException {
        bw.write(i+" ");
        vis[i] = true;
        for(int a:list.get(i)){
            if(!vis[a]){
                dfs(a,list,vis);
            }
        }
    }

    public static void adjList(int u, int v, List<List<Integer>>adj){
        adj.get(u).add(v);
        adj.get(v).add(v);
    }
}
