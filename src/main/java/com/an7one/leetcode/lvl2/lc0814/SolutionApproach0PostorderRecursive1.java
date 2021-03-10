/**
 * https://leetcode.com/problems/binary-tree-pruning/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/binary-tree-pruning/discuss/122730/C++JavaPython-Self-Explaining-Solution-and-2-lines/247755
 */
package com.an7one.leetcode.lvl2.lc0814;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0PostorderRecursive1 {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) return null;
        if(postorder(root) == 0) return null;
        return root;
    }
    
    private int postorder(TreeNode node){
        if(node == null) return 0;
        
        int left = postorder(node.left);
        int right = postorder(node.right);
        node.left = left == 0 ? null : node.left;
        node.right = right == 0 ? null : node.right;
        return left + right + node.val;
    }
}