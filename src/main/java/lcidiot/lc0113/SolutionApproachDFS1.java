/**
 * https://leetcode.com/problems/path-sum-ii/
 */
package main.java.lcidiot.lc0113;

import java.util.ArrayList;
import java.util.List;

import main.java.lcidiot.utils.TreeNode;

class SolutionApproachDFS {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null) return ans;
        
        helper(root, sum, new ArrayList<Integer>(), ans);
        return ans;
    }
    
    private void helper(TreeNode node, 
                        int remainingSum, 
                        List<Integer> pathNodes, 
                        List<List<Integer>> pathsList){
        if(node == null) return;
        
        pathNodes.add(node.val);
        
        if(remainingSum == node.val && node.left == null && node.right == null){
            pathsList.add(new ArrayList<Integer>(pathNodes));
        } else {
            helper(node.left, remainingSum - node.val, pathNodes, pathsList);
            helper(node.right, remainingSum - node.val, pathNodes, pathsList);
        }
        
        pathNodes.remove(pathNodes.size() - 1);
    };
}