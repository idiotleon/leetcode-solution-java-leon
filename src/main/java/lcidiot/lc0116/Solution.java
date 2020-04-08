/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * 
 * to use previously established next pointers
 */
package main.java.lcidiot.lc0116;

import main.java.lcidiot.utils.Node;

public class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        
        Node leftmost = root;
        
        while(leftmost.left != null){
            Node head = leftmost;
            
            while(head != null){
                head.left.next = head.right;
                
                if(head.next != null) {
                    head.right.next = head.next.left;
                }
                
                head = head.next;
            }
            
            leftmost = leftmost.left;
        }
        
        return root;
    }
}