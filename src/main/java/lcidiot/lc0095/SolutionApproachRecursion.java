/**
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 */
package main.java.lcidiot.lc0095;

import java.util.ArrayList;
import java.util.List;

import main.java.lcidiot.data_structure.tree.TreeNode;

class SolutionApproachRecursion {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<TreeNode>();
        return generateTrees(1, n);
    }
    
    private List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> list = new ArrayList<TreeNode>();
        if(start > end) list.add(null);
        
        for(int idx = start; idx <= end; idx++){
            List<TreeNode> leftList = generateTrees(start, idx - 1);
            List<TreeNode> rightList = generateTrees(idx + 1, end);
            for(TreeNode left : leftList)
                for(TreeNode right : rightList){
                    TreeNode root = new TreeNode(idx);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
        }
        
        return list;
    }
}