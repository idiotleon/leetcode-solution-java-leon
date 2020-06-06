package com.zea7ot.data_structure.tree;

public class TreeNodeWithNextPtr{
    public int val;
    public TreeNodeWithNextPtr next;
    public TreeNodeWithNextPtr left;
    public TreeNodeWithNextPtr right;
    
    public TreeNodeWithNextPtr(int val){
        this.val = val;
        this.next = null;
        this.left = null;
        this.right = null;
    }
}