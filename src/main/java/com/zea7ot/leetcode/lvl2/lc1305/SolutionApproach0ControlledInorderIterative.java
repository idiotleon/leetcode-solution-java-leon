/**
 * https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
 * 
 * Time Complexity:     O(N1 + N2)
 * Space Complexity:    O(H1 + H2)
 * 
 * References:
 *  https://leetcode.com/problems/all-elements-in-two-binary-search-trees/discuss/464073/C++-One-Pass-Traversal/415886
 *  https://leetcode.com/problems/all-elements-in-two-binary-search-trees/discuss/464073/C++-One-Pass-Traversal/498140
 *  https://leetcode.com/problems/all-elements-in-two-binary-search-trees/discuss/464073/C%2B%2B-One-Pass-Traversal
 */
package com.zea7ot.leetcode.lvl2.lc1305;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0ControlledInorderIterative {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new ArrayList<Integer>();
        Deque<TreeNode> stack1 = new ArrayDeque<TreeNode>();
        pushLeft(root1, stack1);
        Deque<TreeNode> stack2 = new ArrayDeque<TreeNode>();
        pushLeft(root2, stack2);

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode node1 = stack1.peek();
            TreeNode node2 = stack2.peek();
            if (node1.val > node2.val)
                process(stack2, ans);
            else
                process(stack1, ans);
        }

        while (!stack1.isEmpty())
            process(stack1, ans);
        while (!stack2.isEmpty())
            process(stack2, ans);

        return ans;
    }

    private void process(Deque<TreeNode> stack, List<Integer> res) {
        TreeNode top = stack.pop();
        res.add(top.val);
        pushLeft(top.right, stack);
    }

    private void pushLeft(TreeNode node, Deque<TreeNode> stack) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}