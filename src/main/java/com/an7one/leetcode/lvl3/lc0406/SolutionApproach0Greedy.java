/**
 * https://leetcode.com/problems/queue-reconstruction-by-height/
 * 
 * Time Complexity:     O(N * lg(N)) + O(N) ~ O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/queue-reconstruction-by-height/discuss/89345/Easy-concept-with-PythonC%2B%2BJava-Solution
 */
package com.an7one.leetcode.lvl3.lc0406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionApproach0Greedy {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : b[0] - a[0]);

        List<int[]> ans = new ArrayList<int[]>();
        for (int[] cur : people) {
            ans.add(cur[1], cur);
        }
        return ans.toArray(new int[people.length][2]);
    }
}