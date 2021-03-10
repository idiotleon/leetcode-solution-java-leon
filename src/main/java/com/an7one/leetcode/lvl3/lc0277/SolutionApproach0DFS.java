/**
 * https://leetcode.com/problems/find-the-celebrity/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * Reference:
 *  https://leetcode.com/problems/find-the-celebrity/discuss/71228/JavaPython-O(n)-calls-O(1)-space-easy-to-understand-solution
 */
package com.an7one.leetcode.lvl3.lc0277;

public class SolutionApproach0DFS {
    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 0; i < n; ++i)
            if (FakeAPI.knows(candidate, i))
                candidate = i;

        for (int i = 0; i < candidate; ++i)
            if (FakeAPI.knows(candidate, i))
                return -1;

        for (int i = 0; i < n; ++i)
            if (!FakeAPI.knows(i, candidate))
                return -1;

        return candidate;
    }
}