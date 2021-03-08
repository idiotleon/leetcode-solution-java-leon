/**
 * https://leetcode.com/problems/two-sum-bsts/
 * 
 * Time Complexity:     O(M + N)
 * Space Complexity:    O(lg(M) + lg(N))
 * 
 * References:
 *  https://leetcode.com/problems/two-sum-bsts/discuss/397624/Simple-Stack-Solution
 */
package com.zea7ot.leetcode.lvl2.lc1214;

import java.util.Stack;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0Stacks {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        // sanity check
        if(root1 == null || root2 == null) return false;
        
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        TreeNode t1, t2;
        
        while(true){
            while(root1 != null){
                stack1.push(root1);
                root1 = root1.left;
            }
            
            while(root2 != null){
                stack2.push(root2);
                root2 = root2.right;
            }
            
            if(stack1.isEmpty() || stack2.isEmpty()) break;
            
            t1 = stack1.peek();
            t2 = stack2.peek();
            
            int sum = t1.val + t2.val;
            
            if(sum == target) return true;
            else if(sum < target){
                stack1.pop();
                root1 = t1.right;
            }else{
                stack2.pop();
                root2 = t2.left;
            }
        }
        
        return false;
    }
}