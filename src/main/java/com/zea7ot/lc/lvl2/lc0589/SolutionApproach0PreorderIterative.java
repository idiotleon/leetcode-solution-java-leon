/**
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 * 
 * References:
 *  https://leetcode.com/problems/n-ary-tree-preorder-traversal/discuss/147955/Java-Iterative-and-Recursive-Solutions
 */
package com.zea7ot.lc.lvl2.lc0589;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SolutionApproach0PreorderIterative {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if(root == null) return ans;
        
        Deque<Node> stack = new ArrayDeque<Node>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            Node node = stack.pop();
            ans.add(node.val);
            final int SIZE = node.children.size();
            for(int i = SIZE - 1; i >= 0; i--)
                stack.push(node.children.get(i));
        }
        
        return ans;
    }
}