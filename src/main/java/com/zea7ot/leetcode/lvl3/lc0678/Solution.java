/**
 * https://leetcode.com/problems/valid-parenthesis-string/
 * 
 * https://leetcode.com/problems/valid-parenthesis-string/discuss/107570/JavaC%2B%2BPython-One-Pass-Count-the-Open-Parenthesis
 * 
 * We count the number of ')' we are waiting for,
 * and it's equal to the number of open parenthesis.
 * This number will be in a range and we count it as [minCount, maxCount]
 * 
 * maxCount counts the maximum open parenthesis,
 * which means the maximum number of unbalanced '(' that COULD be paired.
 * minCount counts the minimum open parenthesis,
 * which means the number of unbalanced '(' that MUST be paired.
 * 
 * Example:
 * It's quite straight forward actually.
 * When you met "(", you know you need one only one ")", minCount = 1 and maxCount = 1.
 * When you met "(*(", you know you need one/two/three ")", minCount = 1 and maxCount = 3.
 * 
 * The string is valid for 2 condition:
 *  maxCount will never be negative.
 *  minCount is 0 at the end.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
package com.zea7ot.leetcode.lvl3.lc0678;

public class Solution {
    public boolean checkValidString(String str) {
        // sanity check
        if(str == null || str.length() == 0) return true;
        
        int minCount = 0, maxCount = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                minCount++;
                maxCount++;
            }else if(str.charAt(i) == ')'){
                maxCount--;
                minCount = Math.max(minCount - 1, 0);
            }else{
                maxCount++;
                minCount = Math.max(minCount - 1, 0);
            }
            
            if(maxCount < 0) return false;
        }
        
        return minCount == 0;
    }
}