package com.datastructures.graph.nodes;


import java.util.HashSet;
import java.util.Set;

public class GraphNode {
    public Set<Integer> adjacentNodes;

    public int number;
    public boolean visited;
    public boolean marked;

    public GraphNode(int nextNumber) {
        this.number = nextNumber;
        this.visited = false;
        this.marked = false;
        this.adjacentNodes = new HashSet<>();
    }
}