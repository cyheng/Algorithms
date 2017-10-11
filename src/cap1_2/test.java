package cap1_2;

import edu.princeton.cs.algs4.*;
public class test {
    public static String m(String s)
    {
        int N=s.length();
        if(N<=1) return s;
        String a=s.substring(0, N/2);
        String b=s.substring(N/2, N);
        return m(b)+m(a);
    }
    public static void main(String[] args) {
        // TODO �Զ����ɵķ������
        String s1="hello world";
        String a=m(s1);
        StdOut.println(a);
    }

}
