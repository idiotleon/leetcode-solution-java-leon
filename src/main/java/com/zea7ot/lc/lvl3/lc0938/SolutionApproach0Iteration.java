/**
 * https://leetcode.com/problems/range-sum-of-bst/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(H)
 * 
 * Referneces:
 *  https://leetcode.com/problems/range-sum-of-bst/discuss/192019/JavaPython-3-3-similar-recursive-and-1-iterative-methods-w-comment-and-analysis.
 */
package com.zea7ot.lc.lvl3.lc0938;

import java.util.Stack;

import com.zea7ot.data_structure.tree.TreeNode;

public class SolutionApproach0Iteration {
    public int rangeSumBST(TreeNode root, int L, int R) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        int sum = 0;
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur == null) continue;
            if(cur.val > L) stack.push(cur.left);
            if(cur.val < R) stack.push(cur.right);
            if(cur.val >= L && cur.val <= R) sum += cur.val;
        }
        
        return sum;
    }
}