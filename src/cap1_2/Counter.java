package cap1_2;

import edu.princeton.cs.algs4.StdOut;
public class Counter {
    private final String name;
    private int count;
    public Counter(String id)
    {name=id;}
    
    public void increment()
    { count++;}
    
    public int tally()
    {return count;}
    
    public String toString()
    {
        return count+" "+name;
    }
    public static void main(String[] args) {
        // TODO �Զ����ɵķ������
        Counter heads = new Counter("heads");
        heads.increment();
        heads.increment();
        StdOut.println(heads+" ");
        StdOut.println(heads.tally());
        
    }

}
