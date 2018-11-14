package cn.wwt.UFS;

        import java.util.Comparator;

/**
 * 这里创建了Edge自己的排序方法
 */

public class SortEdge implements Comparator<Edge> {
    @Override
    public int compare(Edge o1, Edge o2) {
        if (o1.getWeight() > o2.getWeight())
            return 1;
        else
            return -1;
    }
}
