/**
 * https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
 * 
 * Time Complexity:     O(N)

 * Space Complexity:    O(K * H)
 *  or O(K + H) if discarded sets can be considered as immediately garbage collected
 * 
 * References:
 *  https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/discuss/648345/Java-DFS-%2B-Set-%2B-Recursion
 */
package com.zea7ot.leetcode.lvl3.lc1457;

import java.util.HashSet;
import java.util.Set;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0DFS1 {
    public int pseudoPalindromicPaths (TreeNode root) {
        return dfs(root, new HashSet<Integer>());
    }
    
    private int dfs(TreeNode node, Set<Integer> odd){
        if(node == null) return 0;
        
        if(odd.contains(node.val)) odd.remove(node.val);
        else odd.add(node.val);
        
        if(node.left == null && node.right == null){
            return odd.size() <= 1 ? 1 : 0;
        }
        
        int left = dfs(node.left, new HashSet<Integer>(odd));
        int right = dfs(node.right, new HashSet<Integer>(odd));
        return left + right;
    }
}