/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
package main.java.lcidiot.lc0117;

import java.util.LinkedList;
import java.util.Queue;

import main.java.lcidiot.utils.Node;

class Solution {
    // solution i: BFS
    public Node connect(Node root) {
       if(root == null) return root;
        
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                Node cur = queue.poll();
                
                if(i < size - 1) cur.next = queue.peek();
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
        }
        
        return root;
    }
}