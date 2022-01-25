/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * <p>
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl4.lc0142;

import com.an7one.util.Constant;
import com.an7one.util.data_structure.linkedlist.ListNode;

@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0SlowFastPointers {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }

                return slow;
            }
        }

        return null;
    }
}