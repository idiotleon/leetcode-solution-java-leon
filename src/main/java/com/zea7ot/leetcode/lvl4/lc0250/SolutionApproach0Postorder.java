/**
 * https://leetcode.com/problems/count-univalue-subtrees/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/count-univalue-subtrees/discuss/67573/My-Concise-JAVA-Solution
 */
package com.zea7ot.leetcode.lvl4.lc0250;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0Postorder {
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        postorder(root, count);
        return count[0];
    }
    
    private boolean postorder(TreeNode node, int[] count){
        if(node == null) return true;
        
        boolean left = postorder(node.left, count);
        boolean right = postorder(node.right, count);
        if(left && right){
            if(node.left != null && node.val != node.left.val) return false;
            if(node.right != null && node.val != node.right.val) return false;
            
            ++count[0];
            return true;
        }
        return false;
    }
}