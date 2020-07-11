/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/37010/Share-my-simple-NON-recursive-solution-O(1)-space-complexity!/35136
 *  https://www.youtube.com/watch?v=wGXB9OWhPTg
 *  https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/MorrisTraversal.java
 */
package com.zea7ot.lc.lvl3.lc0114;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0MorrisInorderTraversal {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while(cur != null){
            if(cur.left != null){
                TreeNode predecessor = cur.left;
                while(predecessor.right != null){
                    predecessor = predecessor.right;
                }

                predecessor.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }

            cur = cur.right;
        }
    }
}