/**
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
 *
 * Time Complexity:     O(`LEN_P`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/discuss/78551/7-lines-Easy-Java-Solution/83284
 *  https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/discuss/78551/7-lines-Easy-Java-Solution/188285
 *  https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/discuss/78551/7-lines-Easy-Java-Solution
 */
package com.idiotleon.leetcode.lvl3.lc0331;

public class SolutionApproach0CountInOutDegrees {
    private static final String SPLITTER = ",";
    private static final String NULL_NODE = "#";

    public boolean isValidSerialization(String preorder) {
        // not used
        // final int LEN_P = preorder.length();

        String[] nodes = preorder.split(SPLITTER);

        int indegree = 1, outdegree = 0;
        for (String node : nodes) {
            --indegree;
            if (outdegree + indegree < 0)
                return false;
            if (!node.equals(NULL_NODE))
                outdegree += 2;
        }

        return indegree + outdegree == 0;
    }
}
