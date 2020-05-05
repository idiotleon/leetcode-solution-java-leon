/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
package com.polyg7ot.lc.lvl3.lc0116;

import com.polyg7ot.data_structure.tree.TreeNodeWithNextPtr;

public class SolutionApproachDFSTopDown {
    public TreeNodeWithNextPtr connect(TreeNodeWithNextPtr root) {
        if(root == null) return root;
        
        dfs(root);
        
        return root;
    }
    
    private void dfs(TreeNodeWithNextPtr root){
        if(root == null) return;
        
        if(root.left != null){
            root.left.next = root.right;
            
            if(root.next != null){
                root.right.next = root.next.left;
            }
        }
        
        connect(root.left);
        connect(root.right);
    }
}