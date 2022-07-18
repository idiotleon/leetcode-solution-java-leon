package com.an7one.leetcode.lvl2.lc1490;

import com.an7one.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/clone-n-ary-tree/">LC1490</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DFSRecursive {
    public Node cloneTree(Node root) {
        return dfs(root);
    }

    private Node dfs(final Node cur) {
        if (cur == null)
            return null;

        final Node cloned = new Node(cur.val);

        for (final Node next : cur.children) {
            cloned.children.add(dfs(next));
        }

        return cloned;
    }
}
