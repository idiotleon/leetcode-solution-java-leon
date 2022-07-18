package com.an7one.leetcode.lvl2.lc1490;

import com.an7one.util.Constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/clone-n-ary-tree/">LC1490</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DFSRecursive1 {
    public Node cloneTree(Node root) {
        final Map<Node, Node> map = new HashMap<>();

        return dfs(root, map);
    }

    private Node dfs(final Node cur, final Map<Node, Node> map) {
        if (cur == null)
            return null;

        if (map.containsKey(cur))
            return map.get(cur);

        map.put(cur, new Node(cur.val));

        for (final Node next : cur.children) {
            map.get(cur).children.add(dfs(next, map));
        }

        return map.get(cur);
    }
}
