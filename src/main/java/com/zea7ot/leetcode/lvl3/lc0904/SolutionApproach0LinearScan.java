/**
 * https://leetcode.com/problems/fruit-into-baskets/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/fruit-into-baskets/discuss/170745/Problem:-Longest-Subarray-With-2-Elements/196453
 *  https://leetcode.com/problems/fruit-into-baskets/discuss/170745/Problem%3A-Longest-Subarray-With-2-Elements
 */
package com.zea7ot.leetcode.lvl3.lc0904;

public class SolutionApproach0LinearScan {
    public int totalFruit(int[] trees) {
        // sanity check
        if (trees == null || trees.length == 0)
            return 0;

        int fruitLast = -1, fruitSecLast = -1;
        int cntLastFruit = 0;
        int len = 0, longest = 0;

        for (int fruit : trees) {
            if (fruit == fruitLast || fruit == fruitSecLast)
                ++len;
            else
                len = cntLastFruit + 1; // last fruit + new fruit

            if (fruit == fruitLast)
                ++cntLastFruit;
            else
                cntLastFruit = 1;

            // to take the last two types/fruits only
            if (fruit != fruitLast) {
                fruitSecLast = fruitLast;
                fruitLast = fruit;
            }

            longest = Math.max(longest, len);
        }

        return longest;
    }
}