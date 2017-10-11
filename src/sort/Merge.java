package sort;

public class Merge extends SortTemplate {

    public static void sort(Comparable[] a) {
        Comparable[] copy = new Comparable[a.length];
        sort(a,0,a.length-1,copy);
    }
    //�鲢����--�������������������кϲ��������±��ƶ���
    public static void sort(Comparable[] a,int begin,int end,Comparable[] copy) {
        
        if(end <=begin)//�ݹ���˳�����
            return;
        int mid = begin +(end-begin)/2;
        sort(a,begin,mid,copy);
        sort(a,mid+1,end,copy);
        if(!less(a[mid+1],a[mid]))
            return;//��������������Ѿ�����������
        merge(a,begin,mid,end,copy);
    }
    //��֤[begin,mid-1],[mid,end]�Ѿ�����
    public static void merge(Comparable[] a,int begin,int mid,int end,Comparable[] copy)
    {
//        assert isSorted(a,begin,mid);
//        assert isSorted(a,mid+1,end);
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
       // assert isSorted(a,begin,end);
    }
    public static void quickMerge(Comparable[] dest,int begin,int mid,int end,
            Comparable[] copy)
    {
        int i=begin,j=end;
        for(int k=begin;k <=mid;k++)
            copy[k] = dest[k];
        for(int k=mid+1;k<=end;k++)
            copy[k]= dest[end+mid+1-k];
        for (int k = begin; k <= end; k++) {
            if (less(copy[j], copy[i])) {
                dest[k] = copy[j--];
            } else {
                dest[k] = copy[i++];
            }
        }
    }
    public static void main(String[] args) {
        // TODO �Զ����ɵķ������
        Double[] a = GeneratorRandomArray(50);
        sort(a);   
        assert isAscSorted(a);
        show(a);
    }

}
