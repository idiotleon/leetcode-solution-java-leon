/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/discuss/37813/Java-solution-with-constant-space
 */
package com.idiotleon.leetcode.lvl3.lc0117;

public class SolutionApproach0BFS {
    public Node connect(Node root) {
        // sanity check
        if (root == null)
            return null;

        final Node DUMMY = new Node(0);
        Node prev = DUMMY;
        Node cur = root;
        while (cur != null) {
            if (cur.left != null) {
                prev.next = cur.left;
                prev = prev.next;
            }

            if (cur.right != null) {
                prev.next = cur.right;
                prev = prev.next;
            }

            cur = cur.next;
            if (cur == null) {
                prev = DUMMY;
                cur = DUMMY.next;
                DUMMY.next = null;
            }
        }

        return root;
    }
}
