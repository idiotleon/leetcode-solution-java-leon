/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
package com.idiotleon.leetcode.lvl4.lc0117;

public class SolutionApproach0BFSWithoutQueue {
    public Node connect(Node root) {
        Node head = root;

        while (head != null) {
            Node nextHead = new Node(-1), nextTail = nextHead;

            Node cur = head;
            while (cur != null) {
                if (cur.left != null) {
                    nextTail.next = cur.left;
                    nextTail = cur.left;
                }

                if (cur.right != null) {
                    nextTail.next = cur.right;
                    nextTail = cur.right;
                }

                cur = cur.next;
            }

            head = nextHead.next;
        }

        return root;
    }
}