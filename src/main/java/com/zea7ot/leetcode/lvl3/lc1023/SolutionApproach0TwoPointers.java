/**
 * https://leetcode.com/problems/camelcase-matching/
 * 
 * Time Complexity: O(N * L)
 *  N, the number of words
 *  L, the average length of the words
 * 
 * Space Complexity:  O(N)
 *  N, the space comsumed by the answer list
 */
package com.zea7ot.leetcode.lvl3.lc1023;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0TwoPointers {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<Boolean>();
        for (String query : queries) {
            ans.add(isMatch(query, pattern));
        }

        return ans;
    }

    private boolean isMatch(String query, String pattern) {
        int idx = 0;
        for (char ch : query.toCharArray()) {
            if (idx < pattern.length() && ch == pattern.charAt(idx)) {
                ++idx;
            } else if (ch < 'a')
                return false;
        }

        return idx == pattern.length();
    }
}