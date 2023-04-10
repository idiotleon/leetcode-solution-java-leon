/**
 * https://leetcode.com/problems/hand-of-straights/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/hand-of-straights/discuss/136200/Simple-Java-solution-using-priority-queue
 */
package com.idiotleon.leetcode.lvl3.lc0846;

import java.util.PriorityQueue;

public class SolutionApproach1MinHeap {
    public boolean isNStraightHand(int[] cards, int W) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int card : cards) {
            minHeap.offer(card);
        }

        while (!minHeap.isEmpty()) {
            int smallest = minHeap.peek();
            for (int i = 0; i < W; ++i) {
                int expectedCard = smallest + i;
                if (!minHeap.contains(expectedCard))
                    return false;
                else
                    minHeap.remove(expectedCard);
            }
        }

        return true;
    }
}
