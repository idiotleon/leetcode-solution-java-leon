/**
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 * 
 * Time Complexity:     O(L)
 * Space Complexity;    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/discuss/451815/JavaPython-3-Simulate-binary-operations.
 */
package com.zea7ot.leetcode.lvl1.lc1290;

import com.zea7ot.utils.data_structure.linkedlist.ListNode;

public class SolutionApproach0OnePass {
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        while(head != null){
            ans = (ans << 1) | head.val;
            head = head.next;
        }
        
        return ans;
    }
}