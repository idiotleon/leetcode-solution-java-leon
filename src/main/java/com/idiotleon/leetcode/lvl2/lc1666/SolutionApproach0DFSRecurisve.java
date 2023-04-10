/**
 * https://leetcode.com/problems/change-the-root-of-a-binary-tree/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:  
 *  https://leetcode.com/problems/change-the-root-of-a-binary-tree/discuss/1005545/Java-Simple-Recursion
 */
package com.idiotleon.leetcode.lvl2.lc1666;

public class SolutionApproach0DFSRecurisve {
    public Node flipBinaryTree(Node root, Node leaf) {
        dfs(leaf, null);
        return leaf;
    }

    private void dfs(Node node, Node prev) {
        if (node.parent == null) {
            if (prev == node.left) {
                node.left = null;
            } else {
                node.right = null;
            }

            node.parent = prev;
            return;
        }

        if (prev == node.right) {
            node.right = node.left;
        }

        Node next = node.parent;
        node.left = node.parent;
        node.parent = prev;
        dfs(next, node);
    }
}
