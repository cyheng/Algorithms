package sort;

import edu.princeton.cs.algs4.StdDraw;

public class Shell extends SortTemplate {

    public static void sort(Comparable[] a)
    {
        int len = a.length;
        int h = 1;//将数组变成h有序
        while(h < len/3)
            h = 3*h+1;
        while( h >= 1)
        {
            for(int i = h;i < len;i++)//P164
                for(int j= i;j>=h && less(a[j],a[j-h]);j -=h)
                    exch(a,j,j-h);
            h = h/3;
        }
    }
    public static void sortByAnime(Comparable[] a)
    {
        StdDraw.enableDoubleBuffering();
        int len = a.length;
        int h = 1;//将数组变成h有序
        while(h < len/3)
            h = 3*h+1;
        while( h >= 1)
        {
            for(int i = h;i < len;i++)//P164
                for(int j= i;j>=h && less(a[j],a[j-h]);j -=h)
                {
                    exch(a,j,j-h);
                    StdDraw.clear();
                    StdDraw.textLeft(0.1,0.9, "h:"+h);
                    DrawShow(a, j, j-h);
                    StdDraw.show();
                    StdDraw.pause(500);
                }
            h = h/3;
        }
    }
    
    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        Double[] a = GeneratorRandomArray(50);
        sortByAnime(a);   
        assert isAscSorted(a);
        show(a);
    }

}
