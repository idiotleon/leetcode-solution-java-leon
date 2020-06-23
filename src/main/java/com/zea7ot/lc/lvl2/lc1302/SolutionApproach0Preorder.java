/**
 * https://leetcode.com/problems/deepest-leaves-sum/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/deepest-leaves-sum/discuss/464774/Java-1ms-DFS-single-traversal-O(N)
 */
package com.zea7ot.lc.lvl2.lc1302;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0Preorder {
    public int deepestLeavesSum(TreeNode root) {
        // sanity check
        if(root == null) return 0;

        int[] maxDepth = {0};
        int[] sum = {0};
        preorder(root, maxDepth, sum, 0);
        
        return sum[0];
    }
    
    private void preorder(TreeNode node, int[] maxDepth, int[] sum, int curDepth){
        if(node == null) return;
        
        if(node.left == null && node.right == null){
            if(curDepth == maxDepth[0]){
                sum[0] += node.val;
            }else if(curDepth > maxDepth[0]){
                sum[0] = node.val;
                maxDepth[0] = curDepth;
            }
            // curDepth < maxDepth[0]
            // else return;
        }
        
        preorder(node.left, maxDepth, sum, curDepth + 1);
        preorder(node.right, maxDepth, sum, curDepth + 1);
    }
}