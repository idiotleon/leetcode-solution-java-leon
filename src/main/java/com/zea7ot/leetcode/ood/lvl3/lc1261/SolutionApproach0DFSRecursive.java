/**
 * https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H) + O(N)
 * 
 * References:
 *  https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/discuss/431107/JavaPython-3-DFS-clean-code-w-analysis.
 */
package com.zea7ot.leetcode.ood.lvl3.lc1261;

import java.util.HashSet;
import java.util.Set;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFSRecursive {
    private final Set<Integer> SEEN;

    public SolutionApproach0DFSRecursive(TreeNode root) {
        this.SEEN = new HashSet<>();
        dfs(root, 0);
    }

    public boolean find(int target) {
        return SEEN.contains(target);
    }

    private void dfs(TreeNode node, int val) {
        if (node == null)
            return;

        node.val = val;
        SEEN.add(val);

        dfs(node.left, 2 * val + 1);
        dfs(node.right, 2 * val + 2);
    }
}
