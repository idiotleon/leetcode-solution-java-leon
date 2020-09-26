/**
 * https://leetcode.com/problems/campus-bikes-ii/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/campus-bikes-ii/discuss/303422/Python-Priority-Queue/285136
 *  https://leetcode.com/problems/campus-bikes-ii/discuss/303422/Python-Priority-Queue
 */
package com.zea7ot.leetcode.lvl4.lc1066;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SolutionApproach0DjikstrasSPF {
    public int assignBikes(int[][] workers, int[][] bikes) {

        final int N_W = workers.length, N_B = bikes.length;

        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.distance, b.distance));
        minHeap.offer(new Node(0, 0, 0));

        final Set<String> SEEN = new HashSet<>();

        while (!minHeap.isEmpty()) {
            Node cur = minHeap.poll();
            int idxWorker = cur.idxWorker;
            int state = cur.state;
            int distance = cur.distance;

            String hash = String.valueOf(idxWorker) + "$" + state;
            if (!SEEN.add(hash))
                continue;

            if (idxWorker == N_W)
                return distance;

            for (int idxBike = 0; idxBike < N_B; ++idxBike) {
                if ((state & (1 << idxBike)) == 0) {
                    minHeap.offer(new Node(idxWorker + 1, state | (1 << idxBike),
                            distance + getDistance(workers[idxWorker], bikes[idxBike])));
                }
            }
        }

        return -1;
    }

    private int getDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }

    private class Node {
        private int idxWorker;
        private int state;
        private int distance;

        private Node(int idxWorker, int state, int distance) {
            this.idxWorker = idxWorker;
            this.state = state;
            this.distance = distance;
        }
    }
}
