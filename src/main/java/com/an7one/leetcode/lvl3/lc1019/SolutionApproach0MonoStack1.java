/**
 * https://leetcode.com/problems/next-greater-node-in-linked-list/
 * 
 * Time Complexity:     O(L)
 *  L, length of the linked list
 * Space Complexity:    O(L)
 *  L, length of the linked list
 * 
 * References:
 *  https://leetcode.com/problems/next-greater-node-in-linked-list/discuss/265508/JavaC++Python-Next-Greater-Element/256331
 *  https://leetcode.com/problems/next-greater-node-in-linked-list/discuss/265508/JavaC%2B%2BPython-Next-Greater-Element
 */
package com.an7one.leetcode.lvl3.lc1019;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.an7one.util.data_structure.linkedlist.ListNode;

public class SolutionApproach0MonoStack1 {
    public int[] nextLargerNodes(ListNode head) {
        Integer[] nums = toArray(head);
        final int N = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[N];

        for (int i = 0; i < N; ++i) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                ans[stack.pop()] = nums[i];
            }
            stack.push(i);
        }

        return ans;
    }

    private Integer[] toArray(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        return list.toArray(new Integer[0]);
    }
}