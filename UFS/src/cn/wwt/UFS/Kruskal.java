package cn.wwt.UFS;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * 这里演示了基于并查集的Kruskal最小生成树算法
 */

public class Kruskal {

    private UnionSet uf;
    private Graph graph;

    public void kruskal() {
        handleInput();
        solve();
    }

    public void handleInput() {

        Scanner src = new Scanner(System.in);

        System.out.println("请依次输入图的顶点个数和边的条数: ");
        int numberOfVertex = src.nextInt();
        int numberOfEdges = src.nextInt();

        uf = new UnionSet(numberOfVertex);
        graph = new Graph(numberOfEdges,numberOfVertex);

        System.out.println("请依次输入每条边的起点，终点和权值: ");
        for(int i =0;i < graph.getNumberOfEdges();i ++) {

            int selfVertex,nextVertex,weight;

            selfVertex = src.nextInt();
            nextVertex = src.nextInt();
            weight = src.nextInt();

            graph.addEdge(selfVertex, nextVertex, weight,i);
        }

        src.close();

    }

    public void solve() {

        graph.sortEdgeByWeight(); // 按权值从小到大排列
        System.out.println("按权值从小到大排列后的图：");
        graph.printGraph();

        int count = 1;
        System.out.println("\nKruskal算法的实现: \n");

        for(int i=0;i<graph.getNumberOfEdges();i++) {

            ArrayList<Edge> edges = graph.getEdges();
            Edge edge = edges.get(i);
            int selfVertex = edge.getSelfVertex()-1;
            int nextVertex = edge.getNextVertex()-1;

            boolean isunion = uf.isUnion(selfVertex,nextVertex);

            if(isunion)
                continue;

            //如果不在一个集合，执行接下的语句
            uf.union(selfVertex,nextVertex); // 合并
            System.out.println("第"+ count++ + "挑选中的边: " + edge.toString());
            int newSum = graph.getSum() + edge.getWeight();
            graph.setSum(newSum);
        }
        System.out.println("\n权值和： " + graph.getSum());

    }

}
