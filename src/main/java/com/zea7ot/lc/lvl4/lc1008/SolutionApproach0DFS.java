/**
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 * 
 * Time Complexity: O(N)
 *  N, the number of elements in the array
 * 
 * Space Complexity: O(2 * lg(N)) ~ O(lg(N))
 *  lg(N), the call stack
 *  lg(N), the tree, the answer itself
 */
package com.zea7ot.lc.lvl4.lc1008;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0DFS {
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