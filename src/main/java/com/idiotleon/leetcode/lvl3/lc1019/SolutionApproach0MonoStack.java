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
package com.idiotleon.leetcode.lvl3.lc1019;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.idiotleon.util.data_structure.linkedlist.ListNode;

public class SolutionApproach0MonoStack {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> ans = new ArrayList<>();
        ListNode cur = head;
        int idx = 0;

        Deque<Integer> stack = new ArrayDeque<>();

        while (cur != null) {
            int value = cur.val;

            while (!stack.isEmpty() && ans.get(stack.peek()) < value) {
                ans.set(stack.pop(), value);
            }

            stack.push(idx);
            ans.add(value);

            cur = cur.next;
            ++idx;
        }

        while (!stack.isEmpty()) {
            ans.set(stack.pop(), 0);
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }
}