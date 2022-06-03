package com.sandeepprabhakula.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class TopologicalSortUsingDFS {
    // Topological sort : Linear ordering of the nodes which having an edge u --> v where u appears first in the list then v;
    // TopologicalSort is only possible for "Directed Acyclic Graph"(DAG);
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
        topoSort(adj,n);
    }

    private static void topoSort(List<List<Integer>> adj, int n) {
        Stack<Integer>st = new Stack<>();
        boolean []vis = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                findTopoSort(adj,st,i,vis);
            }
        }
        while(!st.isEmpty()) System.out.print(st.pop()+" ");
    }

    private static void findTopoSort(List<List<Integer>> adj, Stack<Integer> st, int i,boolean []vis) {
        vis[i] = true;
        for(int k:adj.get(i)){
            if(!vis[k])findTopoSort(adj,st,k,vis);
        }
        st.push(i);
    }

}
