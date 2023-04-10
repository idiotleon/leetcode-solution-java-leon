/**
 * https://leetcode.com/problems/find-right-interval/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/find-right-interval/discuss/91793/Java-Concise-Binary-Search/96331
 *  https://leetcode.com/problems/find-right-interval/discuss/91793/Java-Concise-Binary-Search
 */
package com.idiotleon.leetcode.lvl3.lc0436;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0BinarySearch {
    public int[] findRightInterval(int[][] intervals) {
        // sanity check
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0)
            return new int[0];

        final int N = intervals.length;
        int[] ans = new int[N];

        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < N; ++i){
            idxMap.put(intervals[i][0], i);
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < N; ++i) {
            ans[idxMap.get(intervals[i][0])] = -1;

            int lo = i + 1, hi = N - 1;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (intervals[mid][0] < intervals[i][1])
                    lo = mid + 1;
                else
                    hi = mid;
            }

            if (lo < N && intervals[lo][0] >= intervals[i][1])
                ans[idxMap.get(intervals[i][0])] = idxMap.get(intervals[lo][0]);
        }

        return ans;
    }
}