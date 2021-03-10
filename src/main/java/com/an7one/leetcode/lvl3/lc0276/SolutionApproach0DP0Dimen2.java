/**
 * https://leetcode.com/problems/paint-fence/
 * 
 * Time Complexity:     O(n)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/paint-fence/discuss/71156/O(n)-time-java-solution-O(1)-space/73298
 *  https://youtu.be/FLbqgyJ-70I?t=1430
 *  https://docs.google.com/presentation/d/1OeA0rsnOrklarLM5G2tHHJ6EE37HpRqD7KedzOqkihk/edit#slide=id.g8285dd8f3f_1_331
 */
package com.an7one.leetcode.lvl3.lc0276;

public class SolutionApproach0DP0Dimen2 {
    public int numWays(int n, int k) {
        int first = k;
        int second = k * k;
        if (n == 0)
            return 0;
        if (n == 1)
            return first;
        if (n == 2)
            return second;

        int ans = 0;
        for (int i = 2; i < n; i++) {
            ans = (first + second) * (k - 1);
            first = second;
            second = ans;
        }

        return ans;
    }
}