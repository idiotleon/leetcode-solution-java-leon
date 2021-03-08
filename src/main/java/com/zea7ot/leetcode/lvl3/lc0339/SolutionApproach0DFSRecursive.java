/**
 * https://leetcode.com/problems/nested-list-weight-sum/
 * 
 * Time Complexity:     O(TOTAL_ELEMENTS(`nestedList`))
 * Space Complexity:    O(DEEPEST(`nestedList`))
 */
package com.zea7ot.leetcode.lvl3.lc0339;

import java.util.List;

import com.zea7ot.util.NestedInteger;

public class SolutionApproach0DFSRecursive {
    public int depthSum(List<NestedInteger> nestedList) {
        int[] sum = { 0 };
        dfs(1, nestedList, sum);
        return sum[0];
    }

    private void dfs(int depth, List<NestedInteger> nestedList, int[] sum) {
        for (NestedInteger cur : nestedList) {
            if (cur.isInteger()) {
                sum[0] += cur.getInteger() * depth;
            } else {
                dfs(depth + 1, cur.getList(), sum);
            }
        }
    }
}