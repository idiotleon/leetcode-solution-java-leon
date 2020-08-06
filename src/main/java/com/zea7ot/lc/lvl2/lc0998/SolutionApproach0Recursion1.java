/**
 * https://leetcode.com/problems/maximum-binary-tree-ii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 *  always go right since new elements will be inserted at the end of the list
 * 
 * References:
 *  https://leetcode.com/problems/maximum-binary-tree-ii/discuss/243188/How-many-people-can't-understand-what-the-question-means
 *  https://leetcode.com/problems/maximum-binary-tree-ii/discuss/242916/C%2B%2BJava-with-picture-6-lines
 */
package com.zea7ot.lc.lvl2.lc0998;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0Recursion1 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        // sanity check
        if (root == null)
            return new TreeNode(val);

        if (root.val < val) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }

        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}