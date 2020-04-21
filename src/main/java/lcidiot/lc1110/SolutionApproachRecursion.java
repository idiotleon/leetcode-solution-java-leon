/**
 * https://leetcode.com/problems/delete-nodes-and-return-forest/
 */

package main.java.lcidiot.lc1110;

import main.java.lcidiot.data_structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


class Solution{
    private Set<Integer> toDeleteSet;
    private List<TreeNode> res;
    
    public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
        toDeleteSet = new HashSet<>();
        res = new ArrayList<>();
        for(int i : toDelete) toDeleteSet.add(i);
        helper(root, true);
        return res;
    }
    
    private TreeNode helper(TreeNode node, boolean isRoot){
        if(node == null) return null;
        
        boolean deleted = toDeleteSet.contains(node.val);
        if(isRoot && !deleted) res.add(node);
        node.left = helper(node.left, deleted);
        node.right = helper(node.right, deleted);
        
        return deleted ? null : node;
    }
}