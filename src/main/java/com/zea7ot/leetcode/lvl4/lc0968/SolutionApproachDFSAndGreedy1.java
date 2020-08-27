/**
 * https://leetcode.com/problems/binary-tree-cameras/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * Here is our greedy solution:
 *  Set cameras on all leaves' parents, thenremove all covered nodes.
 *  Repeat step 1 until all nodes are covered.
 * 
 * 
 * References
 *  https://leetcode.com/problems/binary-tree-cameras/discuss/211180/JavaC%2B%2BPython-Greedy-DFS
 */
package com.zea7ot.leetcode.lvl4.lc0968;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproachDFSAndGreedy1 {
    public int minCameraCover(TreeNode root) {
        // sanity check
        if (root == null)
            return 0;

        int[] cameras = { 0 };
        return (postorder(root, cameras) == 0 ? 1 : 0) + cameras[0];
    }

    private int postorder(TreeNode node, int[] cameras) {
        if (node == null)
            return 2;
        int left = postorder(node.left, cameras);
        int right = postorder(node.right, cameras);

        if (left == 0 || right == 0) {
            ++cameras[0];
            return 1;
        }

        if (left == 1 || right == 1) {
            return 2;
        }

        return 0;
    }
}