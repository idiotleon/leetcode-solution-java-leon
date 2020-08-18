/**
 * https://leetcode.com/problems/rearrange-string-k-distance-apart/
 * 
 * Time Complexity:     O(L * 26) ~ O(L)
 * Space Complexiyt:    O(L)
 * 
 * References:
 *  https://leetcode.com/problems/rearrange-string-k-distance-apart/discuss/83193/Java-15ms-Solution-with-Two-auxiliary-array.-O(N)-time.
 */
package com.zea7ot.leetcode.lvl4.lc0358;

public class SolutionApproach0Greedy {
    public String rearrangeString(String s, int k) {
        final int L = s.length();
        char[] chs = s.toCharArray();
        int[] freq = new int[26];
        int[] valid = new int[26];
        for(char ch : chs) ++freq[ch - 'a'];
        
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < L; i++){
            int candidatePos = findValidMax(freq, valid, i);
            if(candidatePos == -1) return "";
            --freq[candidatePos];
            valid[candidatePos] = i + k;
            builder.append((char)(candidatePos + 'a'));
        }
        return builder.toString();
    }
    
    private int findValidMax(int[] freq, int[] valid, int index){
        int max = Integer.MIN_VALUE;
        int candidatePos = -1;
        for(int i = 0; i < freq.length; i++){
            if(freq[i] > 0 && freq[i] > max && index >= valid[i]){
                max = freq[i];
                candidatePos = i;
            }
        }
        
        return candidatePos;
    }
}