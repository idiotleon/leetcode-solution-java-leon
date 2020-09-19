/**
 * https://leetcode.com/problems/binary-tree-paths/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.leetcode.lvl2.lc0257;

import java.util.ArrayList;
import java.util.List;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0PreorderRecursive {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        StringBuilder builder = new StringBuilder();
        backtrack(root, paths, builder);
        return paths;
    }

    private void backtrack(TreeNode node, List<String> paths, StringBuilder builder) {
        if (node == null)
            return;

        builder.append(Integer.toString(node.val));

        if (node.left == null && node.right == null) {
            paths.add(builder.toString());
            return;
        }

        final int LEN = builder.length();

        builder.append("->");
        backtrack(node.left, paths, builder);
        builder.setLength(LEN);

        builder.append("->");
        backtrack(node.right, paths, builder);
        builder.setLength(LEN);
    }
}