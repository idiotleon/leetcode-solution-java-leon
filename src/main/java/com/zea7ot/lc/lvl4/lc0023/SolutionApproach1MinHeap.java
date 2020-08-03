/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * 
 * Time Complexity:     O(K * L * lg(K))
 *  K, number of lists to be merged
 *  L, the average length of lists
 * 
 * Space Complexity:    O(K)
 *  K, number of lists to be merged
 */
package com.zea7ot.lc.lvl4.lc0023;

import java.util.PriorityQueue;

import com.zea7ot.utils.data_structure.linkedlist.ListNode;

public class SolutionApproach1MinHeap {
    public ListNode mergeKLists(ListNode[] lists) {
        // sanity check
        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((a, b) -> Integer.compare(a.val, b.val));

        for (ListNode head : lists) {
            if (head != null)
                minHeap.offer(head);
        }

        ListNode dummy = new ListNode(-1), prev = dummy;

        while (!minHeap.isEmpty()) {
            ListNode top = minHeap.poll();
            if (top.next != null)
                minHeap.offer(top.next);

            prev.next = top;
            prev = prev.next;
        }

        return dummy.next;
    }
}