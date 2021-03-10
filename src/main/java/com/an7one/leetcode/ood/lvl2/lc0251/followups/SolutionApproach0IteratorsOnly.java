/**
 * https://leetcode.com/problems/flatten-2d-vector/
 */
package com.an7one.leetcode.ood.lvl2.lc0251.followups;

import java.util.Arrays;
import java.util.Iterator;

public class SolutionApproach0IteratorsOnly {
    private Iterator<int[]> rowIter;
    private Iterator<Integer> colIter;

    public SolutionApproach0IteratorsOnly(int[][] v) {
        this.rowIter = Arrays.stream(v).iterator();
        if (rowIter.hasNext())
            colIter = Arrays.stream(rowIter.next()).iterator();
    }

    public int next() {
        if (!hasNext())
            return -1;
        return colIter.next();
    }

    public boolean hasNext() {
        // while((col == null || !col.hasNext() && row.hasNext()))
        // col = Arrays.stream(row.next()).iterator();
        // return col != null && col.hasNext();
        if (colIter == null)
            return false;

        while (!colIter.hasNext() && rowIter.hasNext())
            colIter = Arrays.stream(rowIter.next()).iterator();

        return colIter.hasNext();
    }
}