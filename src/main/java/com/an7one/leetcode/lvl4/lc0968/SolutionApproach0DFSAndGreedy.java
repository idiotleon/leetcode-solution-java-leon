/**
 * https://leetcode.com/problems/binary-tree-cameras/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/binary-tree-cameras/discuss/211966/Super-Clean-Java-solution-beat-100-DFS-O(n)-time-complexity
 */
package com.an7one.leetcode.lvl4.lc0968;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFSAndGreedy {
    private static final int NOT_MONITORED = 0;
    private static final int MONITORED_NO_CAM = 1;
    private static final int MONITORED_WITH_CAM = 2;

    public int minCameraCover(TreeNode root) {
        int[] cameras = { 0 };
        // sanity check
        if (root == null)
            return cameras[0];

        int top = postorder(root, cameras);
        return cameras[0] + (top == NOT_MONITORED ? 1 : 0);
    }

    private int postorder(TreeNode node, int[] cameras) {
        if (node == null)
            return MONITORED_NO_CAM;
        int left = postorder(node.left, cameras);
        int right = postorder(node.right, cameras);

        if (left == MONITORED_NO_CAM && right == MONITORED_NO_CAM) {
            return NOT_MONITORED;
        } else if (left == NOT_MONITORED || right == NOT_MONITORED) {
            ++cameras[0];
            return MONITORED_WITH_CAM;
        } else
            return MONITORED_NO_CAM;
    }
}