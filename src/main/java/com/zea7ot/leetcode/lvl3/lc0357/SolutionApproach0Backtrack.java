/**
 * https://leetcode.com/problems/count-numbers-with-unique-digits/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/count-numbers-with-unique-digits/discuss/83054/Backtracking-solution/87322
 */
package com.zea7ot.leetcode.lvl3.lc0357;

public class SolutionApproach0Backtrack {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;
        int count = 0;

        final boolean[] USED = new boolean[10];
        count += countNumbersWithUniqueDigits(n - 1);
        for (int i = 1; i < 10; i++) {
            USED[i] = true;
            count += backtrack(n - 1, USED);
            USED[i] = false;
        }
        return count;
    }

    private int backtrack(int n, final boolean[] USED) {
        if (n == 0)
            return 1;

        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (!USED[i]) {
                USED[i] = true;
                count += backtrack(n - 1, USED);
                USED[i] = false;
            }
        }

        return count;
    }
}