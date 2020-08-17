/**
 * https://leetcode.com/problems/sort-characters-by-frequency/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(L)
 * 
 * References:
 *  https://leetcode.com/problems/sort-characters-by-frequency/discuss/93420/Java-O(n)-Bucket-Sort-Solution-O(nlogm)-PriorityQueue-Solution-easy-to-understand
 */
package com.zea7ot.leetcode.lvl2.lc0451;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach0BucketSort {
    public String frequencySort(String s) {
        
        final int L = s.length();
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        List<List<Character>> bucket = new ArrayList<List<Character>>();
        for(int i = 0; i <= L; i++){
            bucket.add(new ArrayList<Character>());
        }
        
        for(char key : map.keySet()){
            int freq = map.get(key);
            bucket.get(freq).add(key);
        }
        
        StringBuilder builder = new StringBuilder();
        for(int pos = bucket.size() - 1; pos >= 0; pos--){
            if(!bucket.get(pos).isEmpty()){
                for(char ch : bucket.get(pos)){
                    for(int i = 0; i < map.get(ch); i++){
                        builder.append(ch);
                    }
                }
            }
        }
        
        return builder.toString();
    }
}