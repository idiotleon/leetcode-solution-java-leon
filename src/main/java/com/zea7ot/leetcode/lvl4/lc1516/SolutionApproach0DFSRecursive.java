/**
 * https://leetcode.com/problems/move-sub-tree-of-n-ary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/move-sub-tree-of-n-ary-tree/
 */
package com.zea7ot.leetcode.lvl4.lc1516;

public class SolutionApproach0DFSRecursive {
    public Node moveSubTree(Node root, Node p, Node q) {
        if (q.children.contains(p)) {
            return root;
        }

        Node[] parents = new Node[2];
        findParents(root, p, q, parents);

        if (inSubtree(p, q)) { // if `p` is in the subtree of `q`
            parents[1].children.remove(q);
            q.children.add(p);
            if (parents[0] == null) {
                return q;
            }

            int index = parents[0].children.indexOf(p);
            parents[0].children.set(index, q);
        } else {
            q.children.add(p);
            parents[0].children.remove(p);
        }

        return root;
    }

    private void findParents(Node cur, Node p, Node q, Node[] parents) {
        if (cur == null)
            return;

        for (Node next : cur.children) {
            if (next.val == p.val) {
                parents[0] = cur;
            }

            if (next.val == q.val) {
                parents[1] = cur;
            }

            findParents(next, p, q, parents);
        }
    }

    /**
     * to check whether the `cur` node is in the subtree of `parent` node
     * 
     * @param cur
     * @param parent
     * @return
     */
    private boolean inSubtree(Node cur, Node parent) {
        if (cur == null)
            return false;

        if (cur.val == parent.val)
            return true;

        for (Node next : cur.children) {
            if (inSubtree(next, parent))
                return true;
        }

        return false;
    }
}
