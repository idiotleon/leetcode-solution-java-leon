/**
 * https://leetcode.com/problems/add-two-numbers/
 * 
 * Time Complexity:     O(max(LEN(`l1`), LEN(`l2`)))
 * Space Complexity:    O(1) / O(max(LEN(`l1`), LEN(`l2`)))
 */
package com.zea7ot.leetcode.lvl2.lc0002;

import com.zea7ot.utils.data_structure.linkedlist.ListNode;

public class SolutionApproach0LinearScan {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // sanity check
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int sum = x + y + carry;
            prev.next = new ListNode(sum % 10);
            carry = sum / 10;

            prev = prev.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        if (carry > 0)
            prev.next = new ListNode(carry);

        return dummy.next;
    }
}