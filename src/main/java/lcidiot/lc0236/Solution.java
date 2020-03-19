/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
package main.java.lcidiot.lc0236;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import main.java.lcidiot.utils.TreeNode;

class Solution {
    // solution i: recursion
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left == null) return right;
        else if(right == null) return left;
        else return root;
    }

    // solution ii: iteration
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        
        Map<TreeNode, TreeNode> parent = new HashMap<TreeNode, TreeNode>();
        parent.put(root, null);

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!parent.containsKey(p) || !parent.containsKey(q)){
            TreeNode node = stack.pop();
            
            if(node.left != null){
                stack.push(node.left);
                parent.put(node.left, node);
            }
            
            if(node.right != null){
                stack.push(node.right);
                parent.put(node.right,node);
            }
        }
        
        Set<TreeNode> ancestors = new HashSet<TreeNode>();
        while(p != null){
            ancestors.add(p);
            p = parent.get(p);
        }
        
        while(!ancestors.contains(q))
            q = parent.get(q);
        
        return q;
    }
}