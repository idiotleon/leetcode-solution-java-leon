/**
 * https://leetcode.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/discuss/609718/Java-Simple-Solution-Greedy-BFS/525776
 */
package com.idiotleon.leetcode.lvl4.lc1439;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class SolutionApproach0BFS {
    public int kthSmallest(int[][] mat, int k) {
        final int NR = mat.length, NC = mat[0].length;
        Queue<Item> minHeap = new PriorityQueue<Item>((a, b) -> Integer.compare(a.sum, b.sum));
        int sum = 0;
        for(int[] row : mat){
            sum += row[0];
        }
        
        Set<Integer> hash = new HashSet<Integer>();
        minHeap.offer(new Item(new int[NR], sum));
        for(int i = 0; i < k - 1; i++){
            Item cur = minHeap.poll();
            for(int j = 0; j < NR; j++){
                int[] next = cur.cols.clone();
                next[j]++;
                if(next[j] < NC && hash.add(Arrays.hashCode(next))){
                    minHeap.add(new Item(next, cur.sum - mat[j][next[j] - 1] + mat[j][next[j]]));
                }
            }
        }
        
        return minHeap.poll().sum;
    }

    private class Item{
        protected int[] cols;
        protected int sum;
        
        protected Item(int[] cols, int sum){
            this.cols = cols;
            this.sum = sum;
        }
    }
}