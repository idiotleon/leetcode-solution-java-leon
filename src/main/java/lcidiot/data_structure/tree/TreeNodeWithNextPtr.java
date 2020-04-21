package main.java.lcidiot.data_structure.tree;

public class TreeNodeWithNextPtr extends TreeNode{
    public TreeNodeWithNextPtr next;
    
    public TreeNodeWithNextPtr(int val){
        super(val);
        this.next = null;
    }
}