/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 
 * Time Complexity:     O((4 ^ L) * (L + 1)) ~ O((4 ^ L) * L)
 *  T(n) = (3 or 4) * T(n - 1)
 * 
 * Space Complexity:    O(L) + O(4 ^ L)
 *  O(4 ^ L), consumed by the answer list
 */
package com.idiotleon.leetcode.lvl2.lc0017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach0Backtrack1 {
    private static final Map<Character, String> phone = new HashMap<Character, String>() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<String>();
        // sanity check
        if (digits == null || digits.isEmpty())
            return ans;

        backtrack(new StringBuilder(), 0, digits.toCharArray(), ans);

        return ans;
    }

    private void backtrack(StringBuilder builder, int idx, final char[] DIGITS, List<String> res) {
        final int N = DIGITS.length;
        if (idx == N) {
            res.add(builder.toString());
            return;
        }

        char digit = DIGITS[idx];
        String letters = phone.get(digit);

        for (char ch : letters.toCharArray()) {
            builder.append(ch);
            backtrack(builder, idx + 1, DIGITS, res);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}