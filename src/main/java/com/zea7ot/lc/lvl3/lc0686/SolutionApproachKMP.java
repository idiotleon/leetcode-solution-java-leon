/**
 * https://leetcode.com/problems/repeated-string-match/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
package com.zea7ot.lc.lvl3.lc0686;

public class SolutionApproachKMP {
    public int repeatedStringMatch(String A, String B) {
        if(A == null || A.isEmpty() || B == null || B.isEmpty()) return -1;
        
        final int M = A.length(), N = B.length();
        int[] kmpTable = new int[N];
        int i = 1, j = 0;
        while(i < N){
            if(B.charAt(i) == B.charAt(j)){
                kmpTable[i++] = ++j;
            }else if(j == 0){
                i++;
            }else{
                j = kmpTable[j - 1];
            }
        }
        
        i = 0; j = 0;
        int count = 0;
        while(j < N){
            if(i == M){
                // to repeat A once
                count++;
                // to reset i
                i = 0;
            }else if(A.charAt(i) == B.charAt(j)){
                i++;
                j++;
            }else{
                if((count - 1) * M + i > j){
                    return -1;
                }else if(j == 0){
                    i++;
                }else{
                    j = kmpTable[j - 1];
                }
            }
        }
        
        return count + 1;
    }
}