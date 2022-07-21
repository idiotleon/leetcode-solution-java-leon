package com.an7one.leetcode.lvl2.lc0206;

import java.util.ArrayDeque;
import java.util.Deque;

import com.an7one.util.Constant;
import com.an7one.util.data_structure.linkedlist.ListNode;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/reverse-linked-list/">LC0206</>
 * <p>
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/reverse-nodes-in-k-group/discuss/183356/Java-O(n)-solution-with-super-detailed-explanation-and-illustration">LC Discussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DFSIterative {
    public ListNode reverseList(ListNode head) {
        final ListNode dummy = new ListNode(-1);
        final Deque<ListNode> stack = new ArrayDeque<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        dummy.next = stack.peek();
        while (!stack.isEmpty()) {
            ListNode top = stack.pop();
            if (stack.isEmpty()) {
                top.next = null;
            } else {
                top.next = stack.peek();
            }
        }

        return dummy.next;
    }
}
