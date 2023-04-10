/**
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 * 
 * Time Complexity:     O(L)
 * Space Complexity;    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/discuss/451815/JavaPython-3-Simulate-binary-operations.
 */
package com.idiotleon.leetcode.lvl1.lc1290;

import com.idiotleon.util.data_structure.linkedlist.ListNode;

public class SolutionApproach0OnePass1 {
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        while(head != null){
            ans <<= 1;
            ans += head.val;
            head = head.next;
        }
        
        return ans;
    }
}