/**
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-absolute-difference-in-bst/discuss/99905/Two-Solutions-in-order-traversal-and-a-more-general-way-using-TreeSet/104104
 */
package com.idiotleon.leetcode.lvl3.lc0783;

import java.util.ArrayDeque;
import java.util.Deque;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0InorderIterative {
    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode cur = root, prev = null;
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                if(prev != null)
                    min = Math.min(min, cur.val - prev.val);
                
                prev = cur;
                cur = cur.right;
            }
        }
        
        return min;
    }
}