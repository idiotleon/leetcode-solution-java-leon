package com.idiotleon.util.data_structure.tree;

public class TreeNodeWithParentPointer {
    public int val;
    public TreeNodeWithParentPointer left, right, parent;

    public TreeNodeWithParentPointer(int val){
        this.val = val;
        this.left = this.right = this.parent = null;
    }
}