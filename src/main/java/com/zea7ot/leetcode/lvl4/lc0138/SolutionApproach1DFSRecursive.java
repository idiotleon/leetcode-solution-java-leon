/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 */
package com.zea7ot.leetcode.lvl4.lc0138;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach1DFSRecursive {
    public ListNode copyRandomList(ListNode head) {
        // sanity check
        if (head == null)
            return null;

        Map<ListNode, ListNode> visited = new HashMap<ListNode, ListNode>();
        dfs(head, visited);
        return visited.get(head);
    }

    private ListNode dfs(ListNode node, Map<ListNode, ListNode> visited) {
        if (node == null)
            return null;

        if (visited.containsKey(node))
            return visited.get(node);

        ListNode clone = new ListNode(node.val);
        visited.put(node, clone);

        clone.next = dfs(node.next, visited);
        clone.random = dfs(node.random, visited);

        return clone;
    }
}