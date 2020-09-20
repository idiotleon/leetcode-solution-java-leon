/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/discuss/37828/O(1)-space-O(n)-complexity-Iterative-Solution/35888
 */
package com.zea7ot.leetcode.lvl3.lc0117;

public class SolutionApproach0DFS {
    public Node connect(Node root) {
        // sanity check
        if (root == null)
            return null;

        final Node DUMMY = new Node(0);
        DUMMY.next = root;
        while (DUMMY.next != null) {
            Node cur = DUMMY.next;
            Node prev = DUMMY;
            DUMMY.next = null;

            while (cur != null) {
                if (cur.left != null) {
                    prev = prev.next = cur.left;
                }

                if (cur.right != null) {
                    prev = prev.next = cur.right;
                }

                cur = cur.next;
            }
        }

        return root;
    }
}
