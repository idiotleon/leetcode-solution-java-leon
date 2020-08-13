/**
 * https://leetcode.com/problems/iterator-for-combination/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/iterator-for-combination/discuss/789180/Java-or-2-different-solution-or-With-detailed-explanation
 */
package com.zea7ot.lc.ood.lvl3.lc1286.bit_masking;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack {
    private List<Integer> bitPermuations;
    private int idx;
    private final char[] CHS;

    public SolutionApproach0Backtrack(String characters, int combinationLength) {
        this.bitPermuations = new ArrayList<Integer>();
        this.idx = 0;
        this.CHS = characters.toCharArray();

        final int L = characters.length();
        for (int i = (1 << L) - 1; i > 0; --i)
            if (countBits(i) == combinationLength)
                bitPermuations.add(i);
    }

    public String next() {
        int num = bitPermuations.get(idx++);
        return retrieveString(num);
    }

    public boolean hasNext() {
        return this.idx < bitPermuations.size();
    }

    private String retrieveString(int num) {
        final int N = CHS.length;

        StringBuilder builder = new StringBuilder();
        int index = N - 1;
        while (num > 0) {
            if ((num & 1) > 0)
                builder.insert(0, CHS[index]);
            num >>= 1;
            --index;
        }

        return builder.toString();
    }

    private int countBits(int num) {
        int count = 0;
        while (num > 0) {
            num &= (num - 1);
            ++count;
        }

        return count;
    }
}