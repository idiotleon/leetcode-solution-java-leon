/**
 * https://leetcode.com/problems/single-number-ii/
 */
package main.java.lcidiot.lc.lvl3.lc0137;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproachHashMap {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for(int key : map.keySet()){
            if(map.get(key) == 1){
                return key;
            }
        }
        
        return -1;
    }
}