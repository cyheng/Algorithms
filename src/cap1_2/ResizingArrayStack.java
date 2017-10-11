package cap1_2;

import java.util.Iterator;
import edu.princeton.cs.algs4.*;
public class ResizingArrayStack<item> implements Iterable<item>{
    private item[] stack=(item [])new Object[1];
    private int N = 0;
    public boolean IsEmpty() { return N==0; }
    public boolean IsFull() { return N==stack.length; }
    private void resize(int max)
    {
        item[] temp = (item [])new Object[max];
        for(int i=0;i<N;++i)
            temp[i] = stack[i];
        stack = temp;
    }
    private class ReverseArrayIterator implements Iterator<item>
    {
        private int i =N;
        public boolean hasNext() { return i > 0 ;}
        public item next() { return stack[--i]; }
        public void remove() {}
    }
    public Iterator<item> iterator()
    {
        return new ReverseArrayIterator();
    }
    public void push(item i)
    {
        if(IsFull())
            resize(stack.length*2);
        stack[N++] = i; 
            
    }
    public item pop()
    {
        if(IsEmpty())
        {
            StdOut.println("No Elements");
            return null;
        }
        item i =stack[--N];
        stack[N] = null;
        if(N > 0 && N == stack.length/4)
            resize(stack.length/2);
        return i;
    }
    public static void main(String[] args) {
        ResizingArrayStack<String> s = new ResizingArrayStack<String>();
        while(!StdIn.isEmpty())
        {
            String temp = StdIn.readString();
            s.push(temp);
        }
        for(String i:s)
            StdOut.println(i);
    }

}
