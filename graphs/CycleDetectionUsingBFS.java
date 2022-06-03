package com.sandeepprabhakula.graphs;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class CycleDetectionUsingBFS {
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

        //Driver code

        for(int i=1;i<=n;i++){
            if(!vis[i]){
                if(cycleBFS(i,list,vis)){
                    bw.write(true+"\n");
                }
            }
        }
        bw.flush();
    }
    public static void adjList(int u, int v, List<List<Integer>>adj){
        adj.get(u).add(v);
        adj.get(v).add(v);
    }

    public static boolean cycleBFS(int i,List<List<Integer>>list,boolean []vis){
        Queue<Pair> q =  new LinkedList<>(); //BFS
        q.add(new Pair(i, -1));
        vis[i] =true;

        while(!q.isEmpty())
        {
            int node = q.peek().node;
            int par = q.peek().prev;
            q.remove();

            for(Integer it: list.get(node))
            {
                if(!vis[it])
                {
                    q.add(new Pair(it, node));
                    vis[it] = true;
                }

                else if(par != it && par!=-1 && vis[it]) return true;
            }
        }
        return false;
    }
}
class Pair{
    int node ;
    int prev;
    Pair(int node,int prev){
        this.node = node;
        this.prev = prev;
    }
}