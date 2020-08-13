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

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0Backtrack1 {
    private Deque<String> permutations;

    public SolutionApproach0Backtrack1(String characters, int combinationLength) {
        this.permutations = new ArrayDeque<String>();
        permute(0, combinationLength, new StringBuilder(), characters.toCharArray());
    }

    public String next() {
        return permutations.poll();
    }

    public boolean hasNext() {
        return !permutations.isEmpty();
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