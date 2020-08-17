/**
 * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/discuss/210375/Simple-Java-Pre-Order-Solution
 */
package com.zea7ot.leetcode.lvl3.lc0430;

import java.util.Stack;

public class SolutionApproach0Preorder {
    public Node flatten(Node head) {
        // sanity check
        if(head == null) return head;
        
        Stack<Node> stack = new Stack<Node>();
        stack.push(head);
        Node prev = null;
        
        // preorder: root, child, next
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            if(prev != null){
                prev.next = cur;
                cur.prev = prev;
                prev.child = null;
            }
            if(cur.next != null) stack.push(cur.next);
            if(cur.child != null) stack.push(cur.child);
            prev = cur;
        }
        
        return head;
    }
}