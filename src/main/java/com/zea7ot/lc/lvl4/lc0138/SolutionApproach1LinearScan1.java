/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 */
package com.zea7ot.lc.lvl4.lc0138;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach1LinearScan1 {
    public ListNode copyRandomList(ListNode head) {
        // sanity check
        if (head == null)
            return head;

        Map<ListNode, ListNode> map = new HashMap<ListNode, ListNode>();
        ListNode cur = head;
        while (cur != null) {
            if (!map.containsKey(cur))
                map.put(cur, new ListNode(cur.val));

            if (cur.next != null && !map.containsKey(cur.next))
                map.put(cur.next, new ListNode(cur.next.val));

            if (cur.random != null && !map.containsKey(cur.random))
                map.put(cur.random, new ListNode(cur.random.val));

            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }
}