/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
package main.java.lcidiot.lc0116;

import java.util.LinkedList;
import java.util.Queue;

import main.java.lcidiot.utils.Node;

class SolutionApproachBFS {
    public Node connect(Node root) {
        if(root == null) return root;
        
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node node = queue.poll();
                if(i < size - 1) node.next = queue.peek();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        
        return root;
    }
}