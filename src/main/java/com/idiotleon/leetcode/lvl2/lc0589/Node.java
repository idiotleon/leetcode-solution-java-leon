package com.idiotleon.leetcode.lvl2.lc0589;

import java.util.List;

class Node {
    protected int val;
    protected List<Node> children;

    protected Node(int val){
        this.val = val;
    }

    protected Node(int val, List<Node> children){
        this.val = val;
        this.children = children;
    }
}