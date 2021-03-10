/**
 * https://leetcode.com/problems/inorder-successor-in-bst-ii/
 * 
 * Time Complexity:     O(H)
 * Space Complexity:    O(1)
 * 
 * References:  
 *  https://leetcode.com/problems/inorder-successor-in-bst-ii/discuss/586196/Java-3-one-liner-functions
 */
package com.an7one.leetcode.lvl3.lc0510;

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