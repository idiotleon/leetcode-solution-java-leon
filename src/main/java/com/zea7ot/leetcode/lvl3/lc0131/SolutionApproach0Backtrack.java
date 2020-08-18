/**
 * https://leetcode.com/problems/palindrome-partitioning/
 * 
 * Time Complexity:     O((2 ^ N) * (N ^ 2))
 * Space Complexity:    O(N)
 * 
 * 
 * References:
 *  https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 *  https://leetcode.com/problems/palindrome-partitioning/discuss/41982/Java-DP-%2B-DFS-solution
 */
package com.zea7ot.leetcode.lvl3.lc0131;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        // sanity check
        if (s == null || s.isEmpty())
            return ans;

        backtrack(0, new ArrayList<String>(), s, ans);
        return ans;
    }

    private void backtrack(int startIdx, List<String> intermediate, String str, List<List<String>> res) {
        final int L = str.length();
        if (startIdx == L) {
            res.add(new ArrayList<String>(intermediate));
            return;
        }

        for (int i = startIdx; i < L; i++) {
            if (isPalindrome(startIdx, i, str)) {
                intermediate.add(str.substring(startIdx, i + 1));
                backtrack(i + 1, intermediate, str, res);
                intermediate.remove(intermediate.size() - 1);
            }
        }
    }

    private boolean isPalindrome(int lo, int hi, String str) {
        char[] chs = str.toCharArray();
        while (lo < hi) {
            if (chs[lo++] != chs[hi--]) {
                return false;
            }
        }

        return true;
    }
}