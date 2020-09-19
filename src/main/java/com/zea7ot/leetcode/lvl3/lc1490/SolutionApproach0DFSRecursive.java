/**
 * https://leetcode.com/problems/clone-n-ary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.leetcode.lvl3.lc1490;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0DFSRecursive {
    public Node cloneTree(Node root) {
        Map<Node, Node> map = new HashMap<>();

        return dfs(root, map);
    }

    private Node dfs(Node cur, Map<Node, Node> map) {
        if (cur == null)
            return null;
        if (map.containsKey(cur))
            return map.get(cur);

        map.put(cur, new Node(cur.val));

        for (Node next : cur.children) {
            map.get(cur).children.add(dfs(next, map));
        }

        return map.get(cur);
    }
}
