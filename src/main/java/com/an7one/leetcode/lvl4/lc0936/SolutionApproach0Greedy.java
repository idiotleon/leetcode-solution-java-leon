package com.an7one.leetcode.lvl4.lc0936;

import com.an7one.util.Constant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/stamping-the-sequence/">LC0936</a>
 * <p>
 * Time Complexity:     O((`lenS` ^ 2) * (`lenT` - `lenS`))
 * Space Complexity:    O(`lenT`)
 * <p>
 * the basic idea is to, built in a reversed order, from the last step to the first step,
 * greedily match/replace/stamp `target` from `stamp` as long/complete as possible
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/stamping-the-sequence/discuss/201546/12ms-Java-Solution-Beats-100">LC Discussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Greedy {
    private static final char PLACE_HOLDER = '#';

    public int[] movesToStamp(final String stamp, final String target) {
        // sanity check
        if (stamp == null || stamp.isEmpty() || target == null || target.isEmpty())
            return new int[0];

        final int lenS = stamp.length(), lenT = target.length();
        final char[] chsS = stamp.toCharArray();
        final char[] chsT = target.toCharArray();
        final List<Integer> ans = new ArrayList<>();
        final boolean[] seen = new boolean[lenT];
        int idx = 0;

        while (idx < lenT) {
            boolean targetFound = false;
            for (int i = 0; i <= lenT - lenS; ++i) {
                if (seen[i] || !canReplace(i, chsT, chsS))
                    continue;
                idx += replace(i, chsT, lenS);
                targetFound = true;
                seen[i] = true;
                // since the process/replacement is done in a reversed way
                ans.add(i);
                // without this line, the answer is valid but may not the shortest
                if (idx == lenT)
                    break;
            }

            if (!targetFound)
                return new int[0];
        }

        Collections.reverse(ans);
        return ans.stream().mapToInt(i -> i).toArray();
    }

    /**
     * to check whether, starting at the given index, `target` can be replaced by
     * `stamp`
     * <p>
     * `PLACE_HOLDER` can match any ONE character
     * <p>
     * Time Complexity: O(`lenS`)
     * Space Complexity: O(1)
     *
     * @param start the starting index
     * @param chsT  the target char array
     * @param chsS  the stamp char array
     * @return true if it can be replaced
     */
    private boolean canReplace(final int start, final char[] chsT, final char[] chsS) {
        final int lenS = chsS.length;
        for (int i = 0; i < lenS; ++i) {
            if (chsT[start + i] != PLACE_HOLDER && chsT[start + i] != chsS[i])
                return false;
        }

        return true;
    }

    /**
     * to replace characters, starting at the given index,
     * <p>
     * Time Complexity: O(`lenS`)
     * Space Complexity: O(1)
     *
     * @param start the starting index
     * @param chsT  the target char array
     * @param lenS  the length of `stamp`
     * @return number of new placeholders
     */
    private int replace(final int start, final char[] chsT, final int lenS) {
        int count = 0;

        for (int i = 0; i < lenS; ++i) {
            if (chsT[start + i] == PLACE_HOLDER)
                continue;
            chsT[start + i] = PLACE_HOLDER;
            ++count;
        }

        return count;
    }
}