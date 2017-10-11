package Symbol_Table;

import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Created by cyheng on 2017/8/30.
 */
//基于二叉搜索树的符号表
//key 不能为null
public class ST<Key extends Comparable<Key>,Value> {
    private Node  root;
    private class Node {
        Key key;
        Value value;
        Node lchild;
        Node rchild;
        int nodeNum;
        public Node(Key key, Value value, int nodeNum) {
            this.key = key;
            this.value = value;
            this.nodeNum = nodeNum;
        }
    }
    public ST(){
    }
    public boolean contains(Key key){
        return get(key) != null;
    }
    public boolean isEmpty(){
        return size() == 0;
    }

    private int size(Node root) {
        if(root == null) return 0;
        else return root.nodeNum;
    }

    public int size() {
        return size(root);
    }
    public void put(Key key,Value value)
    {
        if (key == null) throw new IllegalArgumentException("Key can't be null!");
        if (value == null) {
            delete(key);
            return;
        }
        root = put(root,key,value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) return new Node(key,value,1);
        int cmp = key.compareTo(node.key);
        if (cmp > 0) node.rchild = put(node.rchild,key,value);
        else if (cmp < 0) node.lchild = put(node.lchild,key,value);
        else node.value = value;
        node.nodeNum = size(node.lchild) + size(node.rchild) +1;
        return node;
    }


    public Value get(Key key){
        return get(root,key);
    }

    private Value get(Node node, Key key) {
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp > 0) return get(root.rchild,key);
        else if (cmp < 0) return get(root.lchild,key);
        else return node.value;
    }

    public void deleteMax() {
        if(isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMax(root);
    }

    private Node deleteMax(Node node) {
        if(node.rchild == null) return node.lchild;
        node.rchild = deleteMax(node.rchild);
        node.nodeNum = size(node.rchild) + size(node.lchild) +1;
        return node;
    }

    public void deleteMin() {
        if(isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMin(root);
    }
    public void delete(Key key){
        if (key == null)
            throw new IllegalArgumentException("key can't be null");
        else
            root=delete(root,key);
    }

    private Node deleteMin(Node node) {
        if (node.lchild == null) return node.rchild;
        node.lchild = deleteMin(node.lchild);
        node.nodeNum = size(node.rchild) + size(node.lchild) +1;
        return node;
    }
    private Node delete(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp > 0) node.rchild = delete(node.rchild,key);
        else if (cmp < 0) node.lchild = delete(node.lchild,key);
        else {             //判断删除的节点有几个子节点
            if (node.lchild == null) return node.rchild;
            if (node.rchild == null) return node.lchild;
            Node deleteNode = node;
            node = min(deleteNode.rchild);
            node.lchild = deleteNode.lchild;
            node.rchild = deleteMin(deleteNode.rchild);
        }

        node.nodeNum = size(node.rchild) + size(node.lchild) +1;
        return node;
    }



    private Node min(Node node) {
       if(node.lchild == null) return node;
       return min(node.lchild);
    }


    public Iterable<Key> keys(){
        return keys(min(),max());
    }
    public Key min(){
        if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
        return min(root).key;
    }

    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("called max() with empty symbol table");
        return max(root).key;
    }

    private Node max(Node node) {
        if(node.rchild == null) return node;
        return max(node.rchild);
    }

    //小于等于key的最大键
    public Key floor(Key key){
        if (key == null) throw new IllegalArgumentException("argument to floor() is null");
        if (isEmpty()) throw new NoSuchElementException("called floor() with empty symbol table");
        Node x = floor(root, key);
        if (x == null) return null;
        else return x.key;
    }

    private Node floor(Node node, Key key) {
        if(node == null) return null;
        int cmp = node.key.compareTo(key);
        if(cmp > 0) return floor(node.lchild,key);
        else if (cmp == 0) return node;
        Node lmax = floor(node.rchild,key);
        return  lmax == null ? node :lmax;
    }

    //大于key的最小键
    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to ceiling() is null");
        if (isEmpty()) throw new NoSuchElementException("called floor() with empty symbol table");
        Node x = ceiling(root, key);
        if (x == null) return null;
        else return x.key;
    }

    private Node ceiling(Node node, Key key) {
        if (node == null) return null;
        int cmp = node.key.compareTo(key);
        if(cmp < 0) return ceiling(node.rchild,key);
        else if (cmp == 0) return node;
        Node rmin = ceiling(node.rchild,key);
        return  rmin == null ? node :rmin;
    }


    /**
     * Return the kth smallest key in the symbol table.
     *
     * @param  k the order statistic
     * @return the {@code k}th smallest key in the symbol table
     * @throws IllegalArgumentException unless {@code k} is between 0 and
     *        <em>n</em>–1
     */
    public Key select(int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException("called select() with invalid argument: " + k);
        }
        Node x = select(root, k);
        return x.key;
    }

    // Return key of rank k.
    private Node select(Node x, int k) {
        if (x == null) return null;
        int t = size(x.lchild);
        if      (t > k) return select(x.lchild,  k);
        else if (t < k) return select(x.rchild, k-t-1);
        else            return x;
    }

    /**
     * Return the number of keys in the symbol table strictly less than {@code key}.
     *
     * @param  key the key
     * @return the number of keys in the symbol table strictly less than {@code key}
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to rank() is null");
        return rank(key, root);
    }

    // Number of keys in the subtree less than key.
    private int rank(Key key, Node x) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return rank(key, x.lchild);
        else if (cmp > 0) return 1 + size(x.lchild) + rank(key, x.rchild);
        else              return size(x.lchild);
    }




    public Iterable<Key> keys(Key low,Key high) {
        if (low == null) throw new IllegalArgumentException("first argument to keys() is null");
        if (high == null) throw new IllegalArgumentException("second argument to keys() is null");
        Queue<Key> queue = new LinkedList<Key>();
        keys(root,queue,low,high);
        return queue;
    }

    private void keys(Node node, Queue<Key> queue, Key low, Key high) {
        if (node == null) return;
        int cmplo = low.compareTo(node.key);
        int cmphi = high.compareTo(node.key);
        if (cmplo < 0) keys(node.lchild, queue, low, high);
        if (cmplo <= 0 && cmphi >= 0) queue.add(node.key);
        if (cmphi > 0) keys(node.rchild, queue, low, high);
    }

    public static void main(String[] args) {
        ST<String,Integer> st = new ST<>();
        for (int i = 0; !StdIn.isEmpty();i++){
            st.put(StdIn.readString(),i);
        }
        for (String s: st.keys())
            StdOut.println(s + "" +st.get(s));
    }
}
