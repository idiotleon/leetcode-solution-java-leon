package com.an7one.leetcode.lvl3.lc1612;

class Node {
   protected char val;
   protected  Node left;
   protected  Node right;

   protected   Node() {
        this.val = ' ';
    }

    protected   Node(char val) {
        this.val = val;
    }

    protected  Node(char val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
