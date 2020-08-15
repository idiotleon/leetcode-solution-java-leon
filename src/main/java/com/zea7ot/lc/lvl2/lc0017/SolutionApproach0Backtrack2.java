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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach0Backtrack2 {
    private static final Map<String, String> phone = new HashMap<String, String>() {
        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }
    };

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<String>();
        // sanity check
        if (digits == null || digits.isEmpty())
            return ans;

        backtrack("", digits, ans);

        return ans;
    }

    private void backtrack(String combination, String nextDigits, List<String> ans) {
        if (nextDigits.isEmpty()) {
            ans.add(combination);
            return;
        }

        String digit = nextDigits.substring(0, 1);
        String letters = phone.get(digit);

        final int L = letters.length();
        for (int i = 0; i < L; i++) {
            String letter = letters.substring(i, i + 1);
            backtrack(combination + letter, nextDigits.substring(1), ans);
        }
    }
}