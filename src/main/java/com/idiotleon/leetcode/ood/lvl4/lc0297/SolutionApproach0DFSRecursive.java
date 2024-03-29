/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * 
 * Time Complexities:
 *  serialize:      O(N)
 *  deserialize:    O(L) / O(N)
 * 
 * Space Complexities:
 *  serialize:      O(H)
 *  deserialize:    O(lg(L)) / O(H)
 * 
 * References:
 *  https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/74253/Easy-to-understand-Java-Solution/77363
 *  https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/74253/Easy-to-understand-Java-Solution
 */
package com.idiotleon.leetcode.ood.lvl4.lc0297;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFSRecursive {
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