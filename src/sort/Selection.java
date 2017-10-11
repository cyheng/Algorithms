package sort;
import edu.princeton.cs.algs4.StdDraw;

public class Selection extends SortTemplate
{

    public static void main(String[] args) {
        
        Double[] a = GeneratorRandomArray(10);
        sortShowByAnime(a);
        assert isAscSorted(a);
        show(a);
    }
    
    public static void sort(Comparable[] a) {
        
        int len = a.length;
        for(int i = 0;i<len ; i++)
        {
            int min = i;
            for(int j =i+1;j<len;j++)
            {
                if(less(a[j],a[min]))
                    min = j;
            }
            
            exch(a, i, min);
        }    
 
    }
    public static void sortShowByAnime(Comparable[] a) {
        
        StdDraw.enableDoubleBuffering();
        
        int len = a.length;
        for(int i = 0;i<len ; i++)
        {
            StdDraw.clear();
            int min = i;
            for(int j =i+1;j<len;j++)
            {
                if(less(a[j],a[min]))
                    min = j;
            }
            DrawShow(a,i,min);
            StdDraw.show();
            exch(a, i, min);
            StdDraw.pause(500);
        }    
        
    }
    


}
