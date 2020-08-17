/**
 * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 */
package com.zea7ot.leetcode.lvl1.lc0559;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0BFS {
    public int maxDepth(Node root) {
        // sanity check
        if(root == null) return 0;
        
        Deque<Node> queue = new ArrayDeque<Node>();
        queue.offer(root);
        
        int depth = 0;
        while(!queue.isEmpty()){
            int SIZE = queue.size();
            for(int i = 0; i < SIZE; i++){
                Node cur = queue.poll();
                if(cur.children != null && !cur.children.isEmpty()){
                    queue.addAll(cur.children);
                }
            }
            
            ++depth;
        }
        
        return depth;
    }
}