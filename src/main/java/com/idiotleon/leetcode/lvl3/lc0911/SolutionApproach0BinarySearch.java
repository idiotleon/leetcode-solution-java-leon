/**
 * https://leetcode.com/problems/online-election/
 * 
 * References:
 *  https://leetcode.com/problems/online-election/discuss/173382/C%2B%2BJavaPython-Binary-Search-in-Times
 */
package com.idiotleon.leetcode.lvl3.lc0911;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0BinarySearch {
    private Map<Integer, Integer> map;
    private int[] times;

    public SolutionApproach0BinarySearch(int[] persons, int[] times) {
        this.map = new HashMap<Integer, Integer>();
        final int N = persons.length;
        int lead = -1;
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        
        this.times = times;
        for(int i = 0; i < N; i++){
            count.put(persons[i], count.getOrDefault(persons[i], 0) + 1);
            if(i == 0 || count.get(persons[i]) >= count.get(lead)) lead = persons[i];
            map.put(times[i], lead);
        }
    }
    
    public int q(int t) {
        int idx = Arrays.binarySearch(times, t);
        //int idx = binarySearch(times, t);
        return idx < 0 ? map.get(times[-idx - 2]) : map.get(times[idx]);
    }
}