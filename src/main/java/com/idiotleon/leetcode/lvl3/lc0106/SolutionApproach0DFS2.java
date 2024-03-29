/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.idiotleon.leetcode.lvl3.lc0106;

import java.util.HashMap;
import java.util.Map;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFS2 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // sanity check
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0
                || inorder.length != postorder.length)
            return null;

        final int N = postorder.length;
        Map<Integer, Integer> idxMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < N; i++) {
            idxMap.put(inorder[i], i);
        }
        int[] idxPostorder = new int[] { N - 1 };

        return dfs(idxMap, postorder, idxPostorder, 0, N);
    }

    private TreeNode dfs(Map<Integer, Integer> idxMap, int[] postorder, int[] idxPostorder, int inorderStart,
            int inorderEnd) {
        if (inorderStart == inorderEnd)
            return null;

        int rootVal = postorder[idxPostorder[0]];
        TreeNode root = new TreeNode(rootVal);
        int index = idxMap.get(rootVal);

        idxPostorder[0]--;
        root.right = dfs(idxMap, postorder, idxPostorder, index + 1, inorderEnd);
        root.left = dfs(idxMap, postorder, idxPostorder, inorderStart, index);

        return root;
    }
}