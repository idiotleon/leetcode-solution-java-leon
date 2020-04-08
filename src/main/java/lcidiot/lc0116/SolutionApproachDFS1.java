/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
package main.java.lcidiot.lc0116;

import main.java.lcidiot.utils.Node;

public class SolutionApproachDFS1 {
    public Node connect(Node root) {
        if(root == null) return root;
        
        dfs(root);
        
        return root;
    }
    
    private void dfs(Node root){
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