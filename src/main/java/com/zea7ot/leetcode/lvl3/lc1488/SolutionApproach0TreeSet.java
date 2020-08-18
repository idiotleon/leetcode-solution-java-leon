/**
 * https://leetcode.com/problems/avoid-flood-in-the-city/
 * 
 * Time Complexity:     O(N * lg(N))
 * 
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/avoid-flood-in-the-city/discuss/697701/Java-nlog(n)-find-zero-that-can-be-used-to-empty-the-fullfilled-lake
 */
package com.zea7ot.leetcode.lvl3.lc1488;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class SolutionApproach0TreeSet {
    public int[] avoidFlood(int[] rains) {
        // sanity check
        if(rains == null || rains.length == 0) return new int[0];
        
        final int N = rains.length;
        Map<Integer, Integer> lastOccurence = new HashMap<Integer, Integer>();
        TreeSet<Integer> zeros = new TreeSet<Integer>();
        int[] ans = new int[N];
        for(int i = 0; i < N; i++){
            if(rains[i] == 0){
                zeros.add(i);
            }else{
                ans[i] = -1;
                if(lastOccurence.containsKey(rains[i])){
                    Integer next = zeros.ceiling(lastOccurence.get(rains[i]));
                    if(next == null) return new int[0];
                    ans[next] = rains[i];
                    zeros.remove(next);
                }
                
                lastOccurence.put(rains[i], i);
            }
        }
        
        for(int idx : zeros) ans[idx] = 1;
        
        return ans;
    }
}