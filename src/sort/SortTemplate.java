package sort;
//import java.lang.Comparable;
import edu.princeton.cs.algs4.*;
public abstract class SortTemplate {

   public static boolean less(Comparable v,Comparable w)
   {return v.compareTo(w) <0; }
   
   public static void exch(Comparable[] a,int ls ,int rs)
   {
       Comparable t = a[ls];
       a[ls] = a[rs];
       a[rs] = t;
   }
   
   public static void show(Comparable []a)
   {
       for(int i = 0;i<a.length;i++)
           System.out.printf("%.2f ",a[i]);
       StdOut.println();
   }
   
   public static boolean isDescSorted(Comparable[] a)
   {
       for(int i=1;i<a.length;i++)
           if(less(a[i-1],a[i]))
               return false;
       return true;
   }
   public static boolean isAscSorted(Comparable[] a)
   {return !isDescSorted(a);}
   public static boolean isSorted(Comparable[] a,int begin,int end)
   {
       for(int i=begin+1;i<=end;i++)
           if(less(a[i-1],a[i]))
               return false;
       return true;
   }
   public static Double[] GeneratorRandomArray(int num)
   {
       int N=num;
       Double[] a = new Double[N];
       for(int i=0;i<N;i++)
           a[i]=StdRandom.uniform();
       return a;
   }
   public static Double[] GeneratorDoubles(int num)
   {
       int N=num;
       Double[] a = new Double[N];
       for(int i=0;i<N;i++)
           a[i]=StdRandom.uniform()*10000;
       return a;
   }
   public static void DrawShow(Comparable[] a)
   {
       StdDraw.setPenColor(StdDraw.GRAY);
       int len = a.length;
       for(int i  = 0; i< len ;i++)
       {
           
           double x = 1.0*i/len;
           double y = (Double)a[i]/2.0;
           double halfwidth = 0.5/len;
           double halfhigh = (Double)a[i]/2.0;         
           StdDraw.filledRectangle(x, y, halfwidth, halfhigh);
       }
   }
   public static void DrawShow(Comparable[] a,int ci1,int ci2)
   {  
       int len = a.length;
       
       for(int i  = 0; i< len ;i++)
       {
           double x = 1.0*i/len+0.5/len;
           double y = (Double)a[i]/2.0;
           double halfwidth = 0.5/len;
           double halfhigh = (Double)a[i]/2.0;     
           if(i==ci1 || i==ci2)
               StdDraw.setPenColor(StdDraw.RED);
           else
               StdDraw.setPenColor(StdDraw.GRAY);
           StdDraw.filledRectangle(x, y, halfwidth, halfhigh);
       }

   }

}
