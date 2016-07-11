package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shawon on 7/10/16.
 */
public class Graph {
    private ArrayList<Integer> mat[];
    private ArrayList<Integer> cost[];
    private int[] indegree;
    private int[] outdegree;
    private boolean[] bfsVisited;
    private int numNodes;
    private int numEdges;

    public Graph() {}
    public Graph(int numNodes, int numEdges) {
        this.numNodes = numNodes + 1;
        this.numEdges = numEdges;

        mat = new ArrayList[this.numNodes];
        cost = new ArrayList[this.numNodes];

        outdegree = new int[this.numNodes];
        indegree = new int[this.numNodes];
        bfsVisited = new boolean[this.numNodes];

        Arrays.fill(outdegree, 0);
        Arrays.fill(indegree, 0);
        Arrays.fill(bfsVisited, false);


        for(int i = 1; i < this.numNodes; i++) {
            mat[i] = new ArrayList<>();
            cost[i] = new ArrayList<>();

            for(int j = 1; j < this.numNodes; j++) { cost[i].add(0); }
        }
    }

    public void add(int node1, int node2, int edge) {
        mat[node1].add(node2);
        cost[node1].add(node2, edge);
    }

    public void print() {
        for(int i = 1; i < numNodes; i++) {
            System.out.print("Node # " + (i) + " has >>>  ");

            for(int j = 1; j < cost[i].size(); j++) {
                if(cost[i].get(j) == 1) {
                    outdegree[i]++;
                    System.out.print(j + " ");
                }
            }
            System.out.println();

            for(int j = 1; j < numNodes; j++) {
                if(cost[j].get(i) == 1) indegree[i]++;
            }
        }

        System.out.println("outdegree : " + Arrays.toString(outdegree));
        System.out.println("indegree : " + Arrays.toString(indegree));

    }

    public int[] getIndegree() {
        return indegree;
    }

    public void setIndegree(int[] indegree) {
        this.indegree = indegree;
    }

    public int[] getOutdegree() {
        return outdegree;
    }

    public void setOutdegree(int[] outdegree) {
        this.outdegree = outdegree;
    }

    public int[] bfs(int source) {
        int[] distance = null;
        Queue<Integer> q = new LinkedList<>();
        int[] level = new int[numNodes];

        Arrays.fill(level, 0);
//        level[source] = 0;

        q.add(source);
        while(!q.isEmpty()) {
            int temp = q.remove();
            bfsVisited[temp] = true;
            for(int i = 0; i < mat[temp].size(); i++) {
                Integer t = mat[temp].get(i);
                if(level[t] == 0 && !bfsVisited[t]) {
                    level[t] = level[temp] + 1;
                    q.add(t);
                }
            }
        }

        distance = level;
        return distance;
    }

    public void callBFS() {
        for(int i = 1; i < numNodes; i++) {
            System.out.println("From Node # " + i + " : " + Arrays.toString(bfs(i)));
        }
    }
}
