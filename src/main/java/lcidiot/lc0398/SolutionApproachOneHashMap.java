/**
 * https://leetcode.com/problems/random-pick-index/
 */
package main.java.lcidiot.lc0398;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SolutionApproachOneHashMap {
    private Map<Integer, List<Integer>> map;

    public SolutionApproachOneHashMap(int[] nums) {
        map = new HashMap<Integer, List<Integer>>();
        
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
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