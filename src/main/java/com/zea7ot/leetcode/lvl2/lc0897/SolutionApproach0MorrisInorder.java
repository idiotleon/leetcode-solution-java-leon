/**
 * @author: Leon
 * https://leetcode.com/problems/increasing-order-search-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/increasing-order-search-tree/discuss/165870/Java-Simple-InOrder-Traversal-with-Explanation
 */
package com.zea7ot.leetcode.lvl2.lc0897;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0MorrisInorder {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode head = null, prev = null;

        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                // check out once
                if (head == null) {
                    head = cur;
                }

                // no need since cur.left == null
                // cur.left = null;
                if (prev != null) {
                    prev.right = cur;
                }

                prev = cur;

                cur = cur.right;
            } else {
                TreeNode predecessor = cur.left;
                while (predecessor.right != cur && predecessor.right != null) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = cur;
                    cur = cur.left;
                } else {
                    predecessor.right = null;

                    // check out twice
                    if (head == null) {
                        head = cur;
                    }

                    // slightly different from the first checkout
                    cur.left = null;
                    
                    if (prev != null) {
                        prev.right = cur;
                    }

                    prev = cur;

                    cur = cur.right;
                }
            }
        }

        return head;
    }
}
