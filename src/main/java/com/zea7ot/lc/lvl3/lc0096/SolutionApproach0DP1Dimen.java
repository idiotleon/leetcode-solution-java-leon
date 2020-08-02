/**
 * https://leetcode.com/problems/unique-binary-search-trees/
 * 
 * Time Complexity:     O(n ^ 2)
 * Space Complexity:    O(n)
 * 
 * `dp[k]`, the number of BSTs built from 1...k
 * 
 * to build a tree, one needs to pick a `root` node, 
 *  and know how many possible left and right subtrees can be built under that node.
 *  The result is to multiply them.
 * 
 * References:
 *  https://leetcode.com/problems/unique-binary-search-trees/discuss/31707/Fantastic-Clean-Java-DP-Solution-with-Detail-Explaination
 *  https://leetcode.com/problems/unique-binary-search-trees/discuss/703488/Detailed-Explanation-%3A-Mental-Leap-on-Why-the-approach-actually-works
 * 
 * Catalan number:
 *  https://en.wikipedia.org/wiki/Catalan_number
 */
package com.zea7ot.lc.lvl3.lc0096;

public class SolutionApproach0DP1Dimen {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int level = 2; level <= n; ++level)
            for (int root = 1; root <= level; ++root)
                dp[level] += dp[level - root] * dp[root - 1];

        return dp[n];
    }
}