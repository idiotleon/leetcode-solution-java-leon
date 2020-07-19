/**
 * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-depth-of-n-ary-tree/discuss/167010/DFS-and-BFS-solutions-in-C%2B%2B.
 */
package com.zea7ot.lc.lvl1.lc0559;

public class SolutionApproach0DFS {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        int depth = 0;
        for(Node child : root.children)
            depth = Math.max(depth, maxDepth(child));
        return 1 + depth;
    }
}