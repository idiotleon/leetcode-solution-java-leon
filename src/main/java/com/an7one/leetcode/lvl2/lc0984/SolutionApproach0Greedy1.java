/**
 * https://leetcode.com/problems/string-without-aaa-or-bbb/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:  
 *  https://leetcode.com/problems/string-without-aaa-or-bbb/discuss/226720/Java-Two-simple-logic-readable-codes-iterative-and-recursive-versions.
 */
package com.an7one.leetcode.lvl2.lc0984;

import java.util.Collections;

public class SolutionApproach0Greedy1 {
    public String strWithout3a3b(int A, int B) {
        if(A == 0 || B == 0)
            return String.join("", Collections.nCopies(A + B, A == 0 ? "b" : "a"));
        
        if(A == B)
            return "ab" + strWithout3a3b(A - 1, B - 1);
        
        if(A > B)
            return "aab" + strWithout3a3b(A - 2, B - 1);
        
        return "bba" + strWithout3a3b(A - 1, B - 2);
    }
}