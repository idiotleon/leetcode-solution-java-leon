/**
 * https://leetcode.com/problems/two-sum-iii-data-structure-design/
 * 
 * Time Complexities:
 *  `add()`:    O(1)
 *  `find()`:   O(N)
 * 
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/two-sum-iii-data-structure-design/discuss/52015/Beats-100-Java-Code
 */
package com.idiotleon.leetcode.ood.lvl2.lc0170;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach0HashMap1 {
    private List<Integer> list;
    private Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public SolutionApproach0HashMap1() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if (map.containsKey(number))
            map.put(number, map.get(number) + 1);
        else {
            map.put(number, 1);
            list.add(number);
        }
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        final int SIZE = list.size();
        for (int i = 0; i < SIZE; ++i) {
            int num1 = list.get(i);
            int num2 = value - num1;
            if ((num1 == num2 && map.get(num1) > 1) || (num1 != num2 && map.containsKey(num2)))
                return true;
        }

        return false;
    }
}