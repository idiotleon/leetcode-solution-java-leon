/**
 * https://leetcode.com/problems/odd-even-linked-list/
 */
package main.java.lcidiot.lc0328;

import main.java.lcidiot.data_structure.linkedlist.ListNode;

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode dummyOdd = new ListNode(-1), dummyEven = new ListNode(-1), prevOdd = dummyOdd, prevEven = dummyEven;
        
        int count = 1;
        while(head != null){
            if(count % 2 == 1){
                prevOdd.next = new ListNode(head.val);
                prevOdd = prevOdd.next;
            }else{
                prevEven.next = new ListNode(head.val);
                prevEven = prevEven.next;
            }
            
            count++;
            head = head.next;
        }
        
        prevOdd.next = dummyEven.next;
        
        return dummyOdd.next;
    }
}