package com.zea7ot.summaries.sort.heap_sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallest {
    /**
     * Time Complexity: O(max(NR, k) * lg(NC))
     * Space Complexity: O(NR)
     * 
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallestWithMinHeap(int[][] matrix, int k){
        // min heap
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b){   // a, b are positions/coordinates
                return Integer.compare(matrix[a[0]][a[1]], matrix[b[0]][b[1]]);
            }
        });

        final int NR = matrix.length, NC = matrix[0].length;

        // to add the 1st column
        for(int row = 0; row < NR; row++){
            minHeap.offer(new int[]{row, 0});
        }

        // to pop out/push in one by one, column by column
        while(--k > 0){
            int[] p = minHeap.poll();

            if(++p[1] < NC){
                minHeap.offer(p);
            }
        }

        return matrix[minHeap.peek()[0]][minHeap.peek()[1]];
    }


    /**
     * Time Complexity: O(NR * NC * log(K))
     * Space Complexity: O(k)
     * 
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallestWithMaxHeap(int[][] matrix, int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int[] row : matrix){
            for(int num : row){
                maxHeap.offer(num);

                if(maxHeap.size() > k){
                    maxHeap.poll();
                }
            }
        }

        return maxHeap.peek();
    }
}
