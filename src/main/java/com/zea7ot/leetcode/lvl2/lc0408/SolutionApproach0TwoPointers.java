/**
 * https://leetcode.com/problems/valid-word-abbreviation/
 * 
 * Time Complexity:     O(max(LEN_WORD, LEN_ABBR))
 * Space Complexity:    O(1)/O(LEN_WORD + LEN_ABBR)
 * 
 * References:
 *  https://leetcode.com/problems/valid-word-abbreviation/discuss/89523/Short-and-easy-to-understand-Java-Solution/94182
 */
package com.zea7ot.leetcode.lvl2.lc0408;

public class  SolutionApproach0TwoPointers {
    public boolean validWordAbbreviation(String word, String abbr) {
        final int LEN_WORD = word.length(), LEN_ABBR = abbr.length();
        char[] chsWord = word.toCharArray();
        char[] chsAbbr = abbr.toCharArray();
        int number = 0;
        int i = 0, j = 0;
        
        while(i < LEN_WORD && j < LEN_ABBR){
            if(Character.isDigit(chsAbbr[j])){
                number = number * 10 + (chsAbbr[j] - '0');
                if(number == 0) return false;
                ++j;
            }else{
                i += number;
                if(i >= LEN_WORD || chsWord[i] != chsAbbr[j]) return false;
                number = 0;
                ++i;
                ++j;
            }
        }
        
        i += number;
        return i == LEN_WORD && j == LEN_ABBR;
    }
}