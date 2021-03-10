/**
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
 * 
 * Time Complexity:     O(N * LEN) ~ O(`LEN_P`)
 * Space Complexity:    O(N * LEN) ~ O(`LEN_P`)
 * 
 * References:
 *  https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/discuss/78692/Simple-O(n)-Solution
 */
package com.an7one.leetcode.lvl3.lc0331;

public class SolutionApproach0PreorderIterative {
    private static final String SPLITTER = ",";
    private static final String NULL_NODE = "#";

    public boolean isValidSerialization(String preorder) {
        // sanity check
        // final int LEN_P = preorder.length();

        String[] nodes = preorder.split(SPLITTER);
        final int N = nodes.length;

        int depth = 0;
        int idx = 0;
        while (idx < N - 1) {
            if (nodes[idx++].equals(NULL_NODE)) {
                if (depth == 0)
                    return false;
                else
                    --depth;
            } else
                ++depth;
        }

        if (depth != 0)
            return false;
        return nodes[N - 1].equals(NULL_NODE);
    }
}
