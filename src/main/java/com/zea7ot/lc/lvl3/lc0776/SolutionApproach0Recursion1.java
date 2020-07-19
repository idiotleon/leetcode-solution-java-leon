/**
 * https://leetcode.com/problems/split-bst/
 * 
 * Time Complexity:     O(H)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/split-bst/discuss/114861/Java-Recursion-in-O(logn)/115833
 *  https://leetcode.com/problems/split-bst/discuss/114861/Java-Recursion-in-O(logn)/296292
 */
package com.zea7ot.lc.lvl3.lc0776;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0Recursion1 {
    public TreeNode[] splitBST(TreeNode root, int V) {
        if(root == null) return new TreeNode[]{null, null};
        
        /**
         * sub[0]: nodes with values > V
         * sub[1]: nodes with values <= V
         */
        if(root.val > V){
            TreeNode[] sub = splitBST(root.left, V);
            root.left = sub[1];
            return new TreeNode[]{sub[0], root};
        }else{
            TreeNode[] sub = splitBST(root.right, V);
            root.right = sub[0];
            return new TreeNode[]{root, sub[1]};
        }
    }
}