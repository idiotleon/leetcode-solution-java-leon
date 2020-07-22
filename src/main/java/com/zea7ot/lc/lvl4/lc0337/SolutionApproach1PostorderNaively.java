/**
 * https://leetcode.com/problems/house-robber-iii/
 * 
 * Time Complexity:     ?O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/house-robber-iii/discuss/79330/Step-by-step-tackling-of-the-problem
 */
package com.zea7ot.lc.lvl4.lc0337;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach1PostorderNaively {
    public int rob(TreeNode root) {
        if(root == null) return 0;
        
        int val = 0;
        
        if(root.left != null){
            val += rob(root.left.left) + rob(root.left.right);
        }
        
        if(root.right != null){
            val += rob(root.right.left) + rob(root.right.right);
        }
        
        return Math.max(val + root.val, rob(root.left) + rob(root.right));
    }
}