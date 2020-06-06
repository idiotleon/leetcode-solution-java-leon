/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
package com.zea7ot.lc.lvl3.lc0105;

import java.util.HashMap;

import com.zea7ot.data_structure.tree.TreeNode;

public class SolutionApproachDFSTopDown {
    private int preIdx = 0;
    private int[] preorder;
    private HashMap<Integer, Integer> idxMap = new HashMap<Integer, Integer>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        
        for(int i = 0; i < inorder.length; i++){
            idxMap.put(inorder[i], i);
        }
        
        return dfs(0, inorder.length);
    }
    
    private TreeNode dfs(int inorderLeft, int inorderRight){
        if(inorderLeft == inorderRight) return null;
        
        int rootVal = this.preorder[preIdx];
        TreeNode root = new TreeNode(rootVal);
        int index = idxMap.get(rootVal);
        
        preIdx++;
        root.left = dfs(inorderLeft, index);
        root.right = dfs(index + 1, inorderRight);
        
        return root;
    }
}