/**
 * https://leetcode.com/problems/custom-sort-string/
 * 
 * Time Complexity:     O(LEN(S) + LEN(T))
 * Space Complexity:    O(LEN(T))
 * 
 * References:
 *  https://leetcode.com/problems/custom-sort-string/discuss/116615/JavaPython-3-one-Java-10-liner-Python-6-liner-and-2-liner-solutions-w-comment
 */
package com.zea7ot.lc.lvl2.lc0791;

public class SolutionApproach0BucketSort {
    public String customSortString(String S, String T) {
        int[] freq = new int[26];
        for(char ch : T.toCharArray())
            ++freq[ch - 'a'];
        
        StringBuilder builder = new StringBuilder();
        for(char ch : S.toCharArray())
            while(freq[ch - 'a']-- > 0)
                builder.append(ch);
        
        for(char ch = 'a'; ch <= 'z'; ++ch)
            while(freq[ch - 'a']-- > 0)
                builder.append(ch);
        
        return builder.toString();
    }
}