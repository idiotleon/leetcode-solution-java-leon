/**
 * https://leetcode.com/problems/two-sum-iii-data-structure-design/
 * 
 * Time Complexities:
 *  `add()`:    O(1)
 *  `find()`:   O(N)
 * 
 * Space Complexity:    O(N)
 */
package com.zea7ot.leetcode.ood.lvl2.lc0170;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0HashMap {
    private Map<Integer, Integer> freq;

    /** Initialize your data structure here. */
    public SolutionApproach0HashMap() {
        this.freq = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int num) {
        freq.put(num, freq.getOrDefault(num, 0) + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num1 = entry.getKey();
            int num2 = value - num1;
            if ((num1 == num2 && freq.get(num1) > 1) || (num1 != num2 && freq.containsKey(num2)))
                return true;
        }

        return false;
    }
}
