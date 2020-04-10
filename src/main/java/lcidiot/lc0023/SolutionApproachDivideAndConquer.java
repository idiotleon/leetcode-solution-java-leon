/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * 
 * Time Complexity: O(Nlgk)
 * Space Complexity: O(1)
 */
package main.java.lcidiot.lc0023;

import main.java.lcidiot.utils.ListNode;

class SolutionApproachDivideAndConquer{
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        
        return mergeKLists(lists, 0, lists.length - 1);
    }
    
    private ListNode mergeKLists(ListNode[] lists, int start, int end){
        if(end < start) return null;
        if(end - start == 0) return lists[start];
        if(end - start == 1) return merge(lists[start], lists[end]);
        
        int mid = start + (end - start) / 2;
        ListNode lower = mergeKLists(lists, start, mid);
        ListNode upper = mergeKLists(lists, mid + 1, end);
        
        return merge(lower, upper);
    }
    
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1), prev = dummy;
        
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                prev.next = l1;
                l1 = l1.next;
            }else{
                prev.next = l2;
                l2 = l2.next;
            }
            
            prev = prev.next;
        }
        
        prev.next = (l1 == null) ? l2 : l1;
        
        return dummy.next;
    }
}