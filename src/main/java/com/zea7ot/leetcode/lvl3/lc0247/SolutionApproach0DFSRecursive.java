/**
 * https://leetcode.com/problems/strobogrammatic-number-ii/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/strobogrammatic-number-ii/discuss/67280/AC-clean-Java-solution
 */
package com.zea7ot.leetcode.lvl3.lc0247;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionApproach0DFSRecursive {
    public List<String> findStrobogrammatic(int n) {
        return dfs(n, n);
    }

    private List<String> dfs(int n, int m) {
        if (n == 0)
            return Arrays.asList("");
        if (n == 1)
            return Arrays.asList("0", "1", "8");

        List<String> list = dfs(n - 2, m);

        List<String> res = new ArrayList<>();

        for (String str : list) {
            if (n != m)
                res.add("0" + str + "0");

            res.add("1" + str + "1");
            res.add("6" + str + "9");
            res.add("8" + str + "8");
            res.add("9" + str + "6");
        }

        return res;
    }
}