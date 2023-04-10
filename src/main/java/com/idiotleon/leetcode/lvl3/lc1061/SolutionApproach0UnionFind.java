/**
 * https://leetcode.com/problems/lexicographically-smallest-equivalent-string/
 * 
 * Time Complexity:     O()
 * Space Compplexity:   O()
 * 
 * References:
 *  
 */
package com.idiotleon.leetcode.lvl3.lc1061;

public class SolutionApproach0UnionFind {
    public String smallestEquivalentString(String A, String B, String S) {
        final int L = A.length(), LS = S.length();
        char[] chsA = A.toCharArray();
        char[] chsB = B.toCharArray();
        char[] chsS = S.toCharArray();
        
        int[] roots = new int[26];
        for(int i = 0; i < 26; i++){
            roots[i] = i;
        }
        
        for(int i = 0; i < L; i++){
            int a = chsA[i] - 'a';
            int b = chsB[i] - 'a';
            int end1 = find(roots, b);
            int end2 = find(roots, a);
            if(end1 < end2) roots[end2] = end1;
            else roots[end1] = end2;
        }
        
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < LS; i++){
            char ch = chsS[i];
            builder.append((char)('a' + find(roots, ch - 'a')));
        }
        
        return builder.toString();
    }
    
    private int find(int[] roots, int x){
        if(x == roots[x]) return x;
        return roots[x] = find(roots, roots[x]);
    }
}