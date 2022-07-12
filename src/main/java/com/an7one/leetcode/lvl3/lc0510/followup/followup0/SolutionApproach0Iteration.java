package com.an7one.leetcode.lvl3.lc0510.followup.followup0;

import com.an7one.util.Constant;

/**
 * <a href="https://leetcode.com/problems/inorder-successor-in-bst-ii/">LC0510</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * <p>
 * References:
 * <a href="https://leetcode.com/problems/inorder-successor-in-bst-ii/discuss/231587/Java-find-in-parents-or-find-in-descendents/281258">LC Discussion</a>
 * <a href="https://leetcode.com/problems/inorder-successor-in-bst-ii/discuss/231587/Java-find-in-parents-or-find-in-descendents">LC Discussion</a>
 * <a href="https://leetcode.com/problems/inorder-successor-in-bst-ii/discuss/239399/JAVA-iterative-Beats-100-4ms-not-looking-up-node-values.-Detailed-explanation">LC Discussion</a>.
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Iteration {
    public Node inorderSuccessor(Node node) {
        if (node.right == null) {
            Node cur = node;
            while (cur.parent != null && cur.parent.right == cur) {
                cur = cur.parent;
            }

            return cur.parent;
        }

        Node cur = node.right;
        while (cur.left != null) {
            cur = cur.left;
        }

        return cur;
    }
}
