package cap1_2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickUnionUF {

    private int[] id;//��
    private int[] sz;//���Ĵ�С
    private int count;//��ͨ����
    public WeightedQuickUnionUF(int N)
    {
        count = N;
        id = new int[N];
        for(int i=0 ; i < N ; i++)
            id[i]=i;
        sz = new int[N];
        for(int i=0 ; i < N ; i++)
            sz[i]=i;
    }
    public int count()
    { return count; }
    public boolean connected(int lhs,int rhs)
    { return find(lhs)==find(rhs); }
    public int find(int root)
    {
        while(root != id[root])
            root = id[root];
        return root;
    }
    
    public void union(int lhs,int rhs)
    {
        int lRoot = find(lhs);
        int rRoot = find(rhs);
        if(lRoot == rRoot)
            return;
        //��Ȩ С���ĸ��ڵ����ӵ������ĸ��ڵ�
        if(sz[lRoot] <sz[rRoot])
        {
            id[lRoot] = rRoot;
            sz[rRoot] += sz[lRoot];
        }else
        {
            id[rRoot] = lRoot;
            sz[lRoot] += sz[rRoot];
        }
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
