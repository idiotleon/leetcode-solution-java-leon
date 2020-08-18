/**
 * https://leetcode.com/problems/stamping-the-sequence/
 * 
 * Time Complexity:     O(LEN_S * (LEN_T - LEN_S))
 * Space Complexity:    O(LEN_T)
 * 
 * the basic idea is to, built in a reversed order, from the last step to the first step,
 *  greedily match/replace/stamp `target` from `stamp` as long/complete as possible
 * 
 * References:
 *  https://leetcode.com/problems/stamping-the-sequence/discuss/201546/12ms-Java-Solution-Beats-100
 */
package com.zea7ot.leetcode.lvl4.lc0936;

import java.util.LinkedList;

public class SolutionApproach0Greedy {
    private static final char PLACE_HOLDER = '*';

    public int[] movesToStamp(String stamp, String target) {
        // sanity check
        if (stamp == null || stamp.isEmpty() || target == null || target.isEmpty())
            return new int[0];

        final int LEN_S = stamp.length(), LEN_T = target.length();
        final char[] CHS_S = stamp.toCharArray();
        final char[] CHS_T = target.toCharArray();
        LinkedList<Integer> ans = new LinkedList<Integer>();
        boolean[] seen = new boolean[LEN_T];
        int asterisks = 0;

        while (asterisks < LEN_T) {
            boolean targetFound = false;
            for (int i = 0; i <= LEN_T - LEN_S; ++i) {
                if (seen[i] || !canReplace(i, CHS_T, CHS_S))
                    continue;
                asterisks += replace(i, CHS_T, LEN_S);
                targetFound = true;
                seen[i] = true;
                // since the process/replacement is done in a reversed way
                ans.addFirst(i);
                // without this line, the answer is valid but may not the shortest
                if (asterisks == LEN_T)
                    break;
            }

            if (!targetFound)
                return new int[0];
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }

    /**
     * to check whether, starting at the given index, `target` can be replaced by
     * `stamp`
     * 
     * `PLACE_HOLDER` can match any ONE character
     * 
     * Time Complexity: O(LEN_S) Space Complexity: O(1)
     * 
     * @param start the starting index
     * @param CHS_T the target char array
     * @param CHS_S the stamp char array
     * @return true if it can be replaced
     */
    private boolean canReplace(int start, final char[] CHS_T, final char[] CHS_S) {
        final int LEN_S = CHS_S.length;
        for (int i = 0; i < LEN_S; ++i) {
            if (CHS_T[start + i] != PLACE_HOLDER && CHS_T[start + i] != CHS_S[i])
                return false;
        }

        return true;
    }

    /**
     * to replace characters, starting at the given index,
     * 
     * Time Complexity: O(LEN_S) Space Complexity: O(1)
     * 
     * @param start the starting index
     * @param CHS_T the target char array
     * @param LEN_S the length of `stamp`
     * @return number of new place holders
     */
    private int replace(int start, final char[] CHS_T, final int LEN_S) {
        int count = 0;

        for (int i = 0; i < LEN_S; ++i) {
            if (CHS_T[start + i] == PLACE_HOLDER)
                continue;
            CHS_T[start + i] = PLACE_HOLDER;
            ++count;
        }

        return count;
    }
}