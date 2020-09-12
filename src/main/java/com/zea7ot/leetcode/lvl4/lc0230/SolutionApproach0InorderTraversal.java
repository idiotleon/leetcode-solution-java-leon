/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * The follow-up question makes this problem a 4-star.
 *  What if the BST is modified (insert/delete operations) 
 *  often and you need to find the kth smallest frequently? 
 *  How would you optimize the kthSmallest routine
 */
package com.zea7ot.leetcode.lvl4.lc0230;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0InorderTraversal {
    private int ans;
    private int count;

    public int kthSmallest(TreeNode root, int k) {
        this.count = k;
        this.ans = 0;

        inorder(root);

        return ans;
    }

    private void inorder(TreeNode node) {
        if (node == null)
            return;
        inorder(node.left);

        --count;
        if (count == 0) {
            ans = node.val;
            return;
        }

        inorder(node.right);
    }
}