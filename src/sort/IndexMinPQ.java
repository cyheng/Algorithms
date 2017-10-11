package sort;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class IndexMinPQ<T extends Comparable<T>> {
    
    private T[] heaps;
    private int size=0;
    private int maxIndex;
    private int[] indexs;//每个元素对应着heaps的下标
    private int[] reverseIndexs;//每个元素对应着indexs的下标
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
        if(contains(i))throw new IllegalArgumentException(i+"已存在元素");
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
        if(!contains(i)) throw new IllegalArgumentException("删除的元素的不存在");
        int index = reverseIndexs[i];
        exch(index, size--);//用最后一个元素替换当前位置
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
    public int deleteMin()//返回索引
    {
        if (size == 0) throw new NoSuchElementException("已经是空的了");
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
        // TODO 自动生成的方法存根 
        return heaps[indexs[ls]].compareTo(heaps[indexs[rs]])> 0 ;
    }

    private void swim(int i)
    {
        while(2*i <= size)
        {
            int child = 2*i;
            if(child<size && greatter(child,child+1)) child++;
            if(!greatter(i,child)) break;//父节点小于于子节点，跳出
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
        // TODO 自动生成的方法存根
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
