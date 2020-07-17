/**
 * https://leetcode.com/problems/binary-tree-tilt/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/binary-tree-tilt/discuss/102334/Java-Solution-post-order-traversal
 */
package com.zea7ot.lc.lvl2.lc0563;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0Postorder {
    private int ans;
    
    public int findTilt(TreeNode root) {
        postOrder(root);
        return ans;
    }
    
    private int postOrder(TreeNode node){
        if(node == null) return 0;
        
        int left = postOrder(node.left);
        int right = postOrder(node.right);
        
        ans += Math.abs(left - right);
        return left + right + node.val;
    }
}