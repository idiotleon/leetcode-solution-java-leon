/**
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 * 
 * Time Complexity:     ?O(N)
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/discuss/87738/Java-20-lines-very-easy-solution-7ms-with-explanation/394380
 */
package com.zea7ot.lc.lvl3.lc0395;

public class SolutionApproach0DFS {
    public int longestSubstring(String str, int k) {
        // sanity check
        if(str == null || str.isEmpty()) return 0;
        
        final int L = str.length();
        if(k < 2) return L;
        
        return dfs(str, 0, L, k);
    }
    
    private int dfs(String str, int lo, int hi, int k){
        if(lo >= hi) return 0;
        final int L = hi - lo;
        char[] chs = str.toCharArray();

        // to build up the freq map
        int[] freq = new int[26];
        for(int i = lo; i < hi; i++) ++freq[chs[i] - 'a'];
        
        // to check if valid
        boolean isValid = true;
        
        // if not valid
        // to start a new split search,
        // for each invalid character,
        int longest = 0, start = lo, end = lo;
        while(end < lo + L){
            if(freq[chs[end] - 'a'] < k){
                longest = Math.max(longest, dfs(str, start, end, k));
                isValid = false;
                start = end + 1;
            }
            
            ++end;
        }
        
        return isValid ? L : Math.max(longest, dfs(str, start, hi, k));
    }
}