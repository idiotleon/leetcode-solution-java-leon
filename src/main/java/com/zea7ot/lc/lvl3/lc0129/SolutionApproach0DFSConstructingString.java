/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * 
 * Tabulation vs Memoization
 * https://www.geeksforgeeks.org/tabulation-vs-memoization/
 */
package com.zea7ot.lc.lvl3.lc0129;

import java.util.ArrayList;
import java.util.List;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0DFSConstructingString {
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        List<Integer> nums = new ArrayList<Integer>();
        dfs(root, "", nums);
        
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        
        return sum;
    }
    
    private void dfs(TreeNode node, String intermediate, List<Integer> nums){
        if(node == null) return;
        
        intermediate += Integer.toString(node.val);
        
        if(node.left == null && node.right == null){
            nums.add(Integer.parseInt(intermediate));
            return;
        }
        
        dfs(node.left, intermediate, nums);
        dfs(node.right, intermediate, nums);
    }
}