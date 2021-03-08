/**
 * https://leetcode.com/problems/find-duplicate-subtrees/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N) + O(H) ~ O(N)
 * 
 * References:
 *  https://leetcode.com/problems/find-duplicate-subtrees/discuss/106011/Java-Concise-Postorder-Traversal-Solution
 *  https://leetcode.com/problems/find-duplicate-subtrees/discuss/106016/O(n)-time-and-space-lots-of-analysis
 * 
 *  why the inorder traversal doest not work?
 *  https://leetcode.com/problems/find-duplicate-subtrees/discuss/106011/Java-Concise-Postorder-Traversal-Solution/247483
 */
package com.zea7ot.leetcode.lvl3.lc0652;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0PostorderRecursive {
    private static final String SEPARATOR = "#";
    private static final String SPLITTER = ",";

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        // sanity check
        if (root == null)
            return ans;

        Map<String, Integer> freq = new HashMap<>();
        postorder(root, freq, ans);
        return ans;
    }

    private String postorder(TreeNode node, Map<String, Integer> freq, List<TreeNode> res) {
        if (node == null)
            return SEPARATOR;

        String serial = node.val + SPLITTER + postorder(node.left, freq, res) + SPLITTER
                + postorder(node.right, freq, res);

        // only to add the node when met for the first time
        if (freq.getOrDefault(serial, 0) == 1)
            res.add(node);

        freq.put(serial, freq.getOrDefault(serial, 0) + 1);

        return serial;
    }
}