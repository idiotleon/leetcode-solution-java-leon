/**
 * https://leetcode.com/problems/path-sum-ii/
 */
package main.java.lcidiot.lc.lvl3.lc0113;

import java.util.ArrayList;
import java.util.List;

import main.java.lcidiot.data_structure.tree.TreeNode;

public class SolutionApproachBacktrack {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // sanity check
        if(root == null) return ans;
        
        backtrack(root, sum, new ArrayList<Integer>(), ans);
        return ans;
    }
    
    private void backtrack(TreeNode node, 
                        int remainingSum, 
                        List<Integer> pathNodes, 
                        List<List<Integer>> pathsList){
        if(node == null) return;
        
        pathNodes.add(node.val);
        
        if(remainingSum == node.val && node.left == null && node.right == null){
            pathsList.add(new ArrayList<Integer>(pathNodes));
        } else {
            backtrack(node.left, remainingSum - node.val, pathNodes, pathsList);
            backtrack(node.right, remainingSum - node.val, pathNodes, pathsList);
        }
        
        pathNodes.remove(pathNodes.size() - 1);
    };
}