/**
 * https://leetcode.com/problems/find-duplicate-subtrees/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N) + O(H) ~ O(N)
 * 
 * References:
 *  https://leetcode.com/problems/find-duplicate-subtrees/discuss/106055/C%2B%2B-Java-Clean-Code-with-Explanation
 *  https://leetcode.com/problems/find-duplicate-subtrees/discuss/106016/O(n)-time-and-space-lots-of-analysis
 * 
 *  whey the inorder traversal doest not work?
 *  https://leetcode.com/problems/find-duplicate-subtrees/discuss/106011/Java-Concise-Postorder-Traversal-Solution/247483
 */
package com.zea7ot.leetcode.lvl3.lc0652;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0PostorderRecursive1 {
    private static final String SEPARATOR = "#";
    private static final String SPLITTER = ",";

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        // sanity check
        if (root == null)
            return ans;

        Map<String, List<TreeNode>> map = new HashMap<>();
        postorder(root, map);

        for (Map.Entry<String, List<TreeNode>> entry : map.entrySet())
            if (entry.getValue().size() > 1)
                ans.add(entry.getValue().get(0));

        return ans;
    }

    private String postorder(TreeNode node, Map<String, List<TreeNode>> map) {
        if (node == null)
            return SEPARATOR;

        String serial = node.val + SPLITTER + postorder(node.left, map) + SPLITTER + postorder(node.right, map);

        map.putIfAbsent(serial, new ArrayList<>());
        map.get(serial).add(node);

        return serial;
    }
}