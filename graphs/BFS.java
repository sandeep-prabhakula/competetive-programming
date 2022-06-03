package com.sandeepprabhakula.graphs;

import java.io.*;
import java.util.*;

public class BFS {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[]temp = br.readLine().trim().split("\\s+");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);
        List<List<Integer>>list = new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            String[]edge = br.readLine().trim().split("\\s+");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            adjList(u,v,list);
        }
        boolean []vis = new boolean[n+1];
        for(int i=1;i<=n;i++){
            if(!vis[i]){
                bfs(i,list,vis);
            }
        }
        bw.flush();
    }

    private static void bfs(int i, List<List<Integer>> list,boolean []vis)throws IOException {
        Queue<Integer>q = new LinkedList<>();
        // make the source destination true;
        q.add(i);
        vis[i] = true;
        while(!q.isEmpty()){
            int temp = q.poll();
            bw.write(temp+" ");
            for(int a: list.get(temp)){
                if(!vis[a]) {
                    // make the every visited true;
                    vis[a] = true;
                    q.add(a);
                }
            }
        }
        bw.write("\n");
    }
    public static void adjList(int u, int v, List<List<Integer>>adj){
        adj.get(u).add(v);
        adj.get(v).add(v);
    }
}
