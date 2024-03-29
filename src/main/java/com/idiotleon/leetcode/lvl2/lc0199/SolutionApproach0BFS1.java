package com.idiotleon.leetcode.lvl2.lc0199;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.idiotleon.util.Constant;
import com.idiotleon.util.data_structure.tree.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BFS1 {
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<>();
        int maxDepth = -1;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();
        nodeQueue.add(root);
        depthQueue.add(0);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
            int depth = depthQueue.remove();

            if (node == null)
                continue;
            maxDepth = Math.max(maxDepth, depth);
            rightmostValueAtDepth.put(depth, node.val);

            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
            depthQueue.add(depth + 1);
            depthQueue.add(depth + 1);

        }

        List<Integer> rightView = new ArrayList<>();
        for (int depth = 0; depth <= maxDepth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }

        return rightView;
    }
}