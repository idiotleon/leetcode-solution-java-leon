package com.idiotleon.leetcode.ood.lvl3.lc0170;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0HashMap {
    private Map<Integer, Integer> freqs;

    /** Initialize your data structure here. */
    public SolutionApproach0HashMap() {
        this.freqs = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int num) {
        freqs.put(num, freqs.getOrDefault(num, 0) + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : freqs.entrySet()) {
            int num1 = entry.getKey();
            int num2 = value - num1;
            if ((num1 == num2 && freqs.get(num1) > 1) || (num1 != num2 && freqs.containsKey(num2)))
                return true;
        }

        return false;
    }
}
