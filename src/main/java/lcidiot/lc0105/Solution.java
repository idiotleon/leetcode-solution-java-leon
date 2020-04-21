/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
package main.java.lcidiot.lc0105;

import java.util.HashMap;

import main.java.lcidiot.data_structure.tree.TreeNode;

class Solution {
    private int preIdx = 0;
    private int[] preorder;
    private HashMap<Integer, Integer> idxMap = new HashMap<Integer, Integer>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        
        for(int i = 0; i < inorder.length; i++)
            idxMap.put(inorder[i], i);
        
        return helper(0, inorder.length);
    }
    
    private TreeNode helper(int inorderLeft, int inorderRight){
        if(inorderLeft == inorderRight) return null;
        
        int rootVal = this.preorder[preIdx];
        TreeNode root = new TreeNode(rootVal);
        int index = idxMap.get(rootVal);
        
        preIdx++;
        root.left = helper(inorderLeft, index);
        root.right = helper(index + 1, inorderRight);
        
        return root;
    }
}