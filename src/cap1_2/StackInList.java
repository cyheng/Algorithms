package cap1_2;
import java.util.LinkedList;
import edu.princeton.cs.algs4.*;
import java.util.Iterator;
public class StackInList<Item> implements Iterable<Item>{

    private Node first;
    private int num;
    private class Node{
        Item item;
        Node next;
    };
    public boolean IsEmpty(){return first == null;}
    public int size() { return num; }
    public void push(Item item)
    {
        Node newnode = new Node();
        newnode.item = item;
        newnode.next = first;
        first = newnode;
        num++;
    }
    public Item pop()
    {
        Item item=first.item;
        first = first.next;
        num--;
        return item;
    }
    public Item peek()
    {
        return first.item;
    }
    public static boolean IsValid(String s)
    {
        StackInList<Character> stack = new StackInList<Character>();
        for( char c:s.toCharArray())
        {
            switch(c)
            {
            case '(':
            case '{':
            case '[':
                stack.push(c);break;
            case ')':
                if(stack.IsEmpty() || '(' != stack.pop()) return false;break;
            case '}':
                if(stack.IsEmpty() || '{' != stack.pop()) return false;break;
            case ']':
                if(stack.IsEmpty() || '[' != stack.pop()) return false;break;
            default: ;
            }
        }
        return stack.IsEmpty();
    }
    public Iterator<Item> iterator()
    {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>
    {
        private Node temp=first;
        public boolean hasNext()
        {
            return temp.next==null;
        }
        public void remove() {}
        public Item next()
        {
            Item item = temp.item;
            temp=temp.next;
            return item;
        }
    }
    
    
   public static void EvaluatePostfix(String str)
   {
       Stack<Character> stack = new Stack<Character>();
       for (char s:str.toCharArray()) {
           if      (s=='+') stack.push(s);
           else if (s=='*') stack.push(s);
           else if (s==')') StdOut.print(stack.pop() + " ");
           else if (s=='(') StdOut.print("");
           else                    StdOut.print(s + " ");
           }
           StdOut.println();
   }
   
 public static void main(String[] args) {
        // TODO �Զ����ɵķ������
        String s = StdIn.readLine();
        
        EvaluatePostfix(s);
        
    }

}
