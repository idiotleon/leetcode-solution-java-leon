/**
 * https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
 * 
 * Time Complexity:     O(N1 + N2)
 * Space Complexity:    O(N1 + N2)
 * 
 * References:
 *  https://leetcode.com/problems/all-elements-in-two-binary-search-trees/discuss/463852/JavaPython-3-2-codes%3A-O(n)-time-w-analysis.
 */
package com.zea7ot.leetcode.lvl2.lc1305;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach1MergeSort {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Deque<Integer> queue1 = new ArrayDeque<Integer>();
        inorder(root1, queue1);
        Deque<Integer> queue2 = new ArrayDeque<Integer>();
        inorder(root2, queue2);
        
        List<Integer> ans = new ArrayList<Integer>();
        while(!queue1.isEmpty() || !queue2.isEmpty()){
            if(queue1.isEmpty())
                ans.add(queue2.poll());
            else if(queue2.isEmpty())
                ans.add(queue1.poll());
            else
                ans.add(queue1.peek() < queue2.peek() ? queue1.poll() : queue2.poll());
        }
        
        return ans;
    }
    
    private void inorder(TreeNode node, Deque<Integer> queue){
        if(node == null) return;
        
        inorder(node.left, queue);
        queue.offer(node.val);
        inorder(node.right, queue);
    }
}