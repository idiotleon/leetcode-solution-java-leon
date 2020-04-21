/**
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 */
package main.java.lcidiot.lc1008;

import main.java.lcidiot.data_structure.tree.TreeNode;

public class SolutionApproachDFS {
    private int preIdx;
    
    public TreeNode bstFromPreorder(int[] preorder) {
        this.preIdx = 0;
        
        return dfs(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode dfs(int[] preorder, int lower, int upper){
        if(preIdx == preorder.length) return null;
        
        int val = preorder[preIdx];
        
        if(val < lower || val > upper) return null;
        
        this.preIdx++;
        TreeNode root = new TreeNode(val);
        root.left = dfs(preorder, lower, val);
        root.right = dfs(preorder, val, upper);
        
        return root;
    }
}