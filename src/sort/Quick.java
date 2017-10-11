package sort;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Quick extends SortTemplate {

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }
    public static void sort(Comparable[] a,int begin,int end) {
        if(end<=begin) return;
        int div = partition(a,begin,end);
        sort(a,begin,div-1);
        sort(a,div+1,end);
    }
  //使数组[begin..i]<[i]<[i+1..end]变成这样的有序
    //注意[begin..i]内部并不有序，只是都比[i]小
    //i的位置取决于数组的内容
    private static int partition(Comparable[] a,int begin,int end)
    {
        
        int left=begin,right = end+1;
        Comparable val =a[begin];
        
        while(true)
        {
            //向右扫描,找到一个比val大的a[left]或者到结尾退出
            while(less(a[++left],val)) 
                if(left == end)
                    break;
            //向左扫描,找到一个比val小a[right]或者到开头退出
            while(less(val,a[--right]));
//                if(right == begin)
//                    break;
            //扫描完整个数组，退出
            if(left >=right)
                break;
            exch(a,left,right);
        }
        exch(a,begin,right);//放中间
        return right;
    }
   
    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        Double[] a = GeneratorRandomArray(50);
//      String[] a = args;
      sort(a);
      assert isAscSorted(a);
      show(a);
    }

}
