/**
 * https://leetcode.com/problems/find-leaves-of-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/find-leaves-of-binary-tree/discuss/83778/10-lines-simple-Java-solution-using-recursion-with-explanation
 */
package com.idiotleon.leetcode.lvl2.lc0366;

import java.util.ArrayList;
import java.util.List;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0PostorderRecursive {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        // sanity check
        if (root == null)
            return ans;

        getDepth(root, ans);
        return ans;
    }

    // postorder
    private int getDepth(TreeNode node, List<List<Integer>> res) {
        if (node == null)
            return -1;
        int level = 1 + Math.max(getDepth(node.left, res), getDepth(node.right, res));
        if (res.size() == level)
            res.add(new ArrayList<>());

        res.get(level).add(node.val);
        return level;
    }
}
