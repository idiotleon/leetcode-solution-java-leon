package com.idiotleon.leetcode.lvl3.lc0510;

import com.idiotleon.util.Constant;

/**
 * <a href="https://leetcode.com/problems/inorder-successor-in-bst-ii/">LC0510</a>
 * <p>
 * Time Complexity:     O(H)
 * Space Complexity:    O(1)
 * <p>
 * References:
 * <a href="https://leetcode.com/problems/inorder-successor-in-bst-ii/discuss/586196/Java-3-one-liner-functions">LC Discussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DFSRecursive {
    public Node inorderSuccessor(Node node) {
        return node.right == null ? traverseUp(node.parent, node.val) : traverseDown(node.right);
    }

    private Node traverseUp(Node node, int val) {
        return node == null || node.val > val ? node : traverseUp(node.parent, val);
    }

    private Node traverseDown(Node node) {
        return node.left != null ? traverseDown(node.left) : node;
    }
}