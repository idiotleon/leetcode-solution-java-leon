/**
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-absolute-difference-in-bst/discuss/99905/Two-Solutions-in-order-traversal-and-a-more-general-way-using-TreeSet/104101
 */
package com.zea7ot.leetcode.lvl3.lc0530;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0MorrisInorder {
    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        int prev = Integer.MAX_VALUE;
        if(root == null) return min;
        TreeNode cur = root;
        while(cur != null){
            TreeNode predecessor = cur.left;
            if(predecessor != null) {
                while(predecessor.right != cur && predecessor.right != null)
                    predecessor = predecessor.right;
                
                if(predecessor.right == null){
                    predecessor.right = cur;
                    cur = cur.left;
                    continue;
                }else predecessor.right = null;
            }
            
            min = Math.min(min, Math.abs(cur.val - prev));
            prev = cur.val;
            cur = cur.right;
        }
        
        return min;
    }
}