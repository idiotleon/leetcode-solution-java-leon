/**
 * @author: Leon
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * pseudocode:
 *  cur = root
 *  while cur is not null
 *      if not exists cur.left
 *          visit(cur)
 *          cur = cur.right
 *      else 
 *          predecessor = findInorderPredecessor(cur)
 *          if not exists predecessor.right
 *              predecessor.right = cur
 *              cur = cur.left
 *          else
 *              predecessor.right = null
 *              visit(cur)
 *              cur = cur.right
 * 
 * References:
 *  https://www.youtube.com/watch?v=wGXB9OWhPTg
 *  https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/MorrisTraversal.java
 */
package com.an7one.leetcode.lvl4.lc0230;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0MorrisInorderTraversal {
    public int kthSmallest(TreeNode root, int k) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                if (--k == 0)
                    return cur.val;
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
                    if (--k == 0)
                        return cur.val;
                    cur = cur.right;
                }
            }
        }

        return Integer.MIN_VALUE;
    }
}
