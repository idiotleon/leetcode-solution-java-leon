/**
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/
 * 
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/discuss/303781/JavaPython-3-3-codes-each%3A-Recursive-iterative-and-regex-w-brief-comments-and-analysis.
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
package com.zea7ot.lc.lvl2.lc1071;

public class SolutionApproachIteration {
    public String gcdOfStrings(String str1, String str2) {
        final int M = str1.length(), N = str2.length();
        int d = greatestCommonDivisor(M, N);
        
        String s = str1.substring(0, d), str = str1 + str2;
        for(int i = 0; i < M + N; i += d){
            if(!str.startsWith(s, i)){
                return "";
            }
        }
        
        return s;
    }
    
    private int greatestCommonDivisor(int a, int b){
        return a == 0 ? b : greatestCommonDivisor(b % a, a);
    }
}