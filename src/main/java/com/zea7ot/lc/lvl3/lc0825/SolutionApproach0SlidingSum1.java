/**
 * https://leetcode.com/problems/friends-of-appropriate-ages/
 * 
 * Time Complexity:     O(DISTINCT(ages) ^ 2)
 * Space Compelxity:    O(DISTINCT(ages))
 * 
 * References:
 *  https://leetcode.com/problems/friends-of-appropriate-ages/discuss/127029/C%2B%2BJavaPython-Easy-and-Straight-Forward
 */
package com.zea7ot.lc.lvl3.lc0825;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0SlidingSum1 {
    public int numFriendRequests(int[] ages) {
        Map<Integer, Integer> distributions = new HashMap<>();
        for (int age : ages)
            distributions.put(age, distributions.getOrDefault(age, 0) + 1);

        int ans = 0;
        for (Map.Entry<Integer, Integer> entryA : distributions.entrySet()) {
            for (Map.Entry<Integer, Integer> entryB : distributions.entrySet()) {
                int ageA = entryA.getKey(), ageB = entryB.getKey();
                int freqA = entryA.getValue(), freqB = entryB.getValue();
                if (request(ageA, ageB))
                    ans += freqA * (freqB - (ageA == ageB ? 1 : 0));
            }
        }

        return ans;
    }

    private boolean request(int a, int b) {
        return !(b <= 0.5 * a + 7 || b > a || (b > 100 && a < 100));
    }
}