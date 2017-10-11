package sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class Insertion extends SortTemplate {


    public static void sort(Comparable[] a) {

        int len = a.length;
        for(int i=1;i<len;i++)
        {
            for(int j=i; j>0 && less(a[j],a[j-1]); j--)
            {
                exch(a, j, j-1);
            }
        }     
    }
    public static void sort2(Comparable[] a) {

        int len = a.length;
        for(int i=1;i<len;i++)
        {
            Comparable temp = a[i];
            int j=i;
            for(; j>0 && less(temp,a[j-1]); j--)
            {
                a[j] = a[j-1];
            }
            a[j]=temp;
        }     
    }
    public static void sentinelSort(Comparable[] a)
    {
        int len = a.length;
        boolean isChange =false;
        for(int i=len-1;i>0;i--)
        {
            if(less(a[i],a[i-1]))
            {
                exch(a,i,i-1);
                isChange = true;
            }
        }
        if(!isChange) return;
        for(int i=2;i<len;i++)
        {
            for(int j=i; less(a[j],a[j-1]); j--)
            {
                exch(a, j, j-1);
            }
        }     
    }
    public static void sortShowByAnime(Comparable[] a) {
    
        StdDraw.enableDoubleBuffering();
        int len = a.length;
        for(int i=1;i<len;i++)
        {
            for(int j=i; j>0 && less(a[j],a[j-1]); j--)
            {
                StdDraw.clear();
                DrawShow(a, j, j-1);
                StdDraw.show();
                exch(a, j, j-1); 
                StdDraw.pause(500);
            }
        } 
    }

    public static void main(String[] args) {

        Double[] a = GeneratorRandomArray(10);
//        String[] a = args;
        sortShowByAnime(a);
        assert isAscSorted(a);
        show(a);
    }

}
