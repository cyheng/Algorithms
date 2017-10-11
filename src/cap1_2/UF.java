package cap1_2;

import edu.princeton.cs.algs4.*;
public class UF {
    private int[] id;//分量,值相等代表连通
    private int count;//分量数量
    UF(int N)
    {
        count =N;
        id = new int[N];
        for(int i = 0; i < N; i++)
            id[i] = i;
    }
    //在p q 之间添加连接
    void union(int p,int q)
    {
        int pid = find(p);
        int qid = find(q);
        if(qid == pid)return;
        //将所有p的分量都修改为q
        for(int i =0;i <id.length;i++)
        {
            if(id[i] == pid)
                id[i] = qid;
        }
        count--;
    }
    //p(0-n-1)所在的分量的标识符
    int find(int p )
    {
        return id[p];
    }
    //如果p,q存在同一个分量中返回true
    boolean connected(int p,int q)
    {
        return find(p)==find(q);
    }
    //连通分量的数量
    int count()
    {
        return count;
    }
    
    //more faster
    //把id[]放置别的node，直到找到一个指向自己的node
    //算法p142
    private int findRoot(int node)
    {
        while(node != id[node])
            node=id[node];
        return node;
    }
    //pnode 成为qnode的一个子节点
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
        // TODO 自动生成的方法存根
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while(!StdIn.isEmpty())
        {
            StdOut.println("请输入两个值:");
            int p =StdIn.readInt();
            int q =StdIn.readInt();
            if(uf.connected(p,q)) continue;
            uf.union(p, q);//没连接，相连它们
            StdOut.println(p+" "+q);
        }
        StdOut.println(uf.count() + " "+"components");
    }

}
