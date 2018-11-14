package cn.wwt.UFS;


    /**
     * UnionSet���а�������ʵ�ֲ��鼯�ṹ������unionset
     * �����м�����������
     * 1.��ӡunionset (���ڲ���)
     * 2.���Ҹ��׽ڵ� (ѹ��·��)
     * 3.�ϲ��ڵ� (ʹ��rank���������кϲ��Ż�)
     * 4.��ѯ���������ڵ��Ƿ���ͬһ����
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
        } // ��ʼ�����鼯

    }

    public void reset() {
        InitSet(unionset.length);
    }

    public void printSet(){
        for(int i=0;i<unionset.length;i++)
            System.out.println("Current: " + i + "     " + "Father: " + unionset[i] + "      " + "Rank: " + rank[i]);
    }//��ӡ


    public int find(int cur) {
        if(unionset[cur] == cur)
            return cur;
        else
            return (unionset[cur] = find(unionset[cur]));
    }//���Ҹ��׽ڵ㲢ѹ��·��

    public void union(int cur1, int cur2 ) {
        int uf1 = find(cur1), uf2 = find(cur2);
        if(uf1 == uf2) return;
        if(rank[uf1] > rank[uf2]) {
            unionset[uf2] = uf1;
        }
        else {
            unionset[uf1] = uf2;
            if(rank[uf1] == rank[uf2])  rank[uf2]++;
        } //�������͵ĺϲ����ߵĲ����ϣ����ҽ��������ڵ����һ����ʱ�򣬱��ϲ��Ľڵ������һ
    }

    public boolean isUnion(int cur1, int cur2) {
        int uf1 = find(cur1), uf2 = find(cur2);
        return (uf1 == uf2) ;
    }
}
