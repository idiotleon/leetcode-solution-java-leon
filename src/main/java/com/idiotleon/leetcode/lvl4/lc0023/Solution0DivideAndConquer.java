package com.idiotleon.leetcode.lvl4.lc0023;

import com.idiotleon.util.Constant;
import com.idiotleon.util.data_structure.linkedlist.ListNode;

/**
 * <a href="https://leetcode.com/problems/merge-k-sorted-lists/">lc0023</a>
 * <p>
 * Time Complexity:     O(K * L * lg(K))
 * K, the number of lists to be merged
 * L, the average length of lists
 * <p>
 * Space Complexity:    O(1)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class Solution0DivideAndConquer {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        final int N = lists.length;
        return mergeKLists(0, N - 1, lists);
    }

    private ListNode mergeKLists(final int lo, final int hi, final ListNode[] lists) {
        if (hi < lo) {
            return null;
        }
        if (hi - lo == 0) {
            return lists[lo];
        }
        if (hi - lo == 1) {
            return merge(lists[lo], lists[hi]);
        }

        final int mid = lo + (hi - lo) / 2;
        final ListNode lower = mergeKLists(lo, mid, lists);
        final ListNode upper = mergeKLists(mid + 1, hi, lists);

        return merge(lower, upper);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1), prev = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }

            prev = prev.next;
        }

        prev.next = (l1 == null) ? l2 : l1;

        return dummy.next;
    }
}