/**
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal/
 */
package com.null7ptr.lc.lvl2.lc0590;

import java.util.ArrayList;
import java.util.List;

import com.null7ptr.data_structure.tree.NaryTreeNode;

public class SolutionApproachRecursion {
    public List<Integer> postorder(NaryTreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if(root == null) return ans;
        
        postorder(root, ans);
        return ans;
    }
    
    private void postorder(NaryTreeNode node, List<Integer> ans){
        if(node == null) return;
        
        for(NaryTreeNode child : node.children){
            postorder(child, ans);
        }
        
        ans.add(node.val);
    }
}