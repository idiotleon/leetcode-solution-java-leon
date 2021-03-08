/**
 * @author: Leon
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * 
 * Time Complexities:
 *  `serialize()`:      O(N)
 *  `deserialize()`:    O(L) / O(N)
 * 
 * Space Complexity:
 *  `serialize()`:      O(W)
 *  `deserialize()`:    O(L) / O(N)
 * 
 * this approach is not only low efficient, which always checks the current level, intead of the next one,
 *  handling many `null`s, but also error prone.
 * 
 * please be careful with special characters
 */
package com.zea7ot.leetcode.ood.lvl4.lc0297;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach1BFS1 {
    private final static String PLACE_HOLDER = "#";
    private final static String SPLITTER = ";";
    private final static String NEW_LINE = "@";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";

        StringBuilder builder = new StringBuilder();

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                TreeNode cur = queue.poll();
                if (cur == null)
                    builder.append(PLACE_HOLDER).append(SPLITTER);
                else {
                    builder.append(cur.val).append(SPLITTER);

                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }

            builder.append(NEW_LINE);
        }

        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty())
            return null;

        String[] levels = data.split(NEW_LINE);
        String first = levels[0];

        int rootVal = Integer.parseInt(first.split(SPLITTER)[0]);
        TreeNode root = new TreeNode(rootVal);

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int level = 1;
        while (!queue.isEmpty()) {
            final int SIZE = queue.size();
            String curLevel = levels[level];
            String[] vals = curLevel.split(SPLITTER);
            int idx = 0;

            for (int i = 0; i < SIZE; ++i) {
                TreeNode cur = queue.poll();
                String leftVal = vals[idx++];
                if (!leftVal.equals(PLACE_HOLDER)) {
                    TreeNode left = new TreeNode(Integer.parseInt(leftVal));
                    cur.left = left;
                    queue.offer(left);
                }

                String rightVal = vals[idx++];
                if (!rightVal.equals(PLACE_HOLDER)) {
                    TreeNode right = new TreeNode(Integer.parseInt(rightVal));
                    cur.right = right;
                    queue.offer(right);
                }
            }

            ++level;
        }

        return root;
    }
}
