/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * 
 * Time Complexity:     O(3 * L) ~ O(L)
 * Space Complexity:    O(L) / O(1)
 */
package com.an7one.leetcode.lvl4.lc0138;

public class SolutionApproach0LinearScan {
    public Node copyRandomList(Node head) {
        // sanity check
        if (head == null)
            return null;

        // the first pass
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }

        // the second pass
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // the third pass
        cur = head;
        Node copyHead = head.next;
        while (cur != null) {
            Node next = cur.next.next;
            Node copy = cur.next;
            cur.next = next;
            if (next != null) {
                copy.next = next.next;
            }
            cur = next;
        }

        return copyHead;
    }
}