/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/discuss/933835/Java.-Difference-from-236-is-you-need-to-search-the-entire-tree.
 */
package com.idiotleon.leetcode.lvl2.lc1644;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0PostorderRecursive {
    private int count = 0;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = postorder(root, p, q);
        return count == 2 ? lca : null;
    }
    
    private TreeNode postorder(TreeNode node, TreeNode p, TreeNode q){
        if(node == null) return null;
        TreeNode left = postorder(node.left, p, q);
        TreeNode right = postorder(node.right, p, q);
        if(node == p || node == q){
            ++count;
            return node;
        }
        
        return left == null ? right: right == null ? left: node;
    }
}
