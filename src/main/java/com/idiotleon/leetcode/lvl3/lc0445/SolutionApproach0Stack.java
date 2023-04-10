/**
 * https://leetcode.com/problems/add-two-numbers-ii/
 * 
 * Time Complexity:     O(max(L1, L2))
 * Space Complexity:    O(L1 + L2)
 * 
 * References:
 *  https://leetcode.com/problems/add-two-numbers-ii/discuss/92623/Easy-O(n)-Java-Solution-using-Stack/172299
 */
package com.idiotleon.leetcode.lvl3.lc0445;

import java.util.Stack;

import com.idiotleon.util.data_structure.linkedlist.ListNode;

public class SolutionApproach0Stack {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<ListNode>();
        while(l1 != null){
            stack1.push(l1);
            l1 = l1.next;
        }
        
        Stack<ListNode> stack2 = new Stack<ListNode>();
        while(l2 != null){
            stack2.push(l2);
            l2 = l2.next;
        }
        
        int carry = 0;
        ListNode head = null;
        
        while(!stack1.isEmpty() || !stack2.isEmpty() || carry != 0){
            int num1 = stack1.isEmpty() ? 0 : stack1.pop().val;
            int num2 = stack2.isEmpty() ? 0 : stack2.pop().val;
            
            int sum = num1 + num2 + carry;
            
            // to construct the linked list in a reversed way
            ListNode newNode = new ListNode(sum % 10);
            newNode.next = head;
            head = newNode;
            carry = sum / 10;
        }
        
        return head;
    }
}