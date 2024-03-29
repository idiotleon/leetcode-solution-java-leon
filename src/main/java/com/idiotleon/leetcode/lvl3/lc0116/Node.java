package com.idiotleon.leetcode.lvl3.lc0116;

class Node {
    protected int val;
    protected Node left;
    protected Node right;
    protected Node next;

    protected Node(){}

    protected Node(int val){
        this.val = val;
    }

    protected Node(int val, Node left, Node right, Node next){
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}