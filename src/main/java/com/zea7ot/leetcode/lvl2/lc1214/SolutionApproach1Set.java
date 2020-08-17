/**
 * https://leetcode.com/problems/two-sum-bsts/
 * 
 * Time Complexity:     O(max(M, N))
 * Space Compleixty:    O(lg(M)) + O(N)
 * 
 * Refereneces:
 *  https://leetcode.com/problems/two-sum-bsts/discuss/410394/Java-Set%2BTree-Traversal
 */
package com.zea7ot.leetcode.lvl2.lc1214;

import java.util.HashSet;
import java.util.Set;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach1Set {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        // sanity check
        if(root1 == null || root2 == null) return false;

        Set<Integer> set = new HashSet<Integer>();
        fillSet(root2, set);
        return dfs(root1, set, target);
    }
    
    private void fillSet(TreeNode node, Set<Integer> set){
        if(node == null) return;
        
        set.add(node.val);
        fillSet(node.left, set);
        fillSet(node.right, set);
    }
    
    private boolean dfs(TreeNode root1, Set<Integer> set, int target){
        if(root1 == null) return false;
        int diff = target - root1.val;
        if(set.contains(diff)) return true;
        return dfs(root1.left, set, target) || dfs(root1.right, set, target);
    }
}