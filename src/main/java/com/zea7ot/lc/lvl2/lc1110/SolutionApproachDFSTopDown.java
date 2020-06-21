/**
 * https://leetcode.com/problems/delete-nodes-and-return-forest/
 */
package com.zea7ot.lc.lvl2.lc1110;

import com.zea7ot.utils.data_structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class SolutionApproachDFSTopDown{
    private Set<Integer> toDeleteSet;
    private List<TreeNode> res;
    
    public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
        toDeleteSet = new HashSet<>();
        res = new ArrayList<>();
        for(int i : toDelete) toDeleteSet.add(i);
        dfs(root, true);
        return res;
    }
    
    private TreeNode dfs(TreeNode node, boolean isRoot){
        // sanity check
        if(node == null) return null;
        
        boolean deleted = toDeleteSet.contains(node.val);
        if(isRoot && !deleted) res.add(node);
        node.left = dfs(node.left, deleted);
        node.right = dfs(node.right, deleted);
        
        return deleted ? null : node;
    }
}