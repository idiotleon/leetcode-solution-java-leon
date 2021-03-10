/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 
 * Time Complexity:     O((4 ^ L) * (L + 1)) ~ O((4 ^ L) * L)
 *  T(n) = (3 or 4) * T(n - 1)
 * 
 * Space Complexity:    O(L) + O(4 ^ L)
 *  O(4 ^ L), consumed by the answer list
 * 
 * References:
 *  https://leetcode.com/problems/letter-combinations-of-a-phone-number/discuss/8064/My-java-solution-with-FIFO-queue
 */
package com.an7one.leetcode.lvl2.lc0017;

import java.util.LinkedList;
import java.util.List;

public class SolutionApproach0BFS {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        // sanity check
        if (digits == null || digits.isEmpty())
            return ans;

        final int L = digits.length();
        final String[] PHONE = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        ans.add("");

        while (ans.peek().length() != L) {
            String res = ans.poll();
            String letters = PHONE[digits.charAt(res.length()) - '0'];
            for (char ch : letters.toCharArray())
                ans.add(res + ch);
        }

        return ans;
    }
}