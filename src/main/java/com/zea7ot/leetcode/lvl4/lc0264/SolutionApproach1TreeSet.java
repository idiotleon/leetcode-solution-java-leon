/**
 * https://leetcode.com/problems/ugly-number-ii/
 * 
 * Time Complexity:     O(3 * n * lg(n)) ~ O(n * lg(n))
 * Space Complexity:    O(3 * n) ~ O(n)
 * 
 * References:
 *  https://leetcode.com/problems/ugly-number-ii/discuss/69372/Java-solution-using-PriorityQueue/71424
 */
package com.zea7ot.leetcode.lvl4.lc0264;

import java.util.TreeSet;

public class SolutionApproach1TreeSet {
    public int nthUglyNumber(int n) {
        TreeSet<Long> ans = new TreeSet<Long>(); 
        ans.add(1L);
        for(int i = 0; i < n - 1; i++){
            long first = ans.pollFirst();
            ans.add(first * 2);
            ans.add(first * 3);
            ans.add(first * 5);
        }
        
        return ans.first().intValue();
    }
}