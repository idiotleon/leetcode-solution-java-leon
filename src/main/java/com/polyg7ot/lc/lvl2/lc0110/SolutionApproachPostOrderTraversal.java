/**
 * https://leetcode.com/problems/balanced-binary-tree/
 * 
 * Time Complexity: O(N)
 * https://leetcode.com/problems/balanced-binary-tree/discuss/35691/The-bottom-up-O(N)-solution-would-be-better/33930
 */
package com.polyg7ot.lc.lvl2.lc0110;

import com.polyg7ot.data_structure.tree.TreeNode;

public class SolutionApproachPostOrderTraversal {
    public boolean isBalanced(TreeNode root) {
        return postorder(root) != -1;
    }
    
    private int postorder(TreeNode node){
        if(node == null) return 0;
        
        int left = postorder(node.left);
        int right = postorder(node.right);
        
        if(left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        
        return Math.max(left, right) + 1;
    }
}