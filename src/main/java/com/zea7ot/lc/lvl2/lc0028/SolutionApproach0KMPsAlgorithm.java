/**
 * https://leetcode.com/problems/implement-strstr/
 * 
 * Time Complexity:     O(M + N)
 * Space Complexity:    O(N)
 */
package com.zea7ot.lc.lvl2.lc0028;

public class SolutionApproach0KMPsAlgorithm {
    public int strStr(String haystack, String needle) {
        final int M = haystack.length(), N = needle.length();
        if(M < N) return -1;
        
        int[] kmpTable = new int[N];
        int i = 1, j = 0;
        while(i < N){
            if(needle.charAt(i) == needle.charAt(j)){
                // j++;
                // kmpTable[i] = j;
                // i++;
                kmpTable[i++] = ++j;
            }else if(j == 0){
                kmpTable[i] = 0;
                i++;
            }else{
                j = kmpTable[j - 1];
            }
        }
        
        i = 0;
        j = 0;
        while(i < M){
            if(j == N) break;
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else if(j == 0){
                i++;
            }else{
                j = kmpTable[j - 1];
            }
        }
        
        if(j == N){
            return i - N;
        }
        
        return -1;
    }
}