/**
 * https://leetcode.com/problems/optimal-account-balancing/
 */
package com.zea7ot.leetcode.lvl5.lc0465;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproachDFS {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> personToDebt = new HashMap<Integer, Integer>();
        for(int[] transaction : transactions){
            personToDebt.put(transaction[0], personToDebt.getOrDefault(transaction[0], 0) - transaction[2]);
            personToDebt.put(transaction[1], personToDebt.getOrDefault(transaction[1], 0) + transaction[2]);
        }
        
        return backtrack(new ArrayList<Integer>(personToDebt.values()), 0);
    }
    
    private int backtrack(List<Integer> personToDebt, int start){
        while(start < personToDebt.size() && personToDebt.get(start) == 0){
            start++;
        }
        
        if(start == personToDebt.size()) return 0;
        
        int res = Integer.MAX_VALUE;
        for(int i = start + 1; i < personToDebt.size(); i++){
            if(personToDebt.get(start) * personToDebt.get(i) < 0){
                personToDebt.set(i, personToDebt.get(i) + personToDebt.get(start));
                res = Math.min(res, 1 + backtrack(personToDebt, start + 1));
                personToDebt.set(i, personToDebt.get(i) - personToDebt.get(start));
            }
        }
        
        return res;
    }
}