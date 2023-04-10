/**
 * https://leetcode.com/problems/change-the-root-of-a-binary-tree/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/change-the-root-of-a-binary-tree/discuss/966671/Straightforward-Java-Solution-Iterative
 */
package com.idiotleon.leetcode.lvl2.lc1666;

public class SolutionApproach0Iterative {
    public Node flipBinaryTree(Node root, Node leaf) {
        Node newRoot = leaf;
        Node cur = leaf;
        Node last = null;

        while (cur != root) {
            if (cur.left != null) {
                cur.right = cur.left;
            }

            cur.left = cur.parent;

            if (cur.parent.left == cur) {
                cur.parent.left = null;
            } else if (cur.parent.right == cur) {
                cur.parent.right = null;
            }

            Node parent = cur.parent;
            cur.parent = last;
            last = cur;
            cur = parent;
        }

        cur.parent = last;
        return newRoot;
    }
}
