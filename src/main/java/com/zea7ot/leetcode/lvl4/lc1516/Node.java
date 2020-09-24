package com.zea7ot.leetcode.lvl4.lc1516;

import java.util.ArrayList;
import java.util.List;

class Node {
    protected int val;
    protected List<Node> children;

    protected Node() {
        this.children = new ArrayList<>();
    }

    protected Node(int val) {
        this.val = val;
        this.children = new ArrayList<Node>();
    }

    protected Node(int val, ArrayList<Node> children) {
        this.val = val;
        this.children = children;
    }
}