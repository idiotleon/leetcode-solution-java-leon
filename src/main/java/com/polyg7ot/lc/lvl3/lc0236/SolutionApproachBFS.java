/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
package com.polyg7ot.lc.lvl3.lc0236;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.polyg7ot.data_structure.tree.TreeNode;

public class SolutionApproachBFS {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<TreeNode, TreeNode>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        parent.put(root, null);
        queue.offer(root);
        
        while(!parent.containsKey(p) || !parent.containsKey(q)){
            TreeNode node = queue.poll();
            if(node.left != null){
                parent.put(node.left, node);
                queue.offer(node.left);
            }
            
            if(node.right != null){
                parent.put(node.right, node);
                queue.offer(node.right);
            }
        }
        
        Set<TreeNode> ancestors = new HashSet<TreeNode>();
        while(p != null){
            ancestors.add(p);
            p = parent.get(p);
        }
        
        while(!ancestors.contains(q)){
            q = parent.get(q);
        }
        
        return q;
    }
}