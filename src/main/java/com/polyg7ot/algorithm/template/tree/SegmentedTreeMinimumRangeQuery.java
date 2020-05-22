/**
 * 
 * 
 * References:
 * https://www.youtube.com/watch?v=ZBHKZF5w4YU
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/SegmentTreeMinimumRangeQuery.java
 */
package com.polyg7ot.algorithm.template.tree;

public class SegmentedTreeMinimumRangeQuery {
    /**
     * to create a segmented tree
     * 
     * Time Complexity: O(N)
     *  in the worst case: O(4 * N)
     * Space Complexity: O(N)
     */
    public void constructSegementedTree(int[] input, int[] segmentedTree, int low, int high, int pos){
        if(low == high){
            segmentedTree[pos] = input[low];
            return;
        }

        int mid = low + (high - low) / 2;
        constructSegementedTree(input, segmentedTree, low, mid, 2 * pos + 1);
        constructSegementedTree(input, segmentedTree, mid, high, 2 * pos + 2);
        segmentedTree[pos] = Math.min(segmentedTree[2 * pos + 1], segmentedTree[2 * pos + 2]);
    }

    /**
     * to query the minimum value in the given range
     * 
     * Time Complexity: O(lg(N))
     *  in the worst case: O(4 * lg(N))
     * Space Complexity: O(1)
     */
    public int rangeMinimumQuery(int[] segmentedTree, int queryLow, int queryHigh, int low, int high, int pos){
        // total overlap
        if(queryLow <= low && queryHigh >= high){
            return segmentedTree[pos];
        }

        // no overlap
        if(queryLow > high || queryHigh < low){
            return Integer.MAX_VALUE;
        }

        int mid = low + (high - low) / 2;
        return Math.min(rangeMinimumQuery(segmentedTree, queryLow, queryHigh, low, mid, 2 * pos + 1), 
                        rangeMinimumQuery(segmentedTree, queryLow, queryHigh, mid + 1, high, 2 * pos + 2));
    }
}