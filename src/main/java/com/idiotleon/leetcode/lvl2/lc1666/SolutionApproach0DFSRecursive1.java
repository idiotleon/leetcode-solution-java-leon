/**
 * https://leetcode.com/problems/change-the-root-of-a-binary-tree/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/change-the-root-of-a-binary-tree/discuss/954468/Java.-DFS.-It's-all-about-pointer-manipulation.
 */
package com.idiotleon.leetcode.lvl2.lc1666;

public class SolutionApproach0DFSRecursive1 {
    private Node originalRoot;

    public Node flipBinaryTree(Node root, Node leaf) {
        this.originalRoot = root;

        return dfs(leaf, null);
    }

    private Node dfs(Node node, Node newParent) {
        Node oldParent = node.parent;
        node.parent = newParent;

        if (node.left == newParent)
            node.left = null;
        if (node.right == newParent)
            node.right = null;

        if (node == originalRoot)
            return node;

        if (node.left != null)
            node.right = node.left;
        node.left = dfs(oldParent, node);

        return node;
    }
}
