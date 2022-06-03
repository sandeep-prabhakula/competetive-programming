package com.sandeepprabhakula.graphs;

import java.util.*;

public class TopologicalSortUsingBFS {
    // Topological sort : Linear ordering of the nodes which having an edge u --> v where u appears first in the list then v;
    // TopologicalSort is only possible for "Directed Acyclic Graph"(DAG);
    // It is also called Kahn's Algorithm

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
    public static void topoSort(List<List<Integer>>adj,int n){
        // inDegree is number of nodes coming in to the node;
        int[]inDegree = new int[n];
        for(int i=0;i<n;i++){
            for(int it:adj.get(i)){
                inDegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inDegree[i]==0)q.add(i);
        }
        while(!q.isEmpty()){
            int node = q.poll();
            System.out.print(node+" ");
            for(int k:adj.get(node)){
                inDegree[k]--;
                if(inDegree[k]==0)q.add(k);
            }
        }
    }
}
