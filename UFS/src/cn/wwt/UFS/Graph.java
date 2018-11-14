package cn.wwt.UFS;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 这里是图的储存结构
 * Edge类包含了每条边的起点、终点和权值
 */


public class Graph {

    private ArrayList<Edge> edges ;
    private int numberOfEdges;
    private int numberOfVertex;

    private int sum = 0; //权值和

    public Graph(int numberOfEdges,int numberOfVertex) {
        this.numberOfEdges = numberOfEdges;
        this.numberOfVertex = numberOfVertex;
        edges = new ArrayList<>();
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    public int getNumberOfVertex() {
        return numberOfVertex;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getSum() {
        return sum;
    }

    public void addEdge(int selfVertex, int nextVertex, int weight, int id) {
        Edge edge = new Edge(selfVertex, nextVertex, weight, id);
        edges.add(edge);
    }

    public void printGraph() {
        for (Edge edge: edges) {
            System.out.println(edge.toString());
        }
    }

    public void sortEdgeByWeight() {
        SortEdge sortedge = new SortEdge();

        Collections.sort(edges,sortedge);
    }

}
