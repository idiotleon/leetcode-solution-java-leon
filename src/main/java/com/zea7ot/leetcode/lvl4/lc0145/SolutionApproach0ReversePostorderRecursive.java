/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://www.youtube.com/watch?v=A6iCX_5xiU4
 *  http://zxi.mytechroad.com/blog/tree/leetcode-145-binary-tree-postorder-traversal/
 */
package com.zea7ot.leetcode.lvl4.lc0145;

import java.util.LinkedList;
import java.util.List;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0ReversePostorderRecursive {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<Integer>();
        // sanity check
        if(root == null) return ans;
        
        reversePostorder(root, ans);
        return ans;
    }
    
    private void reversePostorder(TreeNode node, LinkedList<Integer> res){
        if(node == null) return;
        
        res.addFirst(node.val);
        reversePostorder(node.right, res);
        reversePostorder(node.left, res);
    }
}