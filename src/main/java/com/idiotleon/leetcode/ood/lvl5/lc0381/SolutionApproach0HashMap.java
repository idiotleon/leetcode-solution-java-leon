/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 * 
 * Time Complexities:   O(1)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/discuss/85541/C++-128m-Solution-Real-O(1)-Solution/245235
 */
package com.idiotleon.leetcode.ood.lvl5.lc0381;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class SolutionApproach0HashMap {
    private Map<Integer, Set<Integer>> map;
    private List<Integer> nums;
    private Random rand;

    /** Initialize your data structure here. */
    public SolutionApproach0HashMap() {
        this.map = new HashMap<>();
        this.nums = new ArrayList<>();
        this.rand = new Random();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not
     * already contain the specified element.
     */
    public boolean insert(int val) {
        nums.add(val);
        final int N = nums.size();
        if (map.containsKey(val)) {
            map.get(val).add(N - 1);
            return false;
        } else {
            map.putIfAbsent(val, new HashSet<Integer>());
            map.get(val).add(N - 1);
            return true;
        }
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained
     * the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;

        // if the removing number is not at the last index of the arraylist,
        // to swap the last number with the removing number
        if (!map.get(val).contains(nums.size() - 1)) {
            int curPosIdx = map.get(val).iterator().next();
            int lastPosVal = nums.get(nums.size() - 1);

            // to reset the index of the last number
            map.get(lastPosVal).remove(nums.size() - 1);
            map.get(lastPosVal).add(curPosIdx);

            // to reset the index of removing number
            map.get(val).remove(curPosIdx);
            map.get(val).add(nums.size() - 1);

            // to move the last element to the current removing index
            nums.set(curPosIdx, lastPosVal);
        }

        // after swapping, to remove the last number from both the map and arraylist
        map.get(val).remove(nums.size() - 1);
        if (map.get(val).isEmpty())
            map.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}