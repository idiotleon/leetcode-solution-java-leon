package com.an7one.leetcode.lvl3.lc0133;

import java.util.ArrayList;
import java.util.List;

class Node {
    protected int val;
    protected List<Node> neighbors;

    protected Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    protected Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    protected Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
