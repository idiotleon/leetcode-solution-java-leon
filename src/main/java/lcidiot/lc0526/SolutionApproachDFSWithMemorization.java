/**
 * https://leetcode.com/problems/beautiful-arrangement/
 * 
 * #BitMap
 */
package main.java.lcidiot.lc0526;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproachDFSWithMemorization {
    public int countArrangement(int N) {
        int visited = 0;
        Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
        return countArrangement(N, 0, visited, cache);
    }
    
    private int countArrangement(int N, 
                                 int index, 
                                 int visited, 
                                 Map<Integer, Integer> cache){
        int result = 0;
        
        if(index == N) return 1;
        
        if(cache.containsKey(visited)) return cache.get(visited);
        
        for(int i = 1; i <= N; i++){
            int bit = (1 << (i - 1));
            if(((index + 1) % i != 0) && (i % (index + 1) != 0)) continue;
            if((visited & bit) == 0){
                result += countArrangement(N, index + 1, visited | bit, cache);
            }
        }
        cache.put(visited, result);
        return result;
    }
}