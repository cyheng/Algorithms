package cap1_2;

import edu.princeton.cs.algs4.*;
public class FixedCapacityStackOfString<item> {
    private item[] stack;
    private int N;
    public FixedCapacityStackOfString(int cap) {
        stack=(item[])new Object[cap];// TODO 自动生成的构造函数存根
    }
    private void resize(int max)
    {
        item[] temp =(item []) new Object[max];
        for(int i=0;i<N;i++)
            temp[i]= stack[i];
        stack=temp;
    }
    public void push(item Item)
    {
        if(IsFull())
            resize(2*stack.length);
        stack[N++]=Item;
    }
    public item pop()
    {
        item i = stack[--N];
        stack[N] = null;//避免游离
        if(N > 0 && N == stack.length/4)
            resize(stack.length/2);
        return i;
    }
    public boolean IsEmpty()
    {
        return N==0;
    }
    public boolean IsFull()
    {
        return N==stack.length;
    }
    public int size()
    {
        return N;
    }
    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        FixedCapacityStackOfString<String> s;
        s = new FixedCapacityStackOfString<String>(3);
        while(!StdIn.isEmpty())
        {
            String item =StdIn.readString();
            if(!item.equals("-"))
            s.push(item);
            else if(!s.IsEmpty())
                StdOut.print(s.pop()+" ");
            StdOut.println("("+s.size()+" in stack"+")");
        }
    }

}
