/**
 * https://leetcode.com/problems/next-greater-node-in-linked-list/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/next-greater-node-in-linked-list/discuss/265508/JavaC++Python-Next-Greater-Element/256331
 *  https://leetcode.com/problems/next-greater-node-in-linked-list/discuss/265508/JavaC%2B%2BPython-Next-Greater-Element
 */
package com.zea7ot.lc.lvl3.lc1019;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.zea7ot.utils.data_structure.linkedlist.ListNode;

public class SolutionApproach0MonoStack {
    public int[] nextLargerNodes(ListNode head) {
        Integer[] nums = toArray(head);
        final int N = nums.length;
        Deque<Integer> stack = new LinkedList<Integer>();
        int[] ans = new int[N];
        for(int i = 0; i < N; i++){
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                ans[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        
        return ans;
    }
    
    private Integer[] toArray(ListNode head){
        List<Integer> list = new ArrayList<Integer>();
        ListNode cur = head;
        while(cur != null){
            list.add(cur.val);
            cur = cur.next;
        }
        return list.toArray(new Integer[0]);
    }
}