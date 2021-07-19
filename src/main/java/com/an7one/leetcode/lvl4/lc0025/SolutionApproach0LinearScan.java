package com.an7one.leetcode.lvl4.lc0025;

import com.an7one.util.Constant;
import com.an7one.util.data_structure.linkedlist.ListNode;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * <p>
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 * <p>
 * References:
 * https://leetcode.com/problems/reverse-nodes-in-k-group/discuss/183356/Java-O(n)-solution-with-super-detailed-explanation-and-illustration
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0LinearScan {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode ptr = dummy;
        while (ptr != null) {
            if (!longerThanK(ptr, k))
                break;

            ListNode prev = null;
            ListNode curr = ptr.next;
            for (int i = 0; i < k; ++i) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // 0 (pointer) -> 1 <- 2 <- 3 (prev) 4 (curr) -> 5 -> 6 -> 7
            ListNode tail = ptr.next;
            tail.next = curr;
            ptr.next = prev;
            ptr = tail;
        }

        return dummy.next;
    }

    private boolean longerThanK(ListNode head, final int K) {
        ListNode cur = head;
        int count = 0;
        while (count <= K) {
            if (cur == null)
                return false;
            cur = cur.next;
            ++count;
        }

        return true;
    }
}
