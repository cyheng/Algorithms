package sort;

public class MergeBu extends SortTemplate {

    private static Comparable[] copy;
    public static void merge(Comparable[] a,int begin,int mid,int end)
    {
        int arrayIndex1 =begin;
        int arrayIndex2 =mid+1;

        for(int i =begin;i<=end;i++)
            copy[i]=a[i];
        for(int i=begin;i<= end;i++)
        {
            if(arrayIndex1>mid)
                a[i]=copy[arrayIndex2++];
            else if(arrayIndex2>end)
                a[i]=copy[arrayIndex1++];
            else if(less(copy[arrayIndex2],copy[arrayIndex1]))
                a[i]=copy[arrayIndex2++];
            else
                a[i]=copy[arrayIndex1++];
        }
    }
    public static void sort(Comparable[] a)
    {
        int len = a.length;
        copy = new Comparable[len];
        for(int sz=1 ; sz < len; sz = sz+ sz)//子数组的大小
            for(int begin = 0;begin <len -sz;begin +=sz+sz)//子数组的下标[0-1],[2-3]...
                merge(a,begin,begin+sz-1,Math.min(begin+sz+sz-1, len-1));
    }
    public static void main(String[] args) {
        // TODO 自动生成的方法存根

    }

}
