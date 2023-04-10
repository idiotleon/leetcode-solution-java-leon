/**
 * https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * this is a one-pass approach
 * 
 * References:
 *  https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/discuss/366319/JavaC%2B%2BPython-Greedily-Skip-with-HashMap
 */
package com.idiotleon.leetcode.lvl3.lc1171;

import java.util.HashMap;
import java.util.Map;

import com.idiotleon.util.data_structure.linkedlist.ListNode;

public class SolutionApproach0PrefixSums1 {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummyHead = new ListNode(-1), cur = dummyHead;
        dummyHead.next = head;
        Map<Integer, ListNode> prefixSums = new HashMap<Integer, ListNode>();
        
        int sum = 0;
        while(cur != null){
            sum += cur.val;
            // if this prefix sum has been seen before
            if(prefixSums.containsKey(sum)){
                // to skip all nodes from `map.get(sum)` to `cur.next`(exclusive)
                cur = prefixSums.get(sum).next;
                int prevSum = sum + cur.val;
                while(prevSum != sum){
                    prefixSums.remove(prevSum);
                    cur = cur.next;
                    prevSum += cur.val;
                }
                // eventually to point to `map.get(sum).next`
                prefixSums.get(sum).next = cur.next;
            }else prefixSums.put(sum, cur);
            
            cur = cur.next;
        }
        
        return dummyHead.next;
    }
}