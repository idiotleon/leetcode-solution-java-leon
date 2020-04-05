/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * 
 * Tabulation vs Memoization
 * https://www.geeksforgeeks.org/tabulation-vs-memoization/
 */
package main.java.lcidiot.lc0129;

import java.util.ArrayList;
import java.util.List;

import main.java.lcidiot.utils.TreeNode;

public class SolutionApproachDFSConstructingString {
    public int sumNumbers(TreeNode root) {
        List<String> nums = new ArrayList<String>();
        dfs(root, "", nums);
        
        int sum = 0;
        for(String num : nums){
            sum += Integer.parseInt(num);
        }
        
        return sum;
    }
    
    private void dfs(TreeNode node, 
                     String intermediate, 
                     List<String> nums){
        if(node == null) return;
        
        intermediate += Integer.toString(node.val);

        if(node.left == null && node.right == null){
            nums.add(intermediate);
            return;
        }
        
        if(node.left != null){
            dfs(node.left, intermediate, nums);
        }
        
        if(node.right != null){
            dfs(node.right, intermediate, nums);
        }
    }
}