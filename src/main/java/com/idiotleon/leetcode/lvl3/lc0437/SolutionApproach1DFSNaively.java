/**
 * https://leetcode.com/problems/path-sum-iii/
 * 
 * Time Complexity:     O(N * lg(N)) - O(N ^ 2)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/path-sum-iii/discuss/91889/Simple-Java-DFS/229040
 *  https://leetcode.com/problems/path-sum-iii/discuss/91878/17-ms-O(n)-java-Prefix-sum-method/96424
 *  https://leetcode.com/problems/path-sum-iii/discuss/91878/17-ms-O(n)-java-Prefix-sum-method/552675
 *  https://leetcode.com/problems/path-sum-iii/discuss/91889/Simple-Java-DFS
 */
package com.idiotleon.leetcode.lvl3.lc0437;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach1DFSNaively {
    public int pathSum(TreeNode root, int target) {
        if (root == null)
            return 0;
        return dfs(root, target) + pathSum(root.left, target) + pathSum(root.right, target);
    }

    private int dfs(TreeNode node, int target) {
        if (node == null)
            return 0;
        target -= node.val;
        return (target == 0 ? 1 : 0) + dfs(node.left, target) + dfs(node.right, target);
    }
}