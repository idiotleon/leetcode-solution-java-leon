/**
 * https://leetcode.com/problems/print-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H ^ 2)
 * 
 * References:
 *  https://leetcode.com/problems/print-binary-tree/discuss/106239/Java-Recursive-Solution
 */
package com.an7one.leetcode.lvl2.lc0655;

import java.util.ArrayList;
import java.util.List;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFS {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> ans = new ArrayList<List<String>>();
        // sanity check
        if(root == null) return ans;
        
        final int HEIGHT = root == null ? 1 : getHeight(root);
        final int NR = HEIGHT, NC = (int)(Math.pow(2, HEIGHT) - 1);
        List<String> placeHolder = new ArrayList<String>();
        for(int col = 0; col < NC; col++) placeHolder.add("");
        for(int row = 0; row < NR; row++) 
            ans.add(new ArrayList<String>(placeHolder));
        populate(0, 0, NC - 1, NR, root, ans);
        return ans;
    }
    
    private void populate(int row, 
                          int i, 
                          int j, 
                          final int NR,
                          TreeNode node, 
                          List<List<String>> res){
        if(row == NR || node == null) return;
        res.get(row).set((i + j) / 2, Integer.toString(node.val));
        populate(row + 1, i, (i + j) / 2 - 1, NR, node.left, res);
        populate(row + 1, (i + j) / 2 + 1, j, NR, node.right, res);
        
    }
    
    private int getHeight(TreeNode node){
        if(node == null) return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}