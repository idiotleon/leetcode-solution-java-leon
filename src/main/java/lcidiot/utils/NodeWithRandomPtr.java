package main.java.lcidiot.utils;

public class NodeWithRandomPtr{
    public int val;
    public NodeWithRandomPtr next;
    public NodeWithRandomPtr random;

    public NodeWithRandomPtr(int val){
        this.val = val;
        this.next = null;
        this.random = null;
    }
}