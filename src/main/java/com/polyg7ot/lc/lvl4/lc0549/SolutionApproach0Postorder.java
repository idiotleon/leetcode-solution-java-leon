/**
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence-ii/
 * 
 * Time Complexity:     O(N)
 * Space Compelxity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/binary-tree-longest-consecutive-sequence-ii/discuss/101523/Easy-O(n)-Java-Solution-for-2-problems
 *  https://leetcode.com/problems/number-of-longest-increasing-subsequence/discuss/107293/JavaC++-Simple-dp-solution-with-explanation/177757
 */
package com.polyg7ot.lc.lvl4.lc0549;

import com.polyg7ot.data_structure.tree.TreeNode;

public class SolutionApproach0Postorder {
    private int maxLen;
    
    public int longestConsecutive(TreeNode root) {
        this.maxLen = 0;
        postorder(root);
        return maxLen;
    }
    
    private int[] postorder(TreeNode node){
        if(node == null) return new int[2];
        
        int[] left = postorder(node.left), right = postorder(node.right);
        
        if(node.left != null){
            if(node.left.val != node.val - 1) left[0] = 0;
            if(node.left.val != node.val + 1) left[1] = 0;
        }
        
        if(node.right != null){
            if(node.right.val != node.val - 1) right[0] = 0;
            if(node.right.val != node.val + 1) right[1] = 0;
        }
        
        int inc = Math.max(left[0], right[0]) + 1;
        int dec = Math.max(left[1], right[1]) + 1;
        
        maxLen = Math.max(maxLen, inc + dec - 1);
        
        return new int[]{inc, dec};
    }
}