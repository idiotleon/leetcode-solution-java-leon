/**
 * https://leetcode.com/problems/split-array-into-fibonacci-sequence/
 * 
 * Time Complexity:     O(10 ^ L)
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/split-array-into-fibonacci-sequence/discuss/133936/short-and-fast-backtracking-solution
 */
package com.idiotleon.leetcode.lvl3.lc0842;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack1 {
    public List<Integer> splitIntoFibonacci(String str) {
        List<Integer> ans = new ArrayList<>();
        // sanity check
        if (str == null || str.isEmpty())
            return ans;

        canBeFound(0, str, ans);
        return ans;
    }

    // to backtrack
    private boolean canBeFound(int idx, String str, List<Integer> res) {
        final int L = str.length();
        if (idx == L && res.size() >= 3)
            return true;

        for (int i = idx; i < L; ++i) {
            if (str.charAt(idx) == '0' && i > idx)
                break;

            long num = Long.parseLong(str.substring(idx, i + 1));
            if (num > Integer.MAX_VALUE)
                break;

            final int SIZE = res.size();

            // early termination
            if (SIZE >= 2 && num > res.get(SIZE - 1) + res.get(SIZE - 2))
                break;

            if (SIZE <= 1 || num == res.get(SIZE - 1) + res.get(SIZE - 2)) {
                res.add((int) num);
                if (canBeFound(i + 1, str, res))
                    return true;

                res.remove(res.size() - 1);
            }
        }

        return false;
    }
}
