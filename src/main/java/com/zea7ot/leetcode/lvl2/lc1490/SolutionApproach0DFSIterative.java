/**
 * @author: Leon
 * https://leetcode.com/problems/clone-n-ary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.leetcode.lvl2.lc1490;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0DFSIterative {
    public Node cloneTree(Node root) {
        // sanity check
        if(root == null) return root;
        
        Map<Node, Node> map = new HashMap<>();
        map.put(root, new Node(root.val));
        
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            
            for(Node next : cur.children){
                if(!map.containsKey(next)){
                    map.put(next, new Node(next.val));
                    stack.push(next);
                }
                
                map.get(cur).children.add(map.get(next));
            }
        }
        
        return map.get(root);
    }
}
