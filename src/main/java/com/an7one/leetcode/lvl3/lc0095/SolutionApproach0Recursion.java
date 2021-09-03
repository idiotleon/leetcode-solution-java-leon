package com.an7one.leetcode.lvl3.lc0095;

import java.util.ArrayList;
import java.util.List;

import com.an7one.util.Constant;
import com.an7one.util.data_structure.tree.TreeNode;

/**
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 * <p>
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Recursion {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end)
            list.add(null);

        for (int idx = start; idx <= end; idx++) {
            List<TreeNode> leftList = generateTrees(start, idx - 1);
            List<TreeNode> rightList = generateTrees(idx + 1, end);
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode root = new TreeNode(idx);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }

        return list;
    }
}