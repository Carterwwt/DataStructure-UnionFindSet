package cn.wwt.UFS;


    /**
     * UnionSet类中包含用来实现并查集结构的数组unionset
     * 里面有几个个方法：
     * 1.打印unionset (用于测试)
     * 2.查找父亲节点 (压缩路径)
     * 3.合并节点 (使用rank层数，进行合并优化)
     * 4.查询给定两个节点是否在同一集合
     */

public class UnionSet {
    private int[] unionset;
    private int[] rank;

    public UnionSet(int MAXN){
        InitSet(MAXN);
    }

    private void InitSet(int MAXN) {

        this.unionset = new int[MAXN];
        this.rank = new int[MAXN];

        for(int i=0;i<unionset.length;i++) {
            unionset[i] = i;
            rank[i] = 0;
        } // 初始化并查集

    }

    public void reset() {
        InitSet(unionset.length);
    }

    public void printSet(){
        for(int i=0;i<unionset.length;i++)
            System.out.println("Current: " + i + "     " + "Father: " + unionset[i] + "      " + "Rank: " + rank[i]);
    }//打印


    public int find(int cur) {
        if(unionset[cur] == cur)
            return cur;
        else
            return (unionset[cur] = find(unionset[cur]));
    }//查找父亲节点并压缩路径

    public void union(int cur1, int cur2 ) {
        int uf1 = find(cur1), uf2 = find(cur2);
        if(uf1 == uf2) return;
        if(rank[uf1] > rank[uf2]) {
            unionset[uf2] = uf1;
        }
        else {
            unionset[uf1] = uf2;
            if(rank[uf1] == rank[uf2])  rank[uf2]++;
        } //将层数低的合并到高的层数上，当且仅当两个节点层数一样的时候，被合并的节点层数加一
    }

    public boolean isUnion(int cur1, int cur2) {
        int uf1 = find(cur1), uf2 = find(cur2);
        return (uf1 == uf2) ;
    }
}
