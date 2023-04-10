package com.idiotleon.leetcode.lvl4.lc0023;

import java.util.PriorityQueue;

import com.idiotleon.util.Constant;
import com.idiotleon.util.data_structure.linkedlist.ListNode;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * <p>
 * Time Complexity:     O(K * L * lg(K))
 * K, number of lists to be merged
 * L, the average length of lists
 * <p>
 * Space Complexity:    O(K)
 * K, number of lists to be merged
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach1MinHeap {
    public ListNode mergeKLists(ListNode[] lists) {
        // sanity check
        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>();

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