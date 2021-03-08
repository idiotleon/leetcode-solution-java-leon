/**
 * https://leetcode.com/problems/linked-list-components/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/linked-list-components/discuss/123842/C++JavaPython-Easy-and-Concise-Solution-with-Explanation/258074
 *  https://leetcode.com/problems/linked-list-components/discuss/123842/C%2B%2BJavaPython-Easy-and-Concise-Solution-with-Explanation
 */
package com.zea7ot.leetcode.lvl2.lc0817;

import java.util.HashSet;
import java.util.Set;

import com.zea7ot.util.data_structure.linkedlist.ListNode;

public class SolutionApproach0Set {
    public int numComponents(ListNode head, int[] G) {
        int count = 0;
        ListNode cur = head;
        Set<Integer> set = new HashSet<Integer>();
        for(int num : G) set.add(num);
        
        while(cur != null){
            if(set.contains(cur.val)){
                count++;
                while(cur != null && set.contains(cur.val)) 
                    cur = cur.next;
            }else cur = cur.next;
        }
        
        return count;
    }
}