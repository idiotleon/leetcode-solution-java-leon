/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 * 
 * Time Complexity: 
 *  insert: O(1)
 *  remove: O(1)
 *  random: O(1)
 * 
 * Space Complexity:    O(N)
 *  N, (inserted - removed) elements
 */
package com.zea7ot.lc.ood.lvl3.lc0380;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SolutionApproach0ListTailReplacement {
    private List<Integer> list;
    private Map<Integer, Integer> idxMap;
    private Random rand;

    /** Initialize your data structure here. */
    public SolutionApproach0ListTailReplacement() {
        this.list = new ArrayList<Integer>();
        this.idxMap = new HashMap<Integer, Integer>();
        this.rand = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain
     * the specified element.
     */
    public boolean insert(int val) {
        if (idxMap.containsKey(val))
            return false;

        final int SIZE = list.size();
        idxMap.put(val, SIZE);
        list.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified
     * element.
     */
    public boolean remove(int val) {
        if (!idxMap.containsKey(val))
            return false;

        final int SIZE = list.size(), TAIL = list.get(SIZE - 1);
        final int IDX = idxMap.get(val);
        list.set(IDX, TAIL);
        idxMap.put(TAIL, IDX);
        idxMap.remove(val);
        list.remove(SIZE - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}