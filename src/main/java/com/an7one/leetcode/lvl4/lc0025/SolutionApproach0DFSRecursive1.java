/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * 
 * Time Complexity:     O(L)
 *  L, length of the linked list
 * 
 * Space Complexity:    O(L / `k`) ~ O(L)
 * 
 * References:
 *  https://leetcode.com/problems/reverse-nodes-in-k-group/discuss/11423/Short-but-recursive-Java-code-with-comments/12134
 *  https://leetcode.com/problems/reverse-nodes-in-k-group/discuss/11423/Short-but-recursive-Java-code-with-comments
 */
package com.an7one.leetcode.lvl4.lc0025;

import com.an7one.util.data_structure.linkedlist.ListNode;

public class SolutionApproach0DFSRecursive1 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (count < k) {
            if (cur == null)
                return head;
            cur = cur.next;
            ++count;
        }

        ListNode prev = reverseKGroup(cur, k);
        while (count > 0) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            --count;
        }

        return prev;
    }
}