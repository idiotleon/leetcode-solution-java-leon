package com.zea7ot.lc.lvl3.lc0708;

class Node {
    protected int val;
    protected Node next;

    protected Node(){}

    protected Node(int val){
        this.val = val;
    }

    protected Node(int val, Node next){
        this.val = val;
        this.next = next;
    }
}