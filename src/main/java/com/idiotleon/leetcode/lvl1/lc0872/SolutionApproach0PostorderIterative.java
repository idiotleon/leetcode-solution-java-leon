/**
 * https://leetcode.com/problems/leaf-similar-trees/
 * 
 * Time Complexity:     O(N1 + N2)
 * Space Complexity:    O(H1 + H2)
 * 
 * References:
 *  https://leetcode.com/problems/leaf-similar-trees/discuss/152329/C%2B%2BJavaPython-O(H)-Space
 */
package com.idiotleon.leetcode.lvl1.lc0872;

import java.util.ArrayDeque;
import java.util.Deque;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0PostorderIterative {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Deque<TreeNode> stack1 = new ArrayDeque<TreeNode>();
        stack1.push(root1);
        Deque<TreeNode> stack2 = new ArrayDeque<TreeNode>();
        stack2.push(root2);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (dfs(stack1) != dfs(stack2))
                return false;
        }

        return stack1.isEmpty() && stack2.isEmpty();
    }

    private int dfs(Deque<TreeNode> stack) {
        while (true) {
            TreeNode node = stack.pop();

            if (node.left != null)
                stack.push(node.left);

            if (node.right != null)
                stack.push(node.right);

            if (node.left == null && node.right == null)
                return node.val;
        }
    }
}