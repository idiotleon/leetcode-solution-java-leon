/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * a top-down approach
 */
package com.zea7ot.lc.lvl3.lc0116;

public class SolutionApproach0Preorder1 {
    public Node connect(Node root) {
        // sanity check
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