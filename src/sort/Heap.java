package sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
/**
 * 
 * �����±�k,
 * @author cyheng
 *
 */
public class Heap  {
    private Heap(){}
    public static void sort(Comparable[] a)
    {
        int len=a.length;
        buildHeap(a,len);
        sortHeap(a,len);
    }
    private static void buildHeap(Comparable[] a,int len){
        for(int i=len/2;i >=1; i--)
            sink(a,i,len); 
    }
    private static void sortHeap(Comparable[] a,int len){
        while(len > 1){
            exchange(a,1,len--);
            sink(a,1,len);
        }
    }
    private static void sink(Comparable[] a,int begin,int end){
        while(2*begin <= end){
            int child=2*begin;
            if(child<end &&  less(a,child,child+1))child++;
            if(!less(a,begin,child))break;
            exchange(a,begin,child);
            begin=child;
        }
    }
    
    private static  boolean less(Comparable[] a,int ls,int rs){
        return a[ls-1].compareTo(a[rs-1]) <0;
        
    }
    
    private static void exchange(Object[] pq, int i, int j) {
        Object swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }
    public static void show(Comparable []a)
    {
        for(int i = 0;i<a.length;i++)
            System.out.printf("%.2f ",a[i]);
        StdOut.println();
    }
    //a[1]...a[len]������Ч 
    public static boolean isDescSorted(Comparable[] a)
    {
        for(int i=2;i<a.length;i++)
            if(less(a,i-1,i))
                return false;
        return true;
    }
    public static boolean isAscSorted(Comparable[] a)
    {return !isDescSorted(a);}
    
    public static Double[] GeneratorRandomArray(int num)
    {
        int N=num;
        Double[] a = new Double[N];
        for(int i=0;i<N;i++)
            a[i]=StdRandom.uniform();
        return a;
    }
    
    public static void main(String[] args) {
        Double[] a = GeneratorRandomArray(50);
        sort(a);   
        assert isAscSorted(a);
        show(a);
    }

}
