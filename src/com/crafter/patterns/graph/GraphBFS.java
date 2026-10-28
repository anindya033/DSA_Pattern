package com.crafter.patterns.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphBFS {

    public static void main(String [] args){
        
        int[][] adj = {
            {1, 2},
            {0, 2},
            {0, 1, 3, 4},
            {2},
            {2}
        };
        int source = 0;
        List<Integer> bfsList = bfs(adj, source);
        bfsList.forEach(data-> System.out.println(data));


    }

    static List<Integer> bfs(int[][] adj, int start) {
        
        int [] arr = new int[adj.length];
        int source = start;
        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);
        List<Integer> returnlist = new ArrayList<>();

        while(! queue.isEmpty()){
            Integer head = queue.poll();
            int[] adjList = adj[head];
            for(int i : adjList){
                if(arr[i] != 1){
                    queue.add(i);
                    arr[i] = 1;
                    returnlist.add(i);
                }
            }
        }

        return returnlist;
    }
}