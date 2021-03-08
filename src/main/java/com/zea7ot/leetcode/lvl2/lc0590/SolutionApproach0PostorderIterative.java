/**
 * @author: Leon
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.leetcode.lvl2.lc0590;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.zea7ot.util.data_structure.tree.NaryTreeNode;

public class SolutionApproach0PostorderIterative {
    public List<Integer> postorder(NaryTreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        // sanity check
        if (root == null)
            return ans;

        Deque<NaryTreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            NaryTreeNode top = stack.pop();

            ans.addFirst(top.val);

            for (NaryTreeNode child : top.children) {
                stack.push(child);
            }
        }

        return ans;
    }
}
