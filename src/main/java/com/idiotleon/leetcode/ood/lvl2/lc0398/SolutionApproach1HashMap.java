/**
 * https://leetcode.com/problems/random-pick-index/
 */
package com.idiotleon.leetcode.ood.lvl2.lc0398;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SolutionApproach1HashMap {
    private Map<Integer, List<Integer>> map;

    public SolutionApproach1HashMap(int[] nums) {
        map = new HashMap<Integer, List<Integer>>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<Integer>());
            }

            map.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        int index = new Random().nextInt(map.get(target).size());
        return map.get(target).get(index);
    }
}