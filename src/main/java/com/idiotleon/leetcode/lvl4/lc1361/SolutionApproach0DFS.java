/**
 * https://leetcode.com/problems/validate-binary-tree-nodes/
 * 
 * Time Compelexity:    O(n)
 * Space Complexity:    O(n)
 * 
 * 1. the `count`(`indegree`) of all node should be 1, except the root, which is 0
 * 2. there should be only 1 root, meaning that there is only 1, not 0 not more, node with a `count`(`indegree1) of 0
 * 3. there should not be any cycle
 * 
 * References:
 *  https://leetcode.com/problems/validate-binary-tree-nodes/discuss/517557/C++-Find-Root-+-DFS/457479
 *  https://leetcode.com/problems/validate-binary-tree-nodes/discuss/517557/C++-Find-Root-+-DFS/641225
 *  https://leetcode.com/problems/validate-binary-tree-nodes/discuss/517557/C%2B%2B-Find-Root-%2B-DFS
 */
package com.idiotleon.leetcode.lvl4.lc1361;

public class SolutionApproach0DFS {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] counts = new int[n];
        for (int i = 0; i < n; ++i) {
            if (leftChild[i] != -1 && counts[leftChild[i]]++ == 1)
                return false;
            if (rightChild[i] != -1 && counts[rightChild[i]]++ == 1)
                return false;
        }

        int root = -1;
        for (int i = 0; i < n; ++i) {
            if (counts[i] == 0) {
                if (root != -1)
                    return false; // more than one roots
                root = i;
            }
        }

        if (root == -1)
            return false; // no root at all

        boolean[] visited = new boolean[n];
        // to detect any cycle
        boolean hasNoCycle = dfs(root, leftChild, rightChild, visited);
        if (!hasNoCycle)
            return false;

        // to make sure each node has been visited.
        // if there is any isolated node, it is not a tree
        for (boolean v : visited)
            if (!v)
                return false;

        return true;
    }

    private boolean dfs(int root, int[] leftChild, int[] rightChild, boolean[] visited) {
        if (root == -1)
            return true;
        if (visited[root])
            return false;
        visited[root] = true;
        return dfs(leftChild[root], leftChild, rightChild, visited)
                && dfs(rightChild[root], leftChild, rightChild, visited);
    }
}