package com.an7one.leetcode.lvl4.lc0222;

import com.an7one.util.Constant;
import com.an7one.util.data_structure.tree.TreeNode;

/**
 * https://leetcode.com/problems/count-complete-tree-nodes/
 * <p>
 * Time Complexity:     O(lg(N) ^ 2)
 * Space Complexity:    O(lg(N))
 * <p>
 * to define the "midNode" of the last level as a node following the path "root->left->right->right->...->last level".
 * If midNode is null, then it means we should count the nodes on the last level in the left subtree.
 * If midNode is not null, then we add half of the last level nodes to our result and then count the nodes on the last level in the right subtree.
 * <p>
 * References:
 * https://leetcode.com/problems/count-complete-tree-nodes/discuss/61950/My-JAVA-solution-with-explanation-which-beats-99
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BinarySearch {
    public int countNodes(TreeNode root) {
        // sanity check
        if (root == null)
            return 0;
        if (root.left == null)
            return 1;
        int height = 0, sum = 0;
        TreeNode node = root;
        while (node.left != null) {
            sum += (1 << height);
            height++;
            node = node.left;
        }

        return sum + countLastLevel(root, height);
    }

    private int countLastLevel(TreeNode root, int height) {
        if (height == 1) {
            if (root.right != null)
                return 2;
            else if (root.left != null)
                return 1;
            else
                return 0;
        }

        TreeNode midNode = root.left;
        int curHeight = 1;
        while (curHeight < height) {
            ++curHeight;
            midNode = midNode.right;
        }

        if (midNode == null)
            return countLastLevel(root.left, height - 1);
        else
            return (1 << (height - 1)) + countLastLevel(root.right, height - 1);
    }
}