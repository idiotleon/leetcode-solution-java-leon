/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 * 
 * References:
 *  https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/discuss/294964/JavaPython-3-three-easy-iterative-codes-w-brief-explanation-analysis-and-follow-up.
 */
package com.zea7ot.leetcode.lvl2.lc1047;

public class SolutionApproach0TwoPointers {
    public String removeDuplicates(String S) {
        char[] chs = S.toCharArray();
        int end = -1;
        for(char ch : chs){
            if(end >= 0 && chs[end] == ch)
                --end;
            else chs[++end] = ch;
        }
        
        return String.valueOf(chs, 0, end + 1);
    }
}