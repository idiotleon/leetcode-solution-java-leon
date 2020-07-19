/**
 * https://leetcode.com/problems/split-bst/
 * 
 * Time Complexity:     O(H)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/split-bst/discuss/114861/Java-Recursion-in-O(logn)
 */
package com.zea7ot.lc.lvl3.lc0776;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0Recursion {
    public TreeNode[] splitBST(TreeNode root, int V) {
        // sanity check
        if(root == null) return new TreeNode[]{null, null};
        
        TreeNode[] splitted;
        if(root.val <= V){
            splitted = splitBST(root.right, V);
            root.right = splitted[0];
            splitted[0] = root;
        }else{
            splitted = splitBST(root.left, V);
            root.left = splitted[1];
            splitted[1] = root;
        }
        
        return splitted;
    }
}