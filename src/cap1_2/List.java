package cap1_2;

import java.util.Iterator;
public class List<Item> implements Iterable<Item>{
    private class Node{
        Item item;
        Node next;
    }
    private Node first;
    private Node last;
    private int num;
    public boolean IsEmpty()
    {
        return first==null;
    }
    
    public int size()
    { return num; }
    
    public Item first()
    {
        if(IsEmpty())
            throw new RuntimeException("first is empty!");
        return first.item;
    }
    
    public Item last()
    {
        if(IsEmpty())
            throw new RuntimeException("Last is empty!");
        return last.item;
    }
    
    public Node Find(int k)
    {
        if(IsEmpty()) throw new RuntimeException("Empty list!");
        if(k >= num ||k <0) throw new RuntimeException("Node doesn't exist!");
        Node temp = first;
        for(int i=0;i<k;i++)
            temp=temp.next;
        return temp;
    }
    public Item removeFirst()
    {
        if(IsEmpty())
            throw new RuntimeException("Empty list");
        Item item = first.item;
        first = first.next;
        num--;
        if(IsEmpty()) last=null;
        
        return item;
    }
    public void prepend(Item item)
    {
        Node node = new Node();
        node.item = item;
        if(IsEmpty()) { first=node;last=node; }
        else
        {
            node.next = first;
            first = node;
        }
        num++;
    }
    public void append(Item item)
    {
        Node node = new Node();
        node.item = item;
        if(IsEmpty()) { first=node;last=node; }
        else
        {
            last.next = node;
            last = node;
        }
        num++;
    }
    
    public Item removeLast()
    {
        Item item;
        if(IsEmpty()) throw new RuntimeException("Empty list");
        if(first == last ) item=removeFirst();
        else{
        //num>=2
        Node pre = Find(num-2);//find last previous
        item = last.item;
        pre.next = null;
        last = pre;
        num--;
        }
        return item;
    }
    public Item delete(int k)
    {
        if(IsEmpty()) throw new RuntimeException("Empty list");
        if(k>=num || k<0) throw new RuntimeException("node doesn't exist");
        Item item;
        if(k==0) item = removeFirst();
        else
        {
        Node pre = Find(k-1);
        Node del = pre.next;
        item = del.item;
        pre.next = del.next;
        del.next = null;
        }
        return item;
    }
    
    
    @Override
    public Iterator<Item> iterator() {
        // TODO �Զ����ɵķ������
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>
    {
        private Node curr =first;
        @Override
        public boolean hasNext() {
            // TODO �Զ����ɵķ������
            return curr!=null;
        }

        @Override
        public Item next() {
            // TODO �Զ����ɵķ������
            Item item =curr.item;
            curr = curr.next;
            return item;
        }
        public void remove() {}
    }
public static void main(String[] args) {
        // TODO �Զ����ɵķ������

    }
}
