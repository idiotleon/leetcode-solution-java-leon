/**
 * https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * this a two-passes approach
 * 
 * References:
 *  https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/discuss/366319/JavaC%2B%2BPython-Greedily-Skip-with-HashMap
 */
package com.an7one.leetcode.lvl3.lc1171;

import java.util.HashMap;
import java.util.Map;

import com.an7one.util.data_structure.linkedlist.ListNode;

public class SolutionApproach0PrefixSums {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        
        // the first pass
        int sum = 0;
        Map<Integer, ListNode> prefixSums = new HashMap<Integer, ListNode>();
        prefixSums.put(0, dummyHead);

        ListNode cur = dummyHead;
        while(cur != null){
            sum += cur.val;
            prefixSums.put(sum, cur);
            cur = cur.next;
        }
        
        // the 2nd pass
        sum = 0;
        cur = dummyHead;
        while(cur != null){
            sum += cur.val;
            // to skip all nodes from `map.get(sum)` to `cur.next`(exclusive)
            cur.next = prefixSums.get(sum).next;
            cur = cur.next;
        }
        
        return dummyHead.next;
    }
}