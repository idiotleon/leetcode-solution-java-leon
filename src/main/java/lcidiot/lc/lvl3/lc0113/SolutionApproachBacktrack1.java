/**
 * https://leetcode.com/problems/path-sum-ii/
 */
package main.java.lcidiot.lc.lvl3.lc0113;

import java.util.ArrayList;
import java.util.List;

import main.java.lcidiot.data_structure.tree.TreeNode;

public class SolutionApproachBacktrack1 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null) return ans;
        
        backtrack(root, sum, new ArrayList<Integer>(), ans);
        return ans;
    }
    
    private void backtrack(TreeNode node, 
                        int remainingSum,
                        List<Integer> intermediate, 
                        List<List<Integer>> ans){
        if(node == null) return;
        
        intermediate.add(node.val);
        if(remainingSum == node.val && node.left == null && node.right == null){
            ans.add(new ArrayList<Integer>(intermediate));
            intermediate.remove(intermediate.size() - 1);
            return;
        }
        
        backtrack(node.left, remainingSum - node.val, intermediate, ans);
        backtrack(node.right, remainingSum - node.val, intermediate, ans);
        intermediate.remove(intermediate.size() - 1);
    }
}