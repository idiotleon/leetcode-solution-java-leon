/**
 * https://leetcode.com/problems/invert-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/invert-binary-tree/discuss/62707/Straightforward-DFS-recursive-iterative-BFS-solutions
 */
package com.polyg7ot.lc.lvl2.lc0226;

import com.polyg7ot.data_structure.tree.TreeNode;

public class SolutionApproach0DFS {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        
        final TreeNode left = root.left, right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
}