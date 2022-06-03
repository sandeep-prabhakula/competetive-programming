package com.sandeepprabhakula.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CycleDetectionInDirectedGraphDFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>>adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
        }

        System.out.println(isCyclic(adj,n));
    }
    private static boolean isCyclic(List<List<Integer>> adj, int n){
        boolean []vis = new boolean[n];
        boolean []dfsVis = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                if(cycleDir(adj,i,vis,dfsVis))return true;
            }
        }
        return false;
    }
    private static boolean cycleDir(List<List<Integer>> adj, int i, boolean[] vis,boolean []dfsVis) {
        vis[i] = true;
        dfsVis[i] = true;
        for(int k:adj.get(i)){
            if(!vis[k]){
                if(cycleDir(adj,k,vis,dfsVis))return true;
            }else if(dfsVis[k])return true;
        }
        dfsVis[i] = false;
        return false;
    }
}
