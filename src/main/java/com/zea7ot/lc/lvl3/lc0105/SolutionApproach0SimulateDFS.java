/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/34555/The-iterative-solution-is-easier-than-you-think!/32916
 *  https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/34555/The-iterative-solution-is-easier-than-you-think!
 */
package com.zea7ot.lc.lvl3.lc0105;

import java.util.ArrayDeque;
import java.util.Deque;

import com.zea7ot.data_structure.tree.TreeNode;

public class SolutionApproach0SimulateDFS {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // sanity check
        if(inorder == null 
            || inorder.length == 0 
            || preorder == null 
            || preorder.length == 0 
            || inorder.length != preorder.length)
                return null;
        
        final int L = preorder.length;
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode root = new TreeNode(preorder[0]), cur = root;
        for(int i = 1, j = 0; i < L; i++){
            if(cur.val != inorder[j]){
                cur.left = new TreeNode(preorder[i]);
                stack.push(cur);
                cur = cur.left;
            }else{
                j++;
                while(!stack.isEmpty() && stack.peek().val == inorder[j]){
                    cur = stack.pop();
                    j++;
                }
                cur = cur.right = new TreeNode(preorder[i]);
            }
        }
        
        return root;
    }
}