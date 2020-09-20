/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * to top-down DFS
 */
package com.zea7ot.leetcode.lvl3.lc0105;

import java.util.HashMap;
import java.util.Map;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0DFSRecursive {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // sanity check
        if (inorder == null || inorder.length == 0 || preorder == null || preorder.length == 0
                || inorder.length != preorder.length)
            return null;

        final int N = preorder.length;
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < N; ++i) {
            idxMap.put(inorder[i], i);
        }
        int[] idxPreorder = { 0 };

        return dfs(idxPreorder, preorder, 0, N, idxMap);
    }

    private TreeNode dfs(int[] idxPreorder, int[] preorder, int inorderStart, int inorderEnd,
            Map<Integer, Integer> idxMap) {
        if (inorderStart == inorderEnd)
            return null;

        int rootVal = preorder[idxPreorder[0]];
        TreeNode root = new TreeNode(rootVal);
        int index = idxMap.get(rootVal);

        ++idxPreorder[0];
        root.left = dfs(idxPreorder, preorder, inorderStart, index, idxMap);
        root.right = dfs(idxPreorder, preorder, index + 1, inorderEnd, idxMap);

        return root;
    }
}