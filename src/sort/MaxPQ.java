package sort;

import edu.princeton.cs.algs4.StdOut;

public class MaxPQ<T extends Comparable<T>> {

    private T[] heaps;
    private int size=0;
    public MaxPQ(){
        heaps = (T[])new Comparable[1];
    }
    
    public MaxPQ(int max){
        heaps = (T[])new Comparable[max+1];
    }
    
    public MaxPQ(T[] a){
        size=a.length;
        heaps = (T[])new Comparable[size+1];
        for(int i=1 ; i <=size ;i++)
            heaps[i] = a[i];
    }
    public boolean isFull(){
        return size == heaps.length-1;
    }
    public void Insert(T v){
        if(isFull())
            resize(2*heaps.length);
        heaps[++size] = v;
        swim(size);
    }
    
    private void resize(int max) {
        // TODO 自动生成的方法存根
        T[] temp = (T [])new Comparable[max+1];
        for(int i=1;i<=size;++i)
            temp[i] = heaps[i];
        heaps = temp;
    }

    public T max(){
        return heaps[1];
    }
    
    public T deleteMax(){
        T max=heaps[1];
        heaps[1]=heaps[size--];
        heaps[size+1] =null;//防止游离
        sink(1);
        return max;
    }
    
    public boolean isEmpty(){
        return size==0;
    }
    
    public int size(){
        return size;
    }
    
    
    private void swim(int i){
        while(i> 1 &&less(i/2,i))
        {
            exch(i/2,i);
            i/=2;
        }
    }
    
    private void sink(int i){
        while(2*i <= size)
        {
            int child = 2*i;
            if(child<size && less(child,child+1)) child++;
            if(!less(i,child)) break;//父节点大于子节点，跳出
            exch(i,child);
            i=child;
        }
    }
    
    private void exch(int ls,int rs){
        T temp=heaps[ls];
        heaps[ls]=heaps[rs];
        heaps[rs]=temp;
    }
    
    private boolean less(int ls,int rs){
        return heaps[ls].compareTo(heaps[rs]) < 0;
    }
    
    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        MaxPQ<String> T=new MaxPQ();
        for(int i=0;i<10;i++)
            T.Insert(String.valueOf(i));
        
        StdOut.print(T.max());
            
        
    }

}
