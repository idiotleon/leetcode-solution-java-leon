/**
 * https://leetcode.com/problems/linked-list-components/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/linked-list-components/discuss/123842/C%2B%2BJavaPython-Easy-and-Concise-Solution-with-Explanation
 */
package com.zea7ot.lc.lvl2.lc0817;

import java.util.HashSet;
import java.util.Set;

import com.zea7ot.utils.data_structure.linkedlist.ListNode;

public class SolutionApproach0Set1 {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<Integer>();
        for(int num : G) set.add(num);
        int res = 0;
        while(head != null){
            if(set.contains(head.val) 
                && (head.next == null || !set.contains(head.next.val))) 
                    res++;
            head = head.next;
        }
        
        return res;
    }
}