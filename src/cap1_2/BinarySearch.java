package cap1_2;

import java.util.Arrays;
import java.util.LinkedList;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
public class BinarySearch {
    public static int rank(int key,int[] a)
    {
        int begin=0;
        int end=a.length-1;
        while(begin <= end)
        {
            int mid=begin+(end-begin)/2;
            if(key < a[mid])
                end=mid-1;
            else if(key > a[mid])
                begin=mid+1;
            else
                return mid;
        }
        return -1;
    }
    
    public static void main(String []argc)
    {
        int[] list=In.readInts(argc[0]);
        Arrays.sort(list);
        while(!StdIn.isEmpty())
        {
            int key = StdIn.readInt();
            if(rank(key,list) < 0)
                StdOut.println(key);
        }
    }
}
