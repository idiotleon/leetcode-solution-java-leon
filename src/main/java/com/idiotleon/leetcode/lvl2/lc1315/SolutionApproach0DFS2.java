/**
 * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/f
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/discuss/477095/Easy-DFS-solution
 */
package com.idiotleon.leetcode.lvl2.lc1315;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFS2 {
    public int sumEvenGrandparent(TreeNode root) {
        // sanity check
        if(root == null) return 0;
        
        int[] sum = {0};
        dfs(root, null, null, sum);
        return sum[0];
    }
    
    private void dfs(TreeNode node, TreeNode parent, TreeNode grandParent, int[] sum){
        if(node == null) return;
        
        if(grandParent != null && grandParent.val % 2 == 0){
            sum[0] += node.val;
        }
        
        dfs(node.left, node, parent, sum);
        dfs(node.right, node, parent, sum);
    }
}