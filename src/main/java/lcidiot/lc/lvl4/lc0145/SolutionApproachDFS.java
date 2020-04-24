/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
package main.java.lcidiot.lc.lvl4.lc0145;

import java.util.ArrayList;
import java.util.List;

import main.java.lcidiot.data_structure.tree.TreeNode;

public class SolutionApproachDFS {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
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