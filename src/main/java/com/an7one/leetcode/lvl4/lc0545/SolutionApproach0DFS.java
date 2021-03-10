/**
 * https://leetcode.com/problems/boundary-of-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H) + O(N) ~ O(N)
 * 
 * 1. `node.left` is a left boundary if the `node` is a left boundary
 *      `node.right` can also be a left boundary if `node` is a left boundary, and(&&) `node` has no left child
 * 2. the same applies for the right boundary
 * 3. if the `node` is a left boundary, to add it before the 2 children - preorder 
 *      if the `node` is a right boundary, to add it after the 2 children - postorder 
 * 4. to add all the leaves as the bottom boundary
 * 
 * References:
 *  https://leetcode.com/problems/boundary-of-binary-tree/discuss/101288/java-recursive-solution-beats-94
 *  https://leetcode.com/problems/boundary-of-binary-tree/discuss/101294/Java-C%2B%2B-Clean-Code-(1-Pass-perorder-postorder-hybrid)
 */
package com.an7one.leetcode.lvl4.lc0545;

import java.util.ArrayList;
import java.util.List;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFS {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if (root == null)
            return ans;

        ans.add(root.val);
        dfs(true, false, root.left, ans);
        dfs(false, true, root.right, ans);

        return ans;
    }

    private void dfs(boolean isLeftBoundary, boolean isRightBoundary, TreeNode node, List<Integer> res) {
        if (node == null)
            return;

        if (node.left == null && node.right == null) {
            res.add(node.val);
            return;
        }

        if (isLeftBoundary) {
            res.add(node.val);
        }

        // dfs(node.left != null && isLeftBoundary, node.right == null &&
        // isRightBoundary, node.left, res);
        dfs(isLeftBoundary, node.right == null && isRightBoundary, node.left, res);

        // dfs(node.left == null && isLeftBoundary, node.right != null &&
        // isRightBoundary, node.right, res);
        dfs(node.left == null && isLeftBoundary, isRightBoundary, node.right, res);

        if (isRightBoundary) {
            res.add(node.val);
        }
    }
}