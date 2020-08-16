/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 
 * Time Complexity:     O((4 ^ L) * (L + 1)) ~ O((4 ^ L) * L)
 *  T(n) = (3 or 4) * T(n - 1)
 * 
 * Space Complexity:    O(L) + O(4 ^ L)
 *  O(4 ^ L), consumed by the answer list
 */
package com.zea7ot.lc.lvl2.lc0017;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack {
    private static final String[] phone = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<String>();
        // sanity check
        if (digits == null || digits.isEmpty())
            return ans;

        backtrack(new StringBuilder(), digits.toCharArray(), 0, ans);

        return ans;
    }

    private void backtrack(StringBuilder builder, char[] digits, int idx, List<String> ans) {
        final int N = digits.length;
        if (idx == N) {
            // time complexity: O(L)
            ans.add(builder.toString());
            return;
        }

        char digit = digits[idx];
        String letters = phone[digit - '0'];

        for (char ch : letters.toCharArray()) {
            builder.append(ch);
            backtrack(builder, digits, idx + 1, ans);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}