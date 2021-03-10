/**
 * https://leetcode.com/problems/hand-of-straights/
 * 
 * Time Complexity:     O(DISTINCT * lg(DISTINCT)) + O(DISTINCT * W)
 *   DISTINCT, the distinct cards/elements in `cards`
 * 
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/hand-of-straights/discuss/135598/C%2B%2BJavaPython-O(MlogM)-Complexity
 */
package com.an7one.leetcode.lvl3.lc0846;

import java.util.Map;
import java.util.TreeMap;

public class SolutionApproach0TreeMap {
    public boolean isNStraightHand(int[] cards, int W) {
        Map<Integer, Integer> freqs = new TreeMap<>();
        for (int card : cards) {
            freqs.put(card, freqs.getOrDefault(card, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freqs.entrySet()) {
            int freq = entry.getValue();
            if (freq == 0)
                continue;

            int card = entry.getKey();
            for (int i = W - 1; i >= 0; --i) {
                int expectedCard = card + i;
                if (freqs.getOrDefault(expectedCard, 0) < freq)
                    return false;
                freqs.put(expectedCard, freqs.get(expectedCard) - freq);
            }
        }

        return true;
    }
}
