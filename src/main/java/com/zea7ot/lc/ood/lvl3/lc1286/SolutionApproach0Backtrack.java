/**
 * https://leetcode.com/problems/iterator-for-combination/
 * 
 * Time Complexities:     
 *  construction:   O((L - `combinationLength`)!)
 *      L, the length of `characters`
 *  `next()`:       O(1)
 *  `hashNext()`:   O(1)
 * 
 * Space Complexity:    O((L - `combinationLength`)!)
 *      L, the length of `characters`
 * 
 * References:
 *  https://leetcode.com/problems/iterator-for-combination/discuss/789455/Java-Algorithm-Explained-or-queue-Generate-all-Combinations-of-CombinationLength
 */
package com.zea7ot.lc.ood.lvl3.lc1286;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack {
    private List<String> permutations;
    private int idx;

    public SolutionApproach0Backtrack(String characters, int combinationLength) {
        this.permutations = new ArrayList<String>();
        this.idx = 0;

        permute(0, combinationLength, new StringBuilder(), characters.toCharArray());
    }

    public String next() {
        return permutations.get(idx++);
    }

    public boolean hasNext() {
        return idx < permutations.size();
    }

    private void permute(int startIdx, int len, StringBuilder builder, final char[] CHS) {
        final int L = CHS.length;

        if (len == 0) {
            permutations.add(builder.toString());
            return;
        }

        // to further backtrack
        for (int i = startIdx; i < L; ++i) {
            builder.append(CHS[i]);
            permute(i + 1, len - 1, builder, CHS);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}