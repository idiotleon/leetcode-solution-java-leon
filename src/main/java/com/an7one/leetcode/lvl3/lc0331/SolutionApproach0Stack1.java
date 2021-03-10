/**
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
 * 
 * Time Complexity:     O(N * LEN) ~ O(`LEN_P`)
 * Space Complexity:    O(N * LEN) ~ O(`LEN_P`)
 * 
 * References:
 *  https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/discuss/78566/Java-intuitive-22ms-solution-with-stack
 */
package com.an7one.leetcode.lvl3.lc0331;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0Stack1 {
    private static final String SPLITTER = ",";
    private static final String NULL_NODE = "#";

    public boolean isValidSerialization(String preorder) {
        // sanity check
        // final int LEN_P = preorder.length();

        String[] nodes = preorder.split(SPLITTER);

        Deque<String> stack = new ArrayDeque<>();
        for (String node : nodes) {
            // to replace a number node and its left child null("#") node to a null("#")
            // node
            while (node.equals(NULL_NODE) && !stack.isEmpty() && stack.peek().equals(node)) {
                stack.pop();
                if (stack.isEmpty())
                    return false;

                stack.pop();
            }

            stack.push(node);
        }

        return stack.size() == 1 && stack.peek().equals(NULL_NODE);
    }
}
