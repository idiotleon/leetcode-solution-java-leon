/**
 * https://leetcode.com/problems/diameter-of-n-ary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/diameter-of-n-ary-tree/discuss/755058/C%2B%2B-miminalizm
 */
package com.idiotleon.leetcode.lvl3.lc1522;

import com.idiotleon.util.data_structure.tree.NaryTreeNode;

public class SolutionApproach0DFSRecursive {

    public int diameter(NaryTreeNode root) {
        int[] maxDiameter = { 0 };
        return dfs(root, true, maxDiameter);
    }

    private int dfs(NaryTreeNode node, boolean isRoot, int[] maxDiameter) {
        int maxDepth = 0;
        for (NaryTreeNode child : node.children) {
            int depth = 1 + dfs(child, false, maxDiameter);
            maxDiameter[0] = Math.max(maxDiameter[0], maxDepth + depth);
            maxDepth = Math.max(maxDepth, depth);
        }

        return isRoot ? maxDiameter[0] : maxDepth;
    }
}