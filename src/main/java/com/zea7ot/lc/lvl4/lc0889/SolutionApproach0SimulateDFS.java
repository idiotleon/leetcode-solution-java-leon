/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *  H, height of the tree
 * 
 * References:
 *  https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/discuss/161268/C%2B%2BJavaPython-One-Pass-Real-O(N)
 */
package com.zea7ot.lc.lvl4.lc0889;

import java.util.ArrayDeque;
import java.util.Deque;

import com.zea7ot.data_structure.tree.TreeNode;

public class SolutionApproach0SimulateDFS {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        // sanity check
        if(pre == null || pre.length == 0 
            || post == null || post.length == 0 
            || pre.length != post.length) 
                return null;

        final int L = pre.length;
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.offer(new TreeNode(pre[0]));
        
        /**
         * i, index for the preorder traversal
         * j, index for the postorder traversal
         */
        for(int i = 1, j = 0; i < L; ++i){
            TreeNode node = new TreeNode(pre[i]);
            while(stack.getLast().val == post[j]){
                stack.pollLast();
                j++;
            }
            
            if(stack.getLast().left == null){
                stack.getLast().left = node;
            }else stack.getLast().right = node;
            
            stack.offer(node);
        }
        return stack.getFirst();
    }
}