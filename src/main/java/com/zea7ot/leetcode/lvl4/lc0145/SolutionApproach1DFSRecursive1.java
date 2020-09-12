/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * #FunctionalProgramming
 * 
 * References:
 *  https://www.youtube.com/watch?v=A6iCX_5xiU4
 *  http://zxi.mytechroad.com/blog/tree/leetcode-145-binary-tree-postorder-traversal/
 */
package com.zea7ot.leetcode.lvl4.lc0145;

import java.util.ArrayList;
import java.util.List;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach1DFSRecursive1 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        // sanity check
        if (root == null)
            return ans;

        final List<Integer> LEFT = postorderTraversal(root.left);
        final List<Integer> RIGHT = postorderTraversal(root.right);

        ans.addAll(LEFT);
        ans.addAll(RIGHT);
        ans.add(root.val);
        return ans;
    }
}