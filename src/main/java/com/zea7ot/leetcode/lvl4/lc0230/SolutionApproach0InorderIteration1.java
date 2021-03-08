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

import java.util.ArrayDeque;
import java.util.Deque;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0InorderIteration1 {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }

            root = stack.pop();
            if (--k == 0)
                return root.val;
            root = root.right;
        }
    }
}