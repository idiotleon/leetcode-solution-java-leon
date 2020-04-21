/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
package main.java.lcidiot.lc0116;

import main.java.lcidiot.data_structure.tree.TreeNodeWithNextPtr;

public class SolutionApproachDFS2 {
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