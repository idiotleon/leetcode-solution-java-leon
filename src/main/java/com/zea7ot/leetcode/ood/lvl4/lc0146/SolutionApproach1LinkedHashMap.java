/**
 * https://leetcode.com/problems/lru-cache/
 */
package com.zea7ot.leetcode.ood.lvl4.lc0146;

import java.util.LinkedHashMap;
import java.util.Map;

public class SolutionApproach1LinkedHashMap extends LinkedHashMap<Integer, Integer> {

    // just to remove warning about lack of serialVersionUID
    private static final long serialVersionUID = 1L;

    private int capacity;

    public SolutionApproach1LinkedHashMap(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}