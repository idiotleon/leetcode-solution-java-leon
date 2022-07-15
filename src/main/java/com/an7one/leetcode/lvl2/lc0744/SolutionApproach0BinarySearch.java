package com.an7one.leetcode.lvl2.lc0744;

import com.an7one.util.Constant;

/**
 * <a href="https://leetcode.com/problems/find-smallest-letter-greater-than-target/">LC0744</a>
 * <p>
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/find-smallest-letter-greater-than-target/discuss/110005/Easy-Binary-Search-in-Java-O(log(n))-time">LC Discussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BinarySearch {
    public char nextGreatestLetter(char[] letters, char target) {
        // sanity check
        if (letters == null || letters.length == 0) return 0;

        final int N = letters.length;

        int lo = 0, hi = N - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (letters[mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }

        return letters[lo % N];
    }
}