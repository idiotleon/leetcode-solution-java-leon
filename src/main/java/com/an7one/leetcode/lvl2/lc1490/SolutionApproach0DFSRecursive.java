package com.an7one.leetcode.lvl2.lc1490;

import com.an7one.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/clone-n-ary-tree/">Description</a>
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DFSRecursive {
    public Node cloneTree(Node root) {
        return dfs(root);
    }

    private Node dfs(Node cur) {
        if (cur == null)
            return null;

        Node cloned = new Node(cur.val);

        for (Node next : cur.children) {
            cloned.children.add(dfs(next));
        }

        return cloned;
    }
}
