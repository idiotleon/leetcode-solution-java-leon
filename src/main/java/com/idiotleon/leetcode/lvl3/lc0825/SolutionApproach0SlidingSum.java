/**
 * https://leetcode.com/problems/friends-of-appropriate-ages/
 * 
 * Time Complexity:     O(N) + O((120 - 15) ^ 2) ~ O(N)
 * Space Complexity:    O(121) ~ O(1)
 * 
 * References:
 *  https://leetcode.com/problems/friends-of-appropriate-ages/discuss/126930/C%2B%2B-5-lines-O(n)-sliding-sum
 */
package com.idiotleon.leetcode.lvl3.lc0825;

public class SolutionApproach0SlidingSum {
    public int numFriendRequests(int[] ages) {
        int[] distributions = new int[121];
        int ans = 0;

        for (int age : ages)
            ++distributions[age];

        // condition 2: age[B] > 100 && age[A] < 100
        for (int ageA = 15; ageA <= 120; ++ageA)
            // condition 0: age[B] <= 0.5 * age[A] + 7
            // condition 1: age[B] > age[A]
            for (int ageB = ageA / 2 + 8; ageB <= ageA; ++ageB)
                ans += distributions[ageB] * (distributions[ageA] - ((ageA == ageB) ? 1 : 0));

        return ans;
    }
}