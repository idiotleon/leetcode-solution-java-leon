package com.an7one.leetcode.lvl3.lc0141;

import com.an7one.util.Constant;
import com.an7one.util.data_structure.linkedlist.ListNode;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/linked-list-cycle/">LC0141</a>
 * <p>
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0LinearScan {
    public boolean hasCycle(ListNode head) {
        // sanity check
        if (head == null || head.next == null)
            return false;

        ListNode slow = head, fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}