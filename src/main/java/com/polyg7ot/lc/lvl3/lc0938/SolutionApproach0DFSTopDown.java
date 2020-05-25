/**
 * https://leetcode.com/problems/range-sum-of-bst/
 * 
 * Time Complexity: O(N)
 * 
 * Space Complexity: O(H)
 * 
 * References:
 *  https://leetcode.com/problems/range-sum-of-bst/discuss/192019/JavaPython-3-3-similar-recursive-and-1-iterative-methods-w-comment-and-analysis.
 */
package com.polyg7ot.lc.lvl3.lc0938;

import com.polyg7ot.data_structure.tree.TreeNode;

public class SolutionApproach0TopDown {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null) return 0;
        
        int sum = 0;
        if(root.val > L){
            sum += rangeSumBST(root.left, L, R);
        }
        
        if(root.val < R){
            sum += rangeSumBST(root.right, L, R);
        }
        
        if(root.val >= L && root.val <= R){
            sum += root.val;
        }
        
        return sum;
    }
}