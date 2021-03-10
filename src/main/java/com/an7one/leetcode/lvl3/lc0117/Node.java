package com.an7one.leetcode.lvl3.lc0117;

class Node {
    protected int val;
    protected Node left;
    protected Node right;
    protected Node next;

    protected Node(int val) {
        this.val = val;
        this.left = this.right = this.next = null;
    }
}
