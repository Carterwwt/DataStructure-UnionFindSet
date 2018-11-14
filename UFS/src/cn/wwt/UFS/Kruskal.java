package cn.wwt.UFS;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * ������ʾ�˻��ڲ��鼯��Kruskal��С�������㷨
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

        System.out.println("����������ͼ�Ķ�������ͱߵ�����: ");
        int numberOfVertex = src.nextInt();
        int numberOfEdges = src.nextInt();

        uf = new UnionSet(numberOfVertex);
        graph = new Graph(numberOfEdges,numberOfVertex);

        System.out.println("����������ÿ���ߵ���㣬�յ��Ȩֵ: ");
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

        graph.sortEdgeByWeight(); // ��Ȩֵ��С��������
        System.out.println("��Ȩֵ��С�������к��ͼ��");
        graph.printGraph();

        int count = 1;
        System.out.println("\nKruskal�㷨��ʵ��: \n");

        for(int i=0;i<graph.getNumberOfEdges();i++) {

            ArrayList<Edge> edges = graph.getEdges();
            Edge edge = edges.get(i);
            int selfVertex = edge.getSelfVertex()-1;
            int nextVertex = edge.getNextVertex()-1;

            boolean isunion = uf.isUnion(selfVertex,nextVertex);

            if(isunion)
                continue;

            //�������һ�����ϣ�ִ�н��µ����
            uf.union(selfVertex,nextVertex); // �ϲ�
            System.out.println("��"+ count++ + "��ѡ�еı�: " + edge.toString());
            int newSum = graph.getSum() + edge.getWeight();
            graph.setSum(newSum);
        }
        System.out.println("\nȨֵ�ͣ� " + graph.getSum());

    }

}
