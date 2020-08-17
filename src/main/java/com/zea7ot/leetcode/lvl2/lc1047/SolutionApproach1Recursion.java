/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 * 
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(L ^ 2)
 * 
 * References:
 *  https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/discuss/294930/C%2B%2B-Recursive
 */
package com.zea7ot.leetcode.lvl2.lc1047;

public class SolutionApproach1Recursion {
    public String removeDuplicates(String S) {
        final int L = S.length();
        for(int i = 1; i < L; ++i){
            if(S.charAt(i - 1) == S.charAt(i)){
                return removeDuplicates(S.substring(0, i - 1) + S.substring(i + 1));
            }
        }
        
        return S;
    }
}