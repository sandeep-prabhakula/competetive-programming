package com.sandeepprabhakula.graphs;

import java.util.*;

public class IsBipartiteBFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>>adj = new ArrayList<>();
        for(int i=1;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int []vis = new int[n];
        Arrays.fill(vis,-1);
        System.out.println(checkBFS(adj,n,vis));
    }
    public static boolean checkBFS(List<List<Integer>>adj,int n,int[]vis){
        for(int i=0;i<n;i++){
            if(vis[i]==-1){
                if(!isBipartite(adj,i,vis))return false;
            }
        }
        return true;
    }

    private static boolean isBipartite(List<List<Integer>> adj, int i, int[] vis) {
        Queue<Integer>q = new LinkedList<>();
        q.add(i);
        vis[i] = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int k:adj.get(node)){
                if(vis[k]==-1){
                    q.add(k);
                    if(vis[node]==0)vis[k] = 1;
                    else if(vis[node]==1)vis[k] = 0;
                }
                else if(vis[k]==vis[node])return false;
            }
        }
        return true;
    }
}
