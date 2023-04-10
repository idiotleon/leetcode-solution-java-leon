/**
 * https://leetcode.com/problems/string-without-aaa-or-bbb/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/string-without-aaa-or-bbb/discuss/226661/Java-Simple-Greedy
 */
package com.idiotleon.leetcode.lvl2.lc0984;

public class SolutionApproach0Greedy2 {
    public String strWithout3a3b(int A, int B) {
        StringBuilder builder = new StringBuilder();
        final int SIZE = A + B;
        int a = 0, b = 0;
        for(int i = 0; i < SIZE; i++){
            if((A >= B && a != 2) || b == 2){
                builder.append("a");
                A--;
                a++;
                b = 0;
            }else if((B >= A && b != 2) || a == 2){
                builder.append("b");
                b++;
                B--;
                a = 0;
            }
        }
        
        return builder.toString();
    }
}