/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/discuss/39611/Is-it-Best-Solution-with-O(n)-O(1).
 */
package com.an7one.leetcode.lvl5.lc0123;

public class SolutionApproach0DP0Dimen1 {
    public int maxProfit(int[] prices) {
        // sanity check
        if (prices == null || prices.length == 0)
            return 0;

        int held1 = Integer.MIN_VALUE, held2 = Integer.MIN_VALUE;
        int sold1 = 0, sold2 = 0;
        for (int price : prices) {
            sold2 = Math.max(sold2, held2 + price);
            held2 = Math.max(held2, sold1 - price);
            sold1 = Math.max(sold1, held1 + price);
            held1 = Math.max(held1, -price);
        }

        return sold2;
    }
}