/**
 * https://leetcode.com/problems/repeated-dna-sequences/
 * 
 * 
 * Time complexity : O((LEN_S - LEN) * LEN), that is O(N) for the constant LEN = 10. 
 *  In the loop executed N - L + 1N−L+1 one builds a substring of length L. 
 *  Overall that results in O((N - L)L) time complexity.
 * 
 * Space complexity : O((LEN_S - LEN) * LEN) to keep the hashset, 
 *  that results in O(N) for the constant L = 10.
 * 
 * References:
 *  https://leetcode.com/problems/repeated-dna-sequences/discuss/53855/7-lines-simple-Java-O(n)
 */
package com.idiotleon.leetcode.lvl4.lc0187;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionApproach0TwoSets {
    private static final int LEN = 10;

    public List<String> findRepeatedDnaSequences(String s) {
        final int LEN_S = s.length();
        final Set<String> SEEN = new HashSet<String>();
        final Set<String> OUTPUT = new HashSet<String>();

        // to iterate over all sequences of length L
        for (int idx = 0; idx + LEN - 1 < LEN_S; ++idx) {
            String sub = s.substring(idx, idx + LEN);
            if (SEEN.contains(sub))
                OUTPUT.add(sub);
            SEEN.add(sub);
        }

        return new ArrayList<>(OUTPUT);
    }
}