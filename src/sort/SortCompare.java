package sort;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;
public class SortCompare {

    public static double time(String alg,Comparable[] a)
    {
        Stopwatch timer = new Stopwatch();
        if(alg.equals("Insertion")) Insertion.sort(a);
        if(alg.equals("Selection")) Selection.sort(a);
        if(alg.equals("Shell")) Shell.sort(a);
        if(alg.equals("Merge")) Merge.sort(a);
        if(alg.equals("Quick")) Quick.sort(a);
        if(alg.equals("Heap")) Heap.sort(a);
        if(alg.equals("Insertion2")) Insertion.sentinelSort(a);
        return timer.elapsedTime();
    }
    //array[len] 使用算法排序num次的结果
    public static double timeRandomInput(String alg,int len,int num)
    {
        double total = 0.0;
        Double[] randomArray = new Double[len];
        for(int i = 0;i < num;i++)
        {
            for(int j = 0;j < len;j++)
                randomArray[j] = StdRandom.uniform();
            total += time(alg,randomArray);
        }
        return total;
    }
    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        String alg1 = "Heap";
        String alg2 = "Merge";
        int len = 1000;
        int num = 1000;
        double alg1Time = timeRandomInput(alg1, len, num);
        StdOut.println("alg1 finished!");
        double alg2Time = timeRandomInput(alg2, len, num);
        StdOut.printf("For %d random Doubles \n%s is ",len,alg1 );
        StdOut.printf("%.1f times faster than %s \n", alg2Time/alg1Time,alg2);
        StdOut.printf("%s is %.3f seconds\n",alg1,alg1Time);
        StdOut.printf("%s is %.3f seconds",alg2,alg2Time);
    }

}
