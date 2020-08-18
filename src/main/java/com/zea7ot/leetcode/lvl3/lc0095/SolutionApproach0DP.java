/**
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * https://leetcode.com/problems/unique-binary-search-trees-ii/discuss/31493/Java-Solution-with-DP
 */
package com.zea7ot.leetcode.lvl3.lc0095;

import java.util.ArrayList;
import java.util.List;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0DP {
    public List<TreeNode> generateTrees(int n) {
        List<List<TreeNode>> ans = new ArrayList<List<TreeNode>>(n + 1);
        for (int i = 0; i < n + 1; i++)
            ans.add(new ArrayList<TreeNode>());
        // sanity check
        if (n == 0)
            return ans.get(0);

        ans.get(0).add(null);
        for (int len = 1; len <= n; len++) {
            for (int j = 0; j < len; j++) {
                for (TreeNode nodeLeft : ans.get(j)) {
                    for (TreeNode nodeRight : ans.get(len - j - 1)) {
                        TreeNode node = new TreeNode(j + 1);
                        node.left = nodeLeft;
                        node.right = clone(nodeRight, j + 1);
                        ans.get(len).add(node);
                    }
                }
            }
        }

        return ans.get(n);
    }

    private static TreeNode clone(TreeNode n, int offset) {
        if (n == null)
            return null;

        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }
}