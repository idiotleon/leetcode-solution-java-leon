/**
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
 * 
 * Time Complexity:     O(N * LEN) ~ O(`LEN_P`)
 * Space Complexity:    O(N * LEN) ~ O(`LEN_P`)
 * 
 * References:
 *  https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/discuss/78566/Java-intuitive-22ms-solution-with-stack/83369
 *  https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/discuss/78566/Java-intuitive-22ms-solution-with-stack
 */
package com.idiotleon.leetcode.lvl3.lc0331;

public class SolutionApproach0Stack {
    private static final String SPLITTER = ",";
    private static final String NULL_NODE = "#";

    public boolean isValidSerialization(String preorder) {
        // sanity check
        // final int LEN_P = preorder.length();

        String[] nodes = preorder.split(SPLITTER);
        final int N = nodes.length;

        int stack = 0;
        int idx = 0;
        for (String node : nodes) {
            if (node.equals(NULL_NODE)) {
                if (stack == 0)
                    break;

                --stack;
            } else
                ++stack;

            ++idx;
        }

        return stack == 0 && idx == N - 1 && nodes[idx].equals(NULL_NODE);
    }
}
