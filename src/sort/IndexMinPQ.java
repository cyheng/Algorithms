package sort;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class IndexMinPQ<T extends Comparable<T>> {
    
    private T[] heaps;
    private int size=0;
    private int maxIndex;
    private int[] indexs;//ÿ��Ԫ�ض�Ӧ��heaps���±�
    private int[] reverseIndexs;//ÿ��Ԫ�ض�Ӧ��indexs���±�
    public IndexMinPQ(int maxIndex)
    {
        this.maxIndex=maxIndex;
        heaps=(T[])new  Comparable[maxIndex+1];
        indexs =new int[maxIndex+1];
        reverseIndexs = new int [maxIndex+1];
        for(int i=0;i <= maxIndex;i++)
            reverseIndexs[i]=-1;
    }
    
    public void insert(int i,T item)
    {
        if(i<0|| i>maxIndex) throw new IndexOutOfBoundsException();
        if(contains(i))throw new IllegalArgumentException(i+"�Ѵ���Ԫ��");
        size++;
        
        indexs[size]=i;
        reverseIndexs[i]=size;
        heaps[i]= item;
        swim(size);
    }
    
    public void change(int i,T item)
    {
        if (i < 0 || i > maxIndex) {
            throw new IndexOutOfBoundsException();
        }
        heaps[i]=item;
        swim(i);
        sink(i);
    }
    
    public boolean contains(int i)
    {
        return reverseIndexs[i] != -1;
    }
    
    public void delete(int i)
    {
        if (i < 0 || i > maxIndex) {
            throw new IndexOutOfBoundsException();
        }
        if(!contains(i)) throw new IllegalArgumentException("ɾ����Ԫ�صĲ�����");
        int index = reverseIndexs[i];
        exch(index, size--);//�����һ��Ԫ���滻��ǰλ��
        swim(index);
        sink(index);
        heaps[i] = null;
        reverseIndexs[i] = -1;
    }
    public T min()
    {
        return heaps[indexs[1]];
    }
    
    public int minIndex()
    {
        return indexs[1];
    }
    public int deleteMin()//��������
    {
        if (size == 0) throw new NoSuchElementException("�Ѿ��ǿյ���");
        int minIndex=indexs[1];
        exch(1,size--);
        sink(1);
        assert minIndex==reverseIndexs[size+1];
        reverseIndexs[minIndex]=-1;
        heaps[minIndex]=null;   
        indexs[size+1] = -1;
        return minIndex;
    }
    
    public boolean isEmpty()
    {
        return size==0;
    }
    
    public int size()
    {
        return size;
    }
    
    private void sink(int i)
    {
        while(i> 1 &&greatter(i/2,i))
        {
            exch(i/2,i);
            i/=2;
        }
    }
    
    private boolean greatter(int ls, int rs) {
        // TODO �Զ����ɵķ������ 
        return heaps[indexs[ls]].compareTo(heaps[indexs[rs]])> 0 ;
    }

    private void swim(int i)
    {
        while(2*i <= size)
        {
            int child = 2*i;
            if(child<size && greatter(child,child+1)) child++;
            if(!greatter(i,child)) break;//���ڵ�С�����ӽڵ㣬����
            exch(i,child);
            i=child;
        }
    }
    
    private void exch(int ls,int rs){
        //change index
        int temp=indexs[ls];
        indexs[ls]=indexs[rs];
        indexs[rs]=temp;
        //change index of indexs array
        reverseIndexs[indexs[ls]]=rs;
        reverseIndexs[indexs[rs]]=ls;
    }
    public static void main(String[] args) {
        // TODO �Զ����ɵķ������
        String[] strings = { "it", "was", "the", "best", "of", "times", "it", "was", "the", "worst" };

        IndexMinPQ<String> pq = new IndexMinPQ<String>(strings.length);
        for (int i = 0; i < strings.length-2; i++) {
            pq.insert(i, strings[i]);
        }

        // delete and print each key
        while (!pq.isEmpty()) {
            int i = pq.deleteMin();
            StdOut.println(i + " " + strings[i]);
        }
        StdOut.println();

        // reinsert the same strings
        for (int i = 0; i < strings.length; i++) {
            pq.insert(i, strings[i]);
        }
    }

 

}
