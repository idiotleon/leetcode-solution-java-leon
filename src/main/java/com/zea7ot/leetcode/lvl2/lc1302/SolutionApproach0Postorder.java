/**
 * https://leetcode.com/problems/deepest-leaves-sum/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/deepest-leaves-sum/discuss/463178/Java-Short-and-Concise/418492
 */
package com.zea7ot.leetcode.lvl2.lc1302;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0Postorder {
    public int deepestLeavesSum(TreeNode root) {
        // sanity check
        if(root == null) return 0;
        
        int[] maxDepth = {0};
        int[] sum = {0};
        postorder(root, maxDepth, sum, 0);
        
        return sum[0];
    }
    
    private void postorder(TreeNode node, int[] maxDepth, int[] sum, int curDepth){
        if(node == null) return;
        
        postorder(node.left, maxDepth, sum, curDepth + 1);
        postorder(node.right, maxDepth, sum, curDepth + 1);
        
        if(node.left == null && node.right == null){
            if(curDepth == maxDepth[0]){
                sum[0] += node.val;
            }else if(curDepth > maxDepth[0]){
                sum[0] = node.val;
                maxDepth[0] = curDepth;
            }
        }
    }
}