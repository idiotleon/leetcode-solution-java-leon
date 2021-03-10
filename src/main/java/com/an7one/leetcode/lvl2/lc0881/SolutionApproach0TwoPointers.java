/**
 * https://leetcode.com/problems/boats-to-save-people/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/boats-to-save-people/discuss/156740/C++JavaPython-Two-Pointers/527233
 *  https://leetcode.com/problems/boats-to-save-people/discuss/156740/C%2B%2BJavaPython-Two-Pointers
 */
package com.an7one.leetcode.lvl2.lc0881;

import java.util.Arrays;

public class SolutionApproach0TwoPointers {
    public int numRescueBoats(int[] people, int limit) {
        // sanity check
        if (people == null || people.length == 0 || limit <= 0)
            return 0;

        final int N = people.length;
        Arrays.sort(people);
        int lo = 0, hi = N - 1;
        int count = 0;
        while (lo <= hi) {
            count++;
            if (people[lo] + people[hi] <= limit)
                lo++;
            hi--;
        }

        return count;
    }
}