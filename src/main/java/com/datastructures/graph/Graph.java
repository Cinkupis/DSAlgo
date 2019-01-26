package com.datastructures.graph;

import com.datastructures.graph.nodes.GraphNode;
import com.datastructures.queue.MyQueue;

import java.util.*;

@SuppressWarnings("unused")
public class Graph {

    private GraphNode[] nodes;
    private int maxSize;
    private int size;

    public Graph() {
        this.maxSize = 2;
        this.size = 0;
        this.nodes = new GraphNode[maxSize];
    }

    public int getSize() {
        return size;
    }

    private void increaseSize() {
        this.maxSize *= 2;
        this.nodes = Arrays.copyOf(this.nodes, this.maxSize);
    }

    public void addDirectionalEdge(int fromNode, int toNode) {
        if (fromNode >= this.size || toNode >= this.size || fromNode < 0 || toNode < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.nodes[fromNode].adjacentNodes.add(toNode);
    }

    public void addVertex() {
        if (this.size == this.maxSize) {
            increaseSize();
        }
        this.nodes[this.size] = new GraphNode(size);
        this.size++;
    }

    public void addEdge(int node1, int node2) {
        if (node1 >= this.size || node2 >= this.size || node1 < 0 || node2 < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.nodes[node1].adjacentNodes.add(node2);
        this.nodes[node2].adjacentNodes.add(node1);
    }

    public GraphNode getNode(int node) {
        if (node >= this.size || node < 0) {
            throw  new ArrayIndexOutOfBoundsException();
        }

        return this.nodes[node];
    }

    public void removeNode(int nodeToRemove) {
        if (nodeToRemove >= this.size || nodeToRemove < 0) {
            throw  new ArrayIndexOutOfBoundsException();
        }
        for (int existingNode : this.nodes[nodeToRemove].adjacentNodes) {
            removeEdge(existingNode, nodeToRemove);
        }

        for (int i = nodeToRemove + 1; i < this.size; i++) {
            this.nodes[i - 1] = this.nodes[i];
        }
        this.size--;
    }

    public void removeEdge(int fromNode, int toNode) {
        this.nodes[fromNode].adjacentNodes.remove(toNode);
    }

    public void depthFirstTraversal(GraphNode node) {
        if (node == null) {
            return;
        }

        visit(node);
        for (int adjacentNode : node.adjacentNodes) {
            if (!this.nodes[adjacentNode].visited) {
                depthFirstTraversal(this.nodes[adjacentNode]);
            }
        }
        resetVisits();
    }

    public void breadthFirstTraversal(GraphNode node) {
        MyQueue<GraphNode> queue = new MyQueue<>();
        queue.add(node);
        node.marked = true;

        while (!queue.isEmpty()) {
            GraphNode next = queue.remove();
            visit(next);
            for (int adjacent : next.adjacentNodes) {
                GraphNode adjacentNode = this.nodes[adjacent];
                if (!adjacentNode.marked) {
                    adjacentNode.marked = true;
                    queue.add(adjacentNode);
                }
            }
        }
        resetVisits();
    }

    private void breadthFirstSearchStep(MyQueue<GraphNode> queue, boolean[] visits) {
        GraphNode next = queue.remove();
        visits[next.number] = true;
        for (int adjacent : next.adjacentNodes) {
            GraphNode adjacentNode = this.nodes[adjacent];
            if (!visits[adjacent]) {
                queue.add(adjacentNode);
            }
        }
    }

    private void resetVisits() {
        for (GraphNode node : this.nodes) {
            node.visited = false;
            node.marked = false;
        }
    }

    private void visit(GraphNode node) {
        System.out.println(node.number);
        node.visited = true;
        System.out.println(" -> ");
    }

    public boolean pathBetweenNodes(GraphNode fromNode, GraphNode toNode) {
        if (fromNode == null || toNode == null) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (fromNode.adjacentNodes.contains(toNode.number)) {
            return true;
        }
        return false;
    }

    private int isIntersection(boolean[] node1Visited, boolean[] node2Visited) {
        for (int i = 0; i < node1Visited.length; i++) {
            if (node1Visited[i] && node2Visited[i]) {
                return i;
            }
        }
        return -1;
    }

    public boolean pathBetweenNodes(int node1, int node2) {
        if (node1 >= this.size || node2 >= this.size || node1 < 0 || node2 < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (this.nodes[node1].adjacentNodes.contains(node2)) {
            return true;
        }

        boolean[] node1Visited = new boolean[this.nodes.length];
        boolean[] node2Visited = new boolean[this.nodes.length];

        MyQueue<GraphNode> node1Queue = new MyQueue<>();
        MyQueue<GraphNode> node2Queue = new MyQueue<>();

        node1Queue.add(this.nodes[node1]);
        node2Queue.add(this.nodes[node2]);
        int intersection = -1;

        while (!node1Queue.isEmpty() && !node2Queue.isEmpty()) {
            breadthFirstSearchStep(node1Queue, node1Visited);
            breadthFirstSearchStep(node2Queue, node2Visited);
            intersection = isIntersection(node1Visited, node2Visited);
            if (intersection != -1) {
                return true;
            }
        }
        return false;
    }
}
