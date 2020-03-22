/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
package main.java.lcidiot.lc0145;

import java.util.ArrayList;
import java.util.List;

import main.java.lcidiot.utils.TreeNode;

class SolutionApproachRecursion {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if(root == null) return ans;
        
        postorder(root, ans);
        return ans;
    }
    
    private void postorder(TreeNode root, List<Integer> ans){
        if(root == null) return;
        
        postorder(root.left, ans);
        postorder(root.right, ans);
        ans.add(root.val);
    }
}