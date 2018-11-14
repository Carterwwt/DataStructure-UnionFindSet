package cn.wwt.UFS;

public class Edge {
    private int weight;
    private int selfVertex;
    private int nextVertex;
    private int id;

    public Edge (int selfVertex, int nextVertex, int weight, int id) {
        this.selfVertex = selfVertex;
        this.nextVertex = nextVertex;
        this.weight = weight;
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public int getId() {
        return id;
    }

    public int getSelfVertex() {
        return selfVertex;
    }

    public int getNextVertex() {
        return nextVertex;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setSelfVertex(int selfVertex) {
        this.selfVertex = selfVertex;
    }

    public void setNextVertex(int nextVertex) {
        this.nextVertex = nextVertex;
    }

    @Override
    public String toString() {
        return "selfVertex: " + selfVertex + "  nextVertex: " + nextVertex + "  weight: " + weight;
    }

}
