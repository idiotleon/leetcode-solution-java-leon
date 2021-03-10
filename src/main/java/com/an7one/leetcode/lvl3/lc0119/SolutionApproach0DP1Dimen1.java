/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 * 
 * Time Complexity:     O(`rowIndex`)
 * Space Complexity:    O(`rowIndex`)
 */
package com.an7one.leetcode.lvl3.lc0119;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0DP1Dimen1 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        // sanity check
        if (rowIndex < 0)
            return ans;

        for (int row = 0; row <= rowIndex; ++row) {
            ans.add(0, 1);
            for (int col = 1; col < ans.size() - 1; ++col) {
                ans.set(col, ans.get(col) + ans.get(col + 1));
            }
        }

        return ans;
    }
}