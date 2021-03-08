/**
 * https://leetcode.com/problems/encode-n-ary-tree-to-binary-tree/
 * 
 * Time Complexities:
 *      encode():
 *      decode()
 * 
 * Space Complexity:    
 * 
 * 
 * References:
 *  https://leetcode.com/problems/encode-n-ary-tree-to-binary-tree/discuss/153061/Java-Solution-(Next-Level-greater-left-Same-Level-greater-right)/197436
 *  https://leetcode.com/problems/encode-n-ary-tree-to-binary-tree/discuss/153061/Java-Solution-(Next-Level-greater-left-Same-Level-greater-right)
 */
package com.zea7ot.leetcode.ood.lvl4.lc0431;

import java.util.ArrayList;
import java.util.List;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFSRecursive {
    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if (root == null)
            return null;

        List<Node> level = new ArrayList<>();
        level.add(root);
        return encode(level);
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if (root == null)
            return null;

        List<Node> level = new ArrayList<>();
        decode(root, level);

        return level.get(0);
    }

    private TreeNode encode(List<Node> level) {
        if (level.isEmpty())
            return null;

        Node first = level.remove(0);
        TreeNode root = new TreeNode(first.val);

        if (!first.children.isEmpty()) {
            root.left = encode(first.children);
        }

        root.right = encode(level);

        return root;
    }

    private void decode(TreeNode node, List<Node> level) {
        if (node == null)
            return;

        Node root = new Node(node.val, new ArrayList<>());
        level.add(root);

        // `right` is the first sibling
        decode(node.right, level);

        // `left` is the first child
        decode(node.left, root.children);
    }
}
