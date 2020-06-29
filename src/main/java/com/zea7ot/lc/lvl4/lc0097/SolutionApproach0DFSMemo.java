/**
 * https://leetcode.com/problems/interleaving-string/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/interleaving-string/discuss/31888/1ms-tiny-DFS-beats-94.57
 */
package com.zea7ot.lc.lvl4.lc0097;

public class SolutionApproach0DFSMemo {
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] chs1 = s1.toCharArray(), chs2 = s2.toCharArray(), chs3 = s3.toCharArray();
        final int L1 = s1.length(), L2 = s2.length(), L3 = s3.length();
        // sanity check
        if(L1 + L2 != L3) return false;
        return isInterleave(0, 0, 0, chs1, chs2, chs3, new Boolean[L1 + 1][L2 + 1]);
    }
    
    private boolean isInterleave(int idx1, int idx2, int idx3,
                                 char[] chs1, char[] chs2, char[] chs3,
                                 Boolean[][] memo){
        if(memo[idx1][idx2] != null) return memo[idx1][idx2];
        final int L1 = chs1.length, L2 = chs2.length, L3 = chs3.length;
        if(idx3 == L3) return true;
        
        if((idx1 < L1 && chs1[idx1] == chs3[idx3] && isInterleave(idx1 + 1, idx2, idx3 + 1, chs1, chs2, chs3, memo)) 
            || (idx2 < L2 && chs2[idx2] == chs3[idx3] && isInterleave(idx1, idx2 + 1, idx3 + 1, chs1, chs2, chs3, memo))){
            return memo[idx1][idx2] = true;
        };
        return memo[idx1][idx2] = false;
    }
}