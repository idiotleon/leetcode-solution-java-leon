/**
 * https://leetcode.com/problems/rotate-list/
 * 
 * Time Complexity:     O(`k`) + O(L) ~ O(max(`k`, L))
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/rotate-list/discuss/22726/Anyone-solve-the-problem-without-counting-the-length-of-List/22235
 */
package com.an7one.leetcode.lvl3.lc0061;

import com.an7one.util.data_structure.linkedlist.ListNode;

public class SolutionApproach1TwoPointers {
    public ListNode rotateRight(ListNode head, int k) {
        // sanity check
        if (head == null)
            return head;

        ListNode fast = head, slow = head;

        for (int i = 0; i < k; ++i) {
            if (fast.next == null) {
                fast = head;
            } else {
                fast = fast.next;
            }
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        final ListNode DUMMY = new ListNode(-1);
        fast.next = head;
        DUMMY.next = slow.next;
        slow.next = null;

        return DUMMY.next;
    }
}
