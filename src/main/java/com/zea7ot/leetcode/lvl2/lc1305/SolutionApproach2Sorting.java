/**
 * https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
 * 
 * Time Complexity:     O(N1 + N2)
 * Space Complexity:    O(N1 + N2)
 * 
 * References:
 *  https://leetcode.com/problems/all-elements-in-two-binary-search-trees/discuss/463852/JavaPython-3-2-codes%3A-O(n)-time-w-analysis.
 * 
 * Timsort:
 *  https://en.wikipedia.org/wiki/Timsort
 *  https://stackoverflow.com/questions/32334319/why-does-collections-sort-use-mergesort-but-arrays-sort-does-not
 */
package com.zea7ot.leetcode.lvl2.lc1305;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach2Sorting {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new ArrayList<Integer>();
        inorder(root1, ans);
        inorder(root2, ans);
        // by applying Timsort
        Collections.sort(ans);
        return ans;
    }

    private void inorder(TreeNode node, List<Integer> res) {
        if (node == null)
            return;

        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }
}