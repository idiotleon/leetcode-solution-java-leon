/**
 * https://leetcode.com/problems/leaf-similar-trees/
 * 
 * Time Complexity:     O(N1 + N2)
 * Space Complexity:    O(N1 + N2)
 * 
 * References:
 *  https://leetcode.com/problems/leaf-similar-trees/discuss/152358/Simple-6-lines-Java-StringBuilder-%2B-traverse-with-explanation
 */
package com.zea7ot.lc.lvl1.lc0872;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0DFS1 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder leaves1 = new StringBuilder();
        StringBuilder leaves2 = new StringBuilder();
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        return leaves1.toString().equals(leaves2.toString());
    }
    
    private void dfs(TreeNode node, StringBuilder builder){
        if(node == null) return;
        if(node.left == null && node.right == null)
            builder.append(String.valueOf(node.val) + "-");
        
        dfs(node.left, builder);
        dfs(node.right, builder);
    }
}