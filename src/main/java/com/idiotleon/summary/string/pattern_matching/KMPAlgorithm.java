/**
 * https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package com.idiotleon.summary.string.pattern_matching;

public class KMPAlgorithm {
    public int[] buildKMPTable(String pattern){
        final int L = pattern.length();
        int[] kmpTable = new int[L];
        if(pattern == null || pattern.isEmpty()) return kmpTable;

        int i = 1, j = 0;
        while(i < L){
            if(pattern.charAt(j) == pattern.charAt(i)){
                kmpTable[i++] = ++j;
            }else if(j == 0){
                i++;
            }else{
                j = kmpTable[j - 1];
            }
        }

        return kmpTable;
    }
}