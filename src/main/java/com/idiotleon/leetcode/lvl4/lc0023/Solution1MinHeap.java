package com.idiotleon.leetcode.lvl4.lc0023;

import com.idiotleon.util.Constant;
import com.idiotleon.util.data_structure.linkedlist.ListNode;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/merge-k-sorted-lists/">lc0023</a>
 * <p>
 * Time Complexity:     O(K * L * lg(K))
 * K, number of lists to be merged
 * L, the average length of lists
 * <p>
 * Space Complexity:    O(K)
 * K, number of lists to be merged
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class Solution1MinHeap {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        final PriorityQueue<ListNode> minHeap = new PriorityQueue<>();

        for (final ListNode head : lists) {
            if (head != null) {
                minHeap.offer(head);
            }
        }

        ListNode dummy = new ListNode(-1), prev = dummy;

        while (!minHeap.isEmpty()) {
            final ListNode top = minHeap.poll();
            if (top.next != null) {
                minHeap.offer(top.next);
            }

            prev.next = top;
            prev = prev.next;
        }

        return dummy.next;
    }
}