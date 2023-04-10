package com.idiotleon.leetcode.lvl3.lc0510;

import com.idiotleon.util.Constant;

/**
 * <a href="https://leetcode.com/problems/inorder-successor-in-bst-ii/">LC0510</a>
 * <p>
 * Time Complexity:     O(H)
 * Space Complexity:    O(1)
 * <p>
 * There are only two cases:
 * Case 1 the node has no right node, so successor might be in the parent.
 * Just to loop through the parent and find the first one bigger than `node`
 * Case 2 is where the `node` has a right child.
 * It doesn't matter if the parent node exist of not. Just to find the successor.
 * <p>
 * <p>
 * References:
 * <a href="https://leetcode.com/problems/inorder-successor-in-bst-ii/discuss/231587/Java-find-in-parents-or-find-in-descendents">LC Discussion</a>
 * <a href="https://leetcode.com/problems/inorder-successor-in-bst-ii/discuss/231587/Java-find-in-parents-or-find-in-descendents/279202">LC Discussion</a>
 * <a href="https://leetcode.com/problems/delete-node-in-a-bst/solution/">LC Solution</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Iteration {
    public Node inorderSuccessor(Node node) {
        Node cur;
        if (node.right == null) {
            cur = node.parent;
            while (cur != null && cur.val < node.val) {
                cur = cur.parent;
            }
        } else {
            cur = node.right;
            while (cur.left != null) {
                cur = cur.left;
            }
        }
        return cur;
    }
}