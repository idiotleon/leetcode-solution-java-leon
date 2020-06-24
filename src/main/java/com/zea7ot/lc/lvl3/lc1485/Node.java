package com.zea7ot.lc.lvl3.lc1485;

class Node {
    protected int val;
    protected Node left;
    protected Node right;
    protected Node random;

    protected Node(int val){
        this.val = val;
        this.left = this.right = this.random = null;
    }

    protected Node(int val, Node left, Node right, Node random){
        this.val = val;
        this.left = left;
        this.right = right;
        this.random = random;
    }
}