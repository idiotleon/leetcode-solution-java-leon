/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
package com.zea7ot.lc.lvl2.lc0111;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproachDFSBottomUp3 {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        
        if(root.left == null && root.right == null) return 1;
        
        int minDepth = Integer.MAX_VALUE;
        
        if(root.left != null){
            minDepth = Math.min(minDepth(root.left), minDepth);
        }
        
        if(root.right != null){
            minDepth = Math.min(minDepth(root.right), minDepth);
        }
        
        return minDepth + 1;
    }
}