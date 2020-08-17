/**
 * https://leetcode.com/problems/longest-duplicate-substring/
 * 
 * Time Complexity:     O(L * lg(L))
 *  L, the length of the input string
 * 
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/longest-duplicate-substring/discuss/290871/Python-Binary-Search/274819
 *  https://leetcode.com/problems/longest-duplicate-substring/discuss/290871/Python-Binary-Search
 */
package com.zea7ot.leetcode.lvl5.lc1044;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach0BinarySearchWithRabinKarp {
    private static final int PRIME = (1 << 31) - 1;
    private static final int RADIX = 256;
    
    public String longestDupSubstring(String S) {
        // sanity check
        if(S == null || S.isEmpty()) return null;
        
        int lo = 0, hi = S.length(), mid;
        while(lo < hi){
            mid = lo + (hi - lo) / 2;
            int index = test(S, mid);
            if(index < 0) hi = mid;
            else lo = mid + 1;
        }
        
        int checkLen = lo - 1;
        if(checkLen <= 0) return "";
        int start = test(S, checkLen);
        return S.substring(start, start + checkLen);
    }
    
    private int test(String str, int m){
        Map<Long, List<Integer>> map = new HashMap<Long, List<Integer>>();
        long h = hash(str, m);
        map.put(h, new ArrayList<Integer>());
        map.get(h).add(0);
        
        long RM = 1;
        for(int i = 1; i <= m - 1; i++){
            RM = (RADIX * RM) % PRIME;
        }
        
        for(int i = m; i < str.length(); i++){
            h = (h + PRIME - RM * str.charAt(i - m) % PRIME) % PRIME;
            h = (h * RADIX + str.charAt(i)) % PRIME;
            int startIdx = i - m + 1;
            if(map.containsKey(h)){
                for(int prev : map.get(h)){
                    if(compare(str, startIdx, prev, m)){
                        return startIdx;
                    }
                }
            }else map.put(h, new ArrayList<Integer>());
            
            map.get(h).add(startIdx);
        }
        
        return -1;
    }
    
    private long hash(String key, int m){
        long h = 0;
        for(int j = 0; j < m; j++){
            h = (RADIX * h + key.charAt(j)) % PRIME;
        }
        return h;
    }
    
    private boolean compare(String str, int idx1, int idx2, int m){
        for(int i = 0; i < m; i++){
            if(str.charAt(idx1 + i) != str.charAt(idx2 + i)){
                return false;
            }
        }
        return true;
    }
}