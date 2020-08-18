package com.zea7ot.leetcode.lvl3.lc1485;

class NodeCopy {
    protected int val;
    protected NodeCopy left;
    protected NodeCopy right;
    protected NodeCopy random;

    protected NodeCopy(int val){
        this.val = val;
        this.left = this.right = this.random = null;
    }

    protected NodeCopy(int val, NodeCopy left, NodeCopy right, NodeCopy random){
        this.val = val;
        this.left = left;
        this.right = right;
        this.random = random;
    }
}