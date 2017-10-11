package sort;

public class Quick3way extends SortTemplate {

    private static void sort(Comparable[] a,int begin,int end){
        if(end<=begin)
            return;
        Comparable val = a[begin];
        int lpos=begin,rpos=end,mpos=begin+1;
        while(mpos <=rpos)
        {
            int cmp = a[mpos].compareTo(val);
            if(cmp<0) exch(a,mpos++,lpos);
            else if(cmp>0) exch(a,rpos--,mpos);
            else
                mpos++;
        }
        sort(a,begin,lpos-1);
        sort(a,rpos+1,end);
    }
    public static void main(String[] args) {


    }

}
