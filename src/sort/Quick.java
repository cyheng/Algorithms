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
  //ʹ����[begin..i]<[i]<[i+1..end]�������������
    //ע��[begin..i]�ڲ���������ֻ�Ƕ���[i]С
    //i��λ��ȡ�������������
    private static int partition(Comparable[] a,int begin,int end)
    {
        
        int left=begin,right = end+1;
        Comparable val =a[begin];
        
        while(true)
        {
            //����ɨ��,�ҵ�һ����val���a[left]���ߵ���β�˳�
            while(less(a[++left],val)) 
                if(left == end)
                    break;
            //����ɨ��,�ҵ�һ����valСa[right]���ߵ���ͷ�˳�
            while(less(val,a[--right]));
//                if(right == begin)
//                    break;
            //ɨ�����������飬�˳�
            if(left >=right)
                break;
            exch(a,left,right);
        }
        exch(a,begin,right);//���м�
        return right;
    }
   
    public static void main(String[] args) {
        // TODO �Զ����ɵķ������
        Double[] a = GeneratorRandomArray(50);
//      String[] a = args;
      sort(a);
      assert isAscSorted(a);
      show(a);
    }

}
