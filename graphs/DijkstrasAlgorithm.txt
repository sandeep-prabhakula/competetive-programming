package com.sandeepprabhakula.graphs;

import java.util.*;

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<PairD>>adj = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adj.get(u).add(new PairD(v,w));
            adj.get(v).add(new PairD(u,w));
        }
        dijkstra(adj, 0,n);
    }

    private static void dijkstra(ArrayList<ArrayList<PairD>> adj, int i,int n) {
        int[] dis = new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[0] = 0;
        PriorityQueue<PairD>pq = new PriorityQueue<>(n,new PairD());
        pq.add(new PairD(i,0));
        while(pq.size()>0){
            PairD p = pq.poll();
            for(PairD node:adj.get(p.getV())){
                if(dis[p.getV()]+node.getWeight()<dis[node.getV()]){
                    dis[node.getV()] = dis[p.getV()]+node.getWeight();
                    pq.add(new PairD(node.getV(),dis[node.getV()]));
                }
            }
        }
        for(int k:dis) System.out.print(k+" ");
    }
}
class PairD implements Comparator<PairD> {
    private int v ;
    private int weight;
    PairD(int v,int weight){
        this.v = v;
        this.weight = weight;
    }
    int getV(){
        return v;
    }
    int getWeight(){
        return weight;
    }
    PairD(){}
    @Override
    public int compare(PairD o1, PairD o2) {
        if(o1.weight<o2.weight)return -1;
        if(o1.weight>o2.weight)return 1;
        return 0;
    }
}
