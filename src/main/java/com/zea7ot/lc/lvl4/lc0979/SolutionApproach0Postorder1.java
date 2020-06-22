/**
 * https://leetcode.com/problems/distribute-coins-in-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/distribute-coins-in-binary-tree/discuss/221930/JavaC++Python-Recursive-Solution/224633
 *  https://leetcode.com/problems/distribute-coins-in-binary-tree/discuss/221930/JavaC%2B%2BPython-Recursive-Solution
 */
package com.zea7ot.lc.lvl4.lc0979;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0Postorder1 {
    public int distributeCoins(TreeNode root) {
        if(root == null) return 0;
        
        int[] moves = {0};
        dfs(root, moves);
        return moves[0];
    }
    
    private int dfs(TreeNode node, int[] moves){
        if(node == null) return 0;
        
        int left = dfs(node.left, moves), right = dfs(node.right, moves), cur = node.val - 1;
        moves[0] += Math.abs(left + right + cur);
        
        return left + right + cur;
    }
}