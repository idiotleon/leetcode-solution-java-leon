/**
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(lg(L))
 * 
 * a top-down approach
 */
package com.zea7ot.lc.lvl3.lc0109;

import com.zea7ot.utils.data_structure.linkedlist.ListNode;
import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0DFS {
    public TreeNode sortedListToBST(ListNode head) {
        // sanity check
        if (head == null)
            return null;

        ListNode mid = findMiddleElement(head);
        TreeNode node = new TreeNode(mid.val);
        if (head == mid)
            return node;

        node.left = sortedListToBST(head);
        node.right = sortedListToBST(mid.next);

        return node;
    }

    private ListNode findMiddleElement(ListNode head) {
        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null)
            prev.next = null;

        return slow;
    }
}