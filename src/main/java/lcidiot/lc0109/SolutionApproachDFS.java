/**
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */
package main.java.lcidiot.lc0109;

import main.java.lcidiot.data_structure.linkedlist.ListNode;
import main.java.lcidiot.data_structure.tree.TreeNode;

class SolutionApproachDFS {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        
        ListNode mid = findMiddleElement(head);
        TreeNode node = new TreeNode(mid.val);
        if(head == mid) return node;
        
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(mid.next);
        
        return node;
    }
    
    private ListNode findMiddleElement(ListNode head){
        ListNode prev = null, slow = head, fast = head;
        
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(prev != null)
            prev.next = null;
        
        return slow;
    }
}