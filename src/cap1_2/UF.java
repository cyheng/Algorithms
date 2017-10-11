package cap1_2;

import edu.princeton.cs.algs4.*;
public class UF {
    private int[] id;//����,ֵ��ȴ�����ͨ
    private int count;//��������
    UF(int N)
    {
        count =N;
        id = new int[N];
        for(int i = 0; i < N; i++)
            id[i] = i;
    }
    //��p q ֮���������
    void union(int p,int q)
    {
        int pid = find(p);
        int qid = find(q);
        if(qid == pid)return;
        //������p�ķ������޸�Ϊq
        for(int i =0;i <id.length;i++)
        {
            if(id[i] == pid)
                id[i] = qid;
        }
        count--;
    }
    //p(0-n-1)���ڵķ����ı�ʶ��
    int find(int p )
    {
        return id[p];
    }
    //���p,q����ͬһ�������з���true
    boolean connected(int p,int q)
    {
        return find(p)==find(q);
    }
    //��ͨ����������
    int count()
    {
        return count;
    }
    
    //more faster
    //��id[]���ñ��node��ֱ���ҵ�һ��ָ���Լ���node
    //�㷨p142
    private int findRoot(int node)
    {
        while(node != id[node])
            node=id[node];
        return node;
    }
    //pnode ��Ϊqnode��һ���ӽڵ�
    public void union2(int p ,int q)
    {
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);
        if(pRoot == qRoot)
            return;
        id[pRoot] = qRoot;
        count--;
    }
    public static void main(String[] args) {
        // TODO �Զ����ɵķ������
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while(!StdIn.isEmpty())
        {
            StdOut.println("����������ֵ:");
            int p =StdIn.readInt();
            int q =StdIn.readInt();
            if(uf.connected(p,q)) continue;
            uf.union(p, q);//û���ӣ���������
            StdOut.println(p+" "+q);
        }
        StdOut.println(uf.count() + " "+"components");
    }

}
