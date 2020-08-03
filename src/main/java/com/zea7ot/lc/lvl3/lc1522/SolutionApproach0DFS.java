/**
 * https://leetcode.com/problems/diameter-of-n-ary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/diameter-of-n-ary-tree/discuss/755058/C%2B%2B-miminalizm
 */
package com.zea7ot.lc.lvl3.lc1522;

import com.zea7ot.utils.data_structure.tree.NaryTreeNode;

public class SolutionApproach0DFS {
    private int maxDiameter = 0;

    public int diameter(NaryTreeNode root) {
        return dfs(root, true);
    }

    public int dfs(NaryTreeNode node, boolean isRoot) {
        int maxDepth = 0;
        for (NaryTreeNode child : node.children) {
            int depth = 1 + dfs(child, false);
            maxDiameter = Math.max(maxDiameter, maxDepth + depth);
            maxDepth = Math.max(maxDepth, depth);
        }

        return isRoot ? maxDiameter : maxDepth;
    }
}