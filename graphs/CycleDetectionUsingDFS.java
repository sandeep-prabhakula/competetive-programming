package com.sandeepprabhakula.graphs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CycleDetectionUsingDFS {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>>list = new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjList(u,v,list);
        }
        boolean []vis = new boolean[n+1];
        boolean flag = util(n,vis,list);
        bw.write(flag+"\n");
        bw.flush();
    }
    public static boolean util(int n,boolean[]vis,List<List<Integer>>list){
        for(int i=1;i<=n;i++){
            if(!vis[i]){
                if(cycleDFS(i,-1,list,vis)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void adjList(int u, int v, List<List<Integer>>adj){
        adj.get(u).add(v);
        adj.get(v).add(v);
    }
    private static boolean cycleDFS(int i, int parent, List<List<Integer>> adj, boolean[] vis) {
        vis[i] = true;
        for(int k:adj.get(i)){
            if(!vis[i]){
                if(cycleDFS(k,i,adj,vis))return true;
            }else if(k!=parent)return true;
        }
        return false;
    }
}
