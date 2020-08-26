/**
 * https://leetcode.com/problems/buddy-strings/
 * 
 * Time Complexity:     O(LEN_A + LEN_B) ~ O(L)
 * Space Complexity:    O(L)
 * 
 * References:
 *  https://leetcode.com/problems/buddy-strings/discuss/141780/Easy-Understood
 */
package com.zea7ot.leetcode.lvl2.lc0859;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionApproach0LinearScan {
    public boolean buddyStrings(String A, String B) {
        if (A == null || B == null || A.length() != B.length())
            return false;

        final int L = A.length();

        if (A.equals(B)) {
            Set<Character> seen = new HashSet<>();
            for (char ch : A.toCharArray())
                seen.add(ch);
            return seen.size() < L;
        }

        List<Integer> diff = new ArrayList<>();
        final char[] CHS_A = A.toCharArray();
        final char[] CHS_B = B.toCharArray();

        for (int i = 0; i < L; ++i) {
            if (CHS_A[i] != CHS_B[i])
                diff.add(i);
        }

        return diff.size() == 2 && CHS_A[diff.get(0)] == CHS_B[diff.get(1)] && CHS_A[diff.get(1)] == CHS_B[diff.get(0)];
    }
}