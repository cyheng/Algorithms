package sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class TestIndexMinPQ {

    public static void merge(In[] streams)
    {
        int size=streams.length;
        IndexMinPQ<String> pq = new IndexMinPQ<>(size);
        
        for(int i=0;i<size;i++)
            if(!streams[i].isEmpty())
                pq.insert(i, streams[i].readString());
            
            while(!pq.isEmpty())
            {
                
                StdOut.println(pq.min());
                int i =pq.deleteMin();
                if(!streams[i].isEmpty())
                    pq.insert(i, streams[i].readString());
            }
        
    }
    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        int size=args.length;
        In[] streams= new In[size];
        for(int i = 0; i < size;i++)
            streams[i]=new In(args[i]);//输入流
        merge(streams);
    }

}
