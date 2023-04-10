/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References: 
 *  https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/discuss/34782/My-recursive-Java-code-with-O(n)-time-and-O(n)-space/33107
 */
package com.idiotleon.leetcode.lvl3.lc0106;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFS1 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // sanity check
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0
                || inorder.length != postorder.length)
            return null;

        final int N = postorder.length;
        int[] idxInorder = new int[] { N - 1 };
        int[] idxPostorder = new int[] { N - 1 };
        return dfs(inorder, idxInorder, postorder, idxPostorder, null);
    }

    /**
     * 
     * @param inorder
     * @param idxInorder
     * @param postorder
     * @param idxPostorder
     * @param end          the boundary of the left subtree
     * @return
     */
    private TreeNode dfs(int[] inorder, int[] idxInorder, int[] postorder, int[] idxPostorder, TreeNode end) {
        if (idxPostorder[0] < 0)
            return null;

        int rootVal = postorder[idxPostorder[0]];
        TreeNode root = new TreeNode(rootVal);
        idxPostorder[0]--;

        if (inorder[idxInorder[0]] != root.val) {
            root.right = dfs(inorder, idxInorder, postorder, idxPostorder, root);
        }

        idxInorder[0]--;
        if ((end == null) || (inorder[idxInorder[0]] != end.val)) {
            root.left = dfs(inorder, idxInorder, postorder, idxPostorder, end);
        }

        return root;
    }
}