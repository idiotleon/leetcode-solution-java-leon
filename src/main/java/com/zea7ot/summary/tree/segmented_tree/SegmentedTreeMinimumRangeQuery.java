/**
 * 
 * References:
 *  https://www.youtube.com/watch?v=ZBHKZF5w4YU
 *  https://www.youtube.com/watch?v=xuoQdt5pHj0
 *  https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/SegmentTreeMinimumRangeQuery.java
 */
package com.zea7ot.summary.tree.segmented_tree;

import com.zea7ot.summary.bit_manipulation.NextPowerOf2;

public class SegmentedTreeMinimumRangeQuery {
    /**
     * to create a segment tree
     * 
     * @param input
     * @return
     */
    public int[] createSegmentTree(int[] input) {
        NextPowerOf2 np2 = new NextPowerOf2();
        int nextPowerOf2 = np2.nextPowerOf2(input.length);
        int[] segmentTree = new int[nextPowerOf2 * 2 - 1];

        for (int i = 0; i < segmentTree.length; i++) {
            segmentTree[i] = Integer.MAX_VALUE;
        }
        constructSegementTree(input, segmentTree, 0, input.length - 1, 0);
        return segmentTree;
    }

    /**
     * to construct the segmented tree
     * 
     * Time Complexity: O(N) O(4 * N), in the worst case
     * 
     * Space Complexity: O(N)
     */
    public void constructSegementTree(int[] input, int[] segmentedTree, int low, int high, int idx) {
        if (low == high) {
            segmentedTree[idx] = input[low];
            return;
        }

        int mid = low + (high - low) / 2;
        constructSegementTree(input, segmentedTree, low, mid, 2 * idx + 1);
        constructSegementTree(input, segmentedTree, mid, high, 2 * idx + 2);
        segmentedTree[idx] = Math.min(segmentedTree[2 * idx + 1], segmentedTree[2 * idx + 2]);
    }

    /**
     * to update the segment tree, at certain index, with the given "delta"
     * 
     * @param input
     * @param segmentTree
     * @param idx
     * @param delta
     */
    public void updateSegmentTree(int[] input, int[] segmentTree, int idx, int delta) {
        input[idx] += delta;
        updateSegmentTree(segmentTree, idx, delta, 0, input.length - 1, 0);
    }

    /**
     * to update the segment tree, for the given range, with the given "delta"
     * 
     * @param input
     * @param segmentTree
     * @param startRange
     * @param endRange
     * @param delta
     */
    public void updateSegmentTreeRange(int[] input, int[] segmentTree, int startRange, int endRange, int delta) {
        for (int i = startRange; i <= endRange; i++) {
            input[i] += delta;
        }

        updateSegmentTreeRange(segmentTree, startRange, endRange, delta, 0, input.length - 1, 0);
    }

    /**
     * to query, in the given range, for the minimum value
     * 
     * @param segmentTree
     * @param queryLow
     * @param queryHigh
     * @param len
     * @return
     */
    public int rangeMinimumQuery(int[] segmentTree, int queryLow, int queryHigh, int len) {
        return rangeMinimumQuery(segmentTree, 0, len - 1, queryLow, queryHigh, 0);
    }

    /**
     * to update the given range with the given delta lazily
     * 
     * @param input
     * @param segmentTree
     * @param lazy
     * @param startRange
     * @param endRange
     * @param delta
     */
    public void updateSegmentTreeRangeLazily(int[] input, int[] segmentTree, int[] lazy, int startRange, int endRange,
            int delta) {
        updateSegmentTreeRangeLazily(segmentTree, lazy, startRange, endRange, delta, 0, input.length, 0);
    }

    /**
     * 
     * @param segmentTree
     * @param lazy
     * @param queryLow
     * @param queryHigh
     * @param len
     */
    public void rangeMinimumQueryLazily(int[] segmentTree, int[] lazy, int queryLow, int queryHigh, int len) {
        rangeMinimumQueryLazily(segmentTree, lazy, queryLow, queryHigh, 0, len - 1, 0);
    }

    /**
     * to query the minimum value in the given range
     * 
     * Time Complexity: O(lg(N)) O(4 * lg(N)), in the worst case
     * 
     * Space Complexity: O(1)
     * 
     * @param segmentedTree
     * @param queryLow
     * @param queryHigh
     * @param low
     * @param high
     * @param idx
     * @return
     */
    private int rangeMinimumQuery(int[] segmentedTree, int queryLow, int queryHigh, int low, int high, int idx) {
        // total overlap
        if (queryLow <= low && queryHigh >= high)
            return segmentedTree[idx];

        // no overlap
        if (queryLow > high || queryHigh < low)
            return Integer.MAX_VALUE;

        // partial overlap
        int mid = low + (high - low) / 2;
        return Math.min(rangeMinimumQuery(segmentedTree, queryLow, queryHigh, low, mid, 2 * idx + 1),
                rangeMinimumQuery(segmentedTree, queryLow, queryHigh, mid + 1, high, 2 * idx + 2));
    }

    /**
     * 
     * @param segmentTree
     * @param idx
     * @param delta
     * @param low
     * @param high
     * @param pos
     */
    private void updateSegmentTree(int[] segmentTree, int idx, int delta, int low, int high, int pos) {
        if (idx < low || idx > high)
            return;

        if (low == high) {
            segmentTree[idx] += delta;
            return;
        }

        int mid = low + (high - low) / 2;
        updateSegmentTree(segmentTree, idx, delta, low, mid, 2 * pos + 1);
        updateSegmentTree(segmentTree, idx, delta, mid + 1, high, 2 * pos + 2);
        segmentTree[idx] = Math.min(segmentTree[2 * pos + 1], segmentTree[2 * pos + 2]);
    }

    /**
     * 
     * @param segmentTree
     * @param startRange
     * @param endRange
     * @param delta
     * @param low
     * @param high
     * @param idx
     */
    private void updateSegmentTreeRange(int[] segmentTree, int startRange, int endRange, int delta, int low, int high,
            int idx) {
        if (low > high || startRange > high || endRange < low)
            return;

        if (low == high) {
            segmentTree[idx] += delta;
            return;
        }

        int mid = low + (high - low) / 2;
        updateSegmentTreeRange(segmentTree, startRange, endRange, delta, low, mid, 2 * idx + 1);
        updateSegmentTreeRange(segmentTree, startRange, endRange, delta, mid + 1, high, 2 * idx + 2);
        segmentTree[idx] = Math.min(segmentTree[2 * idx + 1], segmentTree[2 * idx + 2]);
    }

    /**
     * 
     * @param segmentTree
     * @param lazy
     * @param startRange
     * @param endRange
     * @param delta
     * @param low
     * @param high
     * @param idx
     */
    private void updateSegmentTreeRangeLazily(int[] segmentTree, int[] lazy, int startRange, int endRange, int delta,
            int low, int high, int idx) {
        if (low > high)
            return;

        // to make sure all propagation is done at "idx".
        // if not, to update the segment tree at "idx",
        // and mark its children for lazy propagation.
        if (lazy[idx] != 0) {
            segmentTree[idx] += lazy[idx];
            if (low != high) { // not a leaf node
                lazy[2 * idx + 1] += lazy[idx];
                lazy[2 * idx + 2] += lazy[idx];
            }
            lazy[idx] = 0;
        }

        // no overlap
        if (startRange > high || endRange < low)
            return;

        // complete overlap
        if (startRange <= low && endRange >= high) {
            segmentTree[idx] += delta;
            if (low != high) {
                lazy[2 * idx + 1] += delta;
                lazy[2 * idx + 2] += delta;
            }
            return;
        }

        // partial overlap
        int mid = low + (high - low) / 2;
        updateSegmentTreeRangeLazily(segmentTree, lazy, startRange, endRange, delta, low, mid, 2 * idx + 1);
        updateSegmentTreeRangeLazily(segmentTree, lazy, startRange, endRange, delta, mid + 1, high, 2 * idx + 2);
        segmentTree[idx] = Math.min(segmentTree[2 * idx + 1], segmentTree[2 * idx + 2]);
    }

    /**
     * 
     * @param segmentTree
     * @param lazy
     * @param queryLow
     * @param queryHigh
     * @param low
     * @param high
     * @param idx
     * @return
     */
    private int rangeMinimumQueryLazily(int[] segmentTree, int[] lazy, int queryLow, int queryHigh, int low, int high,
            int idx) {
        if (low > high)
            return Integer.MAX_VALUE;

        // to make sure all propagation is done at "idx".
        // if not, to update the segment tree at "idx",
        // and mark its children for propagation.
        if (lazy[idx] != 0) {
            segmentTree[idx] += lazy[idx];
            if (low != high) {
                lazy[2 * idx + 1] += lazy[idx];
                lazy[2 * idx + 2] += lazy[idx];
            }
            lazy[idx] = 0;
        }

        // no overlap
        if (queryLow > high || queryHigh < low)
            return Integer.MAX_VALUE;

        // complete overlap
        if (queryLow <= low && queryHigh >= high)
            return segmentTree[idx];

        // partial overlap
        int mid = low + (high - low) / 2;
        return Math.min(rangeMinimumQueryLazily(segmentTree, lazy, queryLow, queryHigh, low, mid, 2 * idx + 1),
                rangeMinimumQueryLazily(segmentTree, lazy, queryLow, queryHigh, mid + 1, high, 2 * idx + 2));
    }
}