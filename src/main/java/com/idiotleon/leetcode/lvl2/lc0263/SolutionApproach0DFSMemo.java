/**
 * https://leetcode.com/problems/ugly-number/
 * 
 * Time Complexity:     O(lg(`num`))
 * Space Complexity:    O(lg('num'))
 * 
 * References:
 *  https://leetcode.com/problems/ugly-number/discuss/69332/Simple-java-solution-with-explanation/71340
 */
package com.idiotleon.leetcode.lvl2.lc0263;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0DFSMemo {
    public boolean isUgly(int num) {
        Map<Integer, Boolean> memo = new HashMap<>();
        return isUgly(num, memo);
    }

    private boolean isUgly(int num, Map<Integer, Boolean> memo) {
        if (memo.containsKey(num))
            return memo.get(num);

        if (num <= 0)
            return false;
        if (num == 1)
            return true;

        if (num % 5 == 0) {
            memo.put(num, isUgly(num / 5, memo));
            return memo.get(num);
        }

        if (num % 3 == 0) {
            memo.put(num, isUgly(num / 3, memo));
            return memo.get(num);
        }

        if (num % 2 == 0) {
            memo.put(num, isUgly(num / 2, memo));
            return memo.get(num);
        }

        return false;
    }
}