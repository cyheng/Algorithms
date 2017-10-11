package cap1_2;

import java.util.Iterator;
import edu.princeton.cs.algs4.*;
public class QueueInList<Item> implements Iterable<Item>{

    private Node first;
    private Node last;
    private int num;
    private class Node
    {
        Item item;
        Node next;

    }
    public int size()
    {
        return num;
    }
    public boolean IsEmpty()
    {
        return num==0;
    }
    public void enqueue(Item item)
    {
        Node temp = new Node();
        temp.item = item;
        temp.next = null;
        if(IsEmpty())//��һ��
            first=last=temp;
        else
        {
            last.next = temp;
            last=last.next;
        }
        num++;
    }
    public Item dequeue()
    {
        Item item = first.item;
        first = first.next;
        if(IsEmpty())
            last=null;
        num--;
        return item;
    }
    public Iterator<Item> iterator()
    {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>
    {
        private Node temp = first;
        @Override
        public boolean hasNext() {

            return temp==null;
        }

        @Override
        public Item next() {

            Item item = temp.item;
            temp=temp.next;
            return item;
        }
        public void remove() {}
    }
    public static void main(String[] args) {

        QueueInList<String> s;
        s = new QueueInList<String>();
        while(!StdIn.isEmpty())
        {
            String item =StdIn.readString();
            if(!item.equals("-"))
            s.enqueue(item);
            else if(!s.IsEmpty())
                StdOut.print(s.dequeue()+" ");
            StdOut.println("("+s.size()+" in queue"+")");
        }
        StdOut.print("The last of list:");
        while(!s.IsEmpty())
            StdOut.print(s.dequeue()+" ");
        
    }

}
