/**
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/two-sum-iv-input-is-a-bst/discuss/106059/JavaC%2B%2B-Three-simple-methods-choose-one-you-like
 */
package com.zea7ot.leetcode.lvl2.lc0653;

import java.util.ArrayList;
import java.util.List;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach1Inorder {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> sorted = new ArrayList<Integer>();
        inorder(root, sorted);
        
        final int N = sorted.size();
        int lo = 0, hi = N - 1;
        while(lo < hi){
            if(sorted.get(lo) + sorted.get(hi) == k) return true;
            if(sorted.get(lo) + sorted.get(hi) < k) lo++;
            else hi--;
        }
        
        return false;
    }
    
    private void inorder(TreeNode node, List<Integer> nums){
        if(node == null) return ;
        inorder(node.left, nums);
        nums.add(node.val);
        inorder(node.right, nums);
    }
}