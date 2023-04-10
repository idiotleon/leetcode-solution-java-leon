/**
 * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/discuss/477095/Easy-DFS-solution/499726
 */
package com.idiotleon.leetcode.lvl2.lc1315;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFS1 {
    public int sumEvenGrandparent(TreeNode root) {
        // sanity check
        if(root == null) return 0;
        return dfs(root, null, null);
    }
    
    private int dfs(TreeNode node, TreeNode parent, TreeNode grandParent){
        if(node == null) return 0;
        
        int sum = grandParent == null ? 0 : node.val;
        TreeNode par = node.val % 2 == 0 ? node : null;
        
        return sum + dfs(node.left, par, parent) + dfs(node.right, par, parent);
    }
}