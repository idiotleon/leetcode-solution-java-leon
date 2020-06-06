/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
package com.zea7ot.lc.lvl4.lc0117;

import java.util.LinkedList;
import java.util.Queue;

import com.zea7ot.data_structure.tree.TreeNodeWithNextPtr;

public class SolutionApproachBFS {
    public TreeNodeWithNextPtr connect(TreeNodeWithNextPtr root) {
        if(root == null) return root;
        
        Queue<TreeNodeWithNextPtr> queue = new LinkedList<TreeNodeWithNextPtr>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                TreeNodeWithNextPtr cur = queue.poll();
                if(i < size - 1) cur.next = queue.peek();
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
        }
        
        return root;
    }
}