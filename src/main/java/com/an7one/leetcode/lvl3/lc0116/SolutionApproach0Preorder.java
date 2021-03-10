/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * a top-down approach
 */
package com.an7one.leetcode.lvl3.lc0116;

public class SolutionApproach0Preorder {
    public Node connect(Node root) {
        // sanity check
        if (root == null)
            return root;

        preorder(root);

        return root;
    }

    private void preorder(Node node) {
        if (node == null)
            return;

        if (node.left != null) {
            node.left.next = node.right;

            if (node.next != null) {
                node.right.next = node.next.left;
            }
        }

        preorder(node.left);
        preorder(node.right);
    }
}