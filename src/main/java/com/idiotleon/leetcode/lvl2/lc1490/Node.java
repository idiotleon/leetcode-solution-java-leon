package com.idiotleon.leetcode.lvl2.lc1490;

import java.util.ArrayList;
import java.util.List;

class Node {
    protected int val;
    protected List<Node> children;

    protected Node() {
        children = new ArrayList<Node>();
    }

    protected Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    protected Node(int _val, ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
}
