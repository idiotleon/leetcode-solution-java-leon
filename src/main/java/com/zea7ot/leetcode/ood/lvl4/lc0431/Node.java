package com.zea7ot.leetcode.ood.lvl4.lc0431;

import java.util.List;

class Node {
    protected int val;
    protected List<Node> children;

    protected Node() {
    }

    protected Node(int val) {
        this.val = val;
    }

    protected Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
