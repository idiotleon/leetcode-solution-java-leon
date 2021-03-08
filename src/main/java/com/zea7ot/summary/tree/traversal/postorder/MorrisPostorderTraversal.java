/**
 * this is a postorder traversal simulated Morris Inorder/Preorder Traversal
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://gist.github.com/kanrourou/f7f4d46b2285539cc717
 */
package com.zea7ot.summary.tree.traversal.postorder;

import java.util.ArrayList;
import java.util.List;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class MorrisPostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if(root == null) return ans;
        
        TreeNode sentinel = new TreeNode(-1);
        sentinel.left = root;
        TreeNode cur = sentinel;
        while(cur != null){
            if(cur.left == null){
                cur = cur.right;
            }else{
                TreeNode predecessor = cur.left;
                while(predecessor.right != null && predecessor.right != cur)
                    predecessor = predecessor.right;
                
                if(predecessor.right == null){
                    predecessor.right = cur;
                    cur = cur.left;
                }else{
                    collect(cur.left, predecessor, ans);
                    predecessor.right = null;
                    cur = cur.right;
                }
            }
        }
        
        return ans;
    }
    
    private void collect(TreeNode from, TreeNode to, List<Integer> res){
        reverse(from, to);
        TreeNode cur = to;
        while(cur != from){
            res.add(cur.val);
            cur = cur.right;
        }
        res.add(from.val);
        reverse(to, from);
    }
    
    private void reverse(TreeNode from, TreeNode to){
        TreeNode a = from, b = from.right;
        while(a != to){
            TreeNode c = b.right;
            b.right = a;
            a = b;
            b = c;
        }
    }
}