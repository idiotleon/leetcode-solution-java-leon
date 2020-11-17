/**
 * https://leetcode.com/problems/serialize-and-deserialize-bst/
 *
 * Time Complexities:
 *  `serialize()`:          O(nTreeNodes)
 *  `deserialize()`:        O(nTreeNodes)
 *
 * Space Complexity:        O(nTreeNodes)
 * 
 * References:
 *  https://leetcode.com/problems/serialize-and-deserialize-bst/discuss/177617/the-General-Solution-for-Serialize-and-Deserialize-BST-and-Serialize-and-Deserialize-BT
 */
package com.zea7ot.leetcode.ood.lvl3.lc0449;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0DFSRecursive {
    private static final String SPLITTER = ",";
    private static final String SEPARATOR = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        serialize(root, builder);
        return builder.toString();
    }

    private void serialize(TreeNode root, StringBuilder builder) {
        if (root == null)
            builder.append(SEPARATOR).append(SPLITTER);
        else {
            builder.append(root.val).append(SPLITTER);
            serialize(root.left, builder);
            serialize(root.right, builder);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> queue = new ArrayDeque<>(Arrays.asList(data.split(SPLITTER)));
        return deserialize(queue);
    }

    private TreeNode deserialize(Deque<String> queue) {
        String str = queue.poll();
        if (str.equals(SEPARATOR))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(str));
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }
}