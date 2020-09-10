/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * 
 * Time Complexity:     O(L)
 *  L, length of the linked list
 * 
 * Space Complexity:    O(L / `k`) ~ O(L)
 * 
 * References:
 *  https://leetcode.com/problems/reverse-nodes-in-k-group/discuss/11423/Short-but-recursive-Java-code-with-comments
 */
package com.zea7ot.leetcode.lvl4.lc0025;

import com.zea7ot.utils.data_structure.linkedlist.ListNode;

public class SolutionApproach0DFSRecursive {
    public ListNode reverseKGroup(ListNode head, int k) {
        return dfs(head, k);
    }

    private ListNode dfs(ListNode head, final int K) {
        ListNode cur = head;
        int count = 0;
        while (count < K) {
            if (cur == null)
                return head;

            cur = cur.next;
            ++count;
        }

        ListNode prev = dfs(cur, K);

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