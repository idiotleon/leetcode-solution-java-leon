/**
 * https://leetcode.com/problems/largest-bst-subtree/
 */
package com.zea7ot.lc.lvl3.lc0333;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproachDFSBottomUp {
    public int largestBSTSubtree(TreeNode root) {
        int[] res = largestBST(root);
        return res[2];
    }
    
    /**
     * 
     * @param node
     * @return the array
     *  [0] -> min
     *  [1] -> max
     *  [2] -> largest BST in its substree(inclusive)
     */
    private int[] largestBST(TreeNode node){
        if(node == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        
        int[] left = largestBST(node.left);
        int[] right = largestBST(node.right);
        if(node.val > left[1] && node.val < right[0]){
            return new int[]{Math.min(node.val, left[0]), 
                             Math.max(node.val, right[1]), 
                             left[2] + right[2] + 1};
        }else{
            return new int[]{Integer.MIN_VALUE, 
                             Integer.MAX_VALUE, 
                             Math.max(left[2], right[2])};
        }
    }
}