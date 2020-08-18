/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
package com.zea7ot.leetcode.lvl2.lc0104;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproachDFSTopDown {
    private int max;
    
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        max = 1;
        dfs(root, 1);
        return max;
    }
    
    private void dfs(TreeNode node, int curHeight){
        if(node == null) return;
        
        if(node.left != null){
            curHeight++;
            max = Math.max(max, curHeight);
            dfs(node.left, curHeight);
            curHeight--;
        }
        
        if(node.right != null){
            curHeight++;
            max = Math.max(max, curHeight);
            dfs(node.right, curHeight);
            curHeight--;
        }
    }
}