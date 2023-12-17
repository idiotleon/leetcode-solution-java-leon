package com.idiotleon.leetcode.lvl5.lc0273;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/integer-to-english-words/">LC0273</a>
 * <p>
 * Time Complexity:    O(L ^ 2) ~ O(32 ^ 2) ~ O(1)
 * Space Complexity:   O(L) ~ O(32) ~ O(1)
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/integer-to-english-words/discuss/70625/My-clean-Java-solution-very-easy-to-understand">LCDiscussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0ParsingString {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"Billion", "Million", "Thousand", ""};
    private final int[] RADIX = {(int) 1e9, (int) 1e6, (int) 1e3, 1};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        final StringBuilder builder = new StringBuilder();

        for (int i = 0; i < RADIX.length; ++i) {
            if (num / RADIX[i] == 0) {
                continue;
            }
            builder.append(helper(num / RADIX[i])).append(THOUSANDS[i]).append(" ");
            num %= RADIX[i];
        }

        return builder.toString().trim();
    }

    private String helper(int num) {
        if (num == 0) return "";
        else if (num < 20) return LESS_THAN_20[num] + " ";
        else if (num < 100) return TENS[num / 10] + " " + helper(num % 10);
        else return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
    }
}