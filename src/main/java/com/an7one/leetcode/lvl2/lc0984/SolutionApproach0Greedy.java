/**
 * https://leetcode.com/problems/string-without-aaa-or-bbb/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/string-without-aaa-or-bbb/discuss/226649/JavaC++-(and-Python)-simple-greedy
 */
package com.an7one.leetcode.lvl2.lc0984;

public class SolutionApproach0Greedy {
    public String strWithout3a3b(int A, int B) {
        return A > B ? strWithout3a3b(A, B, 'a', 'b') : strWithout3a3b(B, A, 'b', 'a');
    }
    
    private String strWithout3a3b(int A, int B, char a, char b){
        StringBuilder builder = new StringBuilder();
        int countA = A, countB = B;
        while(countA-- > 0){
            builder.append(a);
            if(countA > countB){
                builder.append(a);
                --countA;
            }
            
            if(countB-- > 0){
                builder.append(b);
            }
        }
        
        return builder.toString();
    }
}