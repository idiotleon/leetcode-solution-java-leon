/**
 * https://leetcode.com/problems/palindrome-linked-list/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/palindrome-linked-list/discuss/181453/Java-or-5-lines-method-or-2ms-or-O(n)-or-recursive-or-easy-to-understand/496909
 *  https://leetcode.com/problems/palindrome-linked-list/discuss/181453/Java-or-5-lines-method-or-2ms-or-O(n)-or-recursive-or-easy-to-understand
 */
package com.zea7ot.lc.lvl3.lc0234;

import com.zea7ot.utils.data_structure.linkedlist.ListNode;

public class SolutionApproach0Recursion {
    public boolean isPalindrome(ListNode head) {
        ListNode start = new ListNode(-1);
        start.next = head;
        return isPalindrome(start, head);
    }
    
    private boolean isPalindrome(ListNode start, ListNode end){
        if(end == null) return true;
        
        boolean res = isPalindrome(start, end.next);
        boolean isEqual = start.next.val == end.val;
        start.next = start.next.next;
        return res && isEqual;
    }
}