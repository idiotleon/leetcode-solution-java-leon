/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * 
 * Time Complexities:
 *  serialize:      O(L)
 *  deserialize:    O(L)
 * 
 * Space Complexities:
 *  serialize:      O(L)
 *  deserialize:    O(lg(L))
 * 
 * References:
 *  https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/74253/Easy-to-understand-Java-Solution/77363
 *  https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/74253/Easy-to-understand-Java-Solution
 */
package com.zea7ot.leetcode.ood.lvl4.lc0297;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0StringBuilder {
    private static final String SEPARATOR = "#";
    private static final String SPLITTER = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serialize(new StringBuilder(), root).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserialize(new ArrayDeque<String>(Arrays.asList(data.split(SPLITTER))));
    }

    private StringBuilder serialize(StringBuilder builder, TreeNode node) {
        if (node == null)
            return builder.append(SEPARATOR);
        builder.append(node.val).append(SPLITTER);
        serialize(builder, node.left).append(SPLITTER);
        serialize(builder, node.right);
        return builder;
    }

    // preorder
    private TreeNode deserialize(Deque<String> queue) {
        String cur = queue.poll();
        if (SEPARATOR.equals(cur))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }
}