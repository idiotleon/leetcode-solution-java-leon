/**
 * https://leetcode.com/problems/two-sum-iii-data-structure-design/
 */
package com.null7ptr.lc.lvl3.lc0170;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {    
    private List<Integer> list;
    private Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public Solution() {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(map.containsKey(number))
            map.put(number, map.get(number) + 1);
        else{
            map.put(number, 1);
            list.add(number);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(int i = 0; i < list.size(); i++){
            int num1 = list.get(i), num2 = value - num1;
            if((num1 == num2 && map.get(num1) > 1) || (num1 != num2 && map.containsKey(num2))) 
                return true;
        }
        
        return false;
    }
}