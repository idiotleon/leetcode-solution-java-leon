/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
package com.null7ptr.lc.lvl3.lc0116;

import com.null7ptr.data_structure.tree.TreeNodeWithNextPtr;

public class SolutionApproachDFSTopDown1 {
    public TreeNodeWithNextPtr connect(TreeNodeWithNextPtr root) {
        if(root == null) return root;
            
        if(root.left != null){
            root.left.next = root.right;
            
            if(root.next != null){
                root.right.next = root.next.left;
            }
        }
                
        connect(root.left);
        connect(root.right);
            
        return root;
    }
}