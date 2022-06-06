package com.sandeepprabhakula.graphs;

import java.util.*;

public class shortestDistanceInUnDirectedGraph {
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
            adj.get(v).add(u);
        }
        int src = sc.nextInt();
        int des = sc.nextInt();
        shortestPath(adj,n,src,des);
    }

    private static void shortestPath(List<List<Integer>> adj, int n,int src,int des) {
        int []vis = new int[n];
        Arrays.fill(vis,Integer.MAX_VALUE);
        if(vis[src]==Integer.MAX_VALUE)findPath(adj,src,vis);
        System.out.println(vis[des]);
    }

    private static void findPath(List<List<Integer>> adj, int i, int[] vis) {
        Queue<Integer>q = new LinkedList<>();
        q.add(i);
        vis[i] = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int k:adj.get(node)){
                if(vis[node]+1<vis[k]) {
                    q.add(k);
                    vis[k] = vis[node]+1;
                }
            }
        }
    }
}