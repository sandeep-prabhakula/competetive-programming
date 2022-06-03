package com.sandeepprabhakula.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IsBipartiteDFS {
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
        System.out.println(isBipartiteDFS(adj,n,vis));
    }

    private static boolean isBipartiteDFS(List<List<Integer>> adj, int n, int[] vis) {
        for(int i=0;i<n;i++){
            if(vis[i]!=-1){
                if(!checkDFS(adj,i,vis))return false;
            }
        }
        return true;
    }

    private static boolean checkDFS(List<List<Integer>> adj, int i, int[] vis) {
        if(vis[i]==-1)vis[i]=0;
        for(int k:adj.get(i)){
            if(vis[k]==-1){
                vis[k] = 1-vis[i];
                if(checkDFS(adj,k,vis))return false;

            }else if(vis[k]==vis[i])return false;
        }
        return true;
    }
}
