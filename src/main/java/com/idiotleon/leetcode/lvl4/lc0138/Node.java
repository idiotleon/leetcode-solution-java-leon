package com.idiotleon.leetcode.lvl4.lc0138;

class Node {
    protected int val;
    protected Node random;
    protected Node next;

    protected Node(int val) {
        this.val = val;
        this.random = null;
        this.next = null;
    }
}