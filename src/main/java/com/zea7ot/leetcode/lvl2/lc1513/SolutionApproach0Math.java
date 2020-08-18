/**
 * https://leetcode.com/problems/number-of-substrings-with-only-1s/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)/O(L)
 * 
 * References:
 *  https://leetcode.com/problems/number-of-substrings-with-only-1s/discuss/731580/JavaC%2B%2BPython-Count
 */
package com.zea7ot.leetcode.lvl2.lc1513;

public class SolutionApproach0Math {
    public int numSub(String s) {
        // sanity check
        if(s == null || s.isEmpty()) return 0;
        
        final int MOD = (int)(1e9 + 7);
        int ans = 0, count = 0;
        
        final int L = s.length();
        char[] chs = s.toCharArray();
        for(int i = 0; i < L; i++){
            count = chs[i] == '1' ? count + 1 : 0;
            ans = (ans + count) % MOD;
        }
        
        return ans;
    }
}