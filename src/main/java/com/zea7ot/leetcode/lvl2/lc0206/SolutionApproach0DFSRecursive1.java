/**
 * https://leetcode.com/problems/reverse-linked-list/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 * 
 * References:
 *  https://leetcode.com/problems/reverse-linked-list-ii/discuss/30666/Simple-Java-solution-with-clear-explanation/242638
 *  https://leetcode.com/problems/reverse-nodes-in-k-group/discuss/183356/Java-O(n)-solution-with-super-detailed-explanation-and-illustration
 */
package com.zea7ot.leetcode.lvl2.lc0206;

import com.zea7ot.util.data_structure.linkedlist.ListNode;

public class SolutionApproach0DFSRecursive1 {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;

        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
