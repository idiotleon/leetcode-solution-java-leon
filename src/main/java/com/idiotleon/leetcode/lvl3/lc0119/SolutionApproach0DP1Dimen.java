/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 * 
 * Time Complexity:     O(`rowIndex`)
 * Space Complexity:    O(`rowIndex`)
 * 
 * References:
 *  https://leetcode.com/problems/pascals-triangle-ii/discuss/38584/Another-accepted-Java-solution/653049
 *  https://leetcode.com/problems/pascals-triangle-ii/discuss/38584/Another-accepted-Java-solution
 */
package com.idiotleon.leetcode.lvl3.lc0119;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionApproach0DP1Dimen {
    public List<Integer> getRow(int rowIndex) {
        // sanity check
        if (rowIndex < 0)
            return new ArrayList<>();

        Integer[] res = new Integer[rowIndex + 1];
        Arrays.fill(res, 1);

        for (int row = 1; row <= rowIndex; ++row) {
            for (int col = row - 1; col > 0; --col) {
                res[col] = res[col] + res[col - 1];
            }
        }

        return Arrays.asList(res);
    }
}
