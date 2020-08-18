/**
 * https://leetcode.com/problems/iterator-for-combination/
 * 
 * Time Complexities:     
 *  construction:   O(L! / ((L - `combinationLength`)! * k!))
 *      L, the length of `characters`
 *  `next()`:       O(1)
 *  `hashNext()`:   O(1)
 * 
 * Space Complexity:     O(L! / ((L - `combinationLength`)! * k!))
 *      L, the length of `characters`
 * 
 * 
 * References:
 *  https://leetcode.com/problems/iterator-for-combination/discuss/789455/Java-Algorithm-Explained-or-queue-Generate-all-Combinations-of-CombinationLength
 */
package com.zea7ot.leetcode.ood.lvl3.lc1286;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0Backtrack1 {
    private Deque<String> combinations;

    public SolutionApproach0Backtrack1(String characters, int combinationLength) {
        this.combinations = new ArrayDeque<String>();
        computeCombinations(0, combinationLength, new StringBuilder(), characters.toCharArray());
    }

    public String next() {
        return combinations.poll();
    }

    public boolean hasNext() {
        return !combinations.isEmpty();
    }

    private void computeCombinations(int startIdx, int len, StringBuilder builder, final char[] CHS) {
        final int L = CHS.length;

        if (len == 0) {
            combinations.add(builder.toString());
            return;
        }

        for (int i = startIdx; i < L; ++i) {
            builder.append(CHS[i]);
            computeCombinations(i + 1, len - 1, builder, CHS);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}