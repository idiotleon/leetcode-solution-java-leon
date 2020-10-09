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
package com.zea7ot.leetcode.lvl3.lc0846;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.TreeMap;

public class SolutionApproach0TreeMapWithDeque {
    public boolean isNStraightHand(int[] cards, int W) {
        Map<Integer, Integer> freqs = new TreeMap<>();
        for (int card : cards) {
            freqs.put(card, freqs.getOrDefault(card, 0) + 1);
        }

        // to keep track of groups that are open
        Deque<Integer> deque = new ArrayDeque<>();

        int prevCard = -1;
        int open = 0;

        for (Map.Entry<Integer, Integer> entry : freqs.entrySet()) {
            int card = entry.getKey();
            int freq = entry.getValue();

            if (open > 0 && card > prevCard + 1 || open > freq)
                return false;
            deque.addLast(freq - open);
            prevCard = card;
            open = freq;
            if (deque.size() == W) {
                open -= deque.removeFirst();
            }
        }

        return open == 0;
    }
}
