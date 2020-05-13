/**
 * https://www.youtube.com/watch?v=H4VrKHVG5qI
 * 
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/string/RabinKarpSearch.java
 * 
 * Time Complexity: O(N^2), in the worst case
 * Space Complexity: O(1)
 */
package com.polyg7ot.algorithm.template.pattern_matching;

public class RabinKarpSearch {
    private final int PRIME = 1001;

    public int patternSearch(char[] text, char[] pattern){
        final int M = pattern.length, N = text.length;
        long patternHash = createHash(pattern, M - 1);
        long textHash = createHash(text, M - 1);
        for(int i = 1; i <= N - M + 1; i++){
            if(patternHash == textHash && checkEqual(text, i - 1, i + M - 2, pattern, 0, M - 1)){
                return i - 1;
            }

            if(i < N - M + 1){
                textHash = recalculateHash(text, i - 1, i + M - 1, textHash, M);
            }
        }
        return -1;
    }

    private long createHash(char[] str, int end){
        long hash = 0;
        for(int i = 0; i <= end; i++){
            hash += str[i] * Math.pow(PRIME, i);
        }
        return hash;
    }

    private long recalculateHash(char[] str, int oldIdx, int newIdx, long oldHash, int patternLen){
        long newHash = oldHash - str[oldIdx];
        newHash = newHash / PRIME;
        newHash += str[newIdx] * Math.pow(PRIME, patternLen - 1);
        return newHash;
    }

    private boolean checkEqual(char[] str1, int start1, int end1, char[] str2, int start2, int end2){
        if(end1 - start1 != end2 - start2) return false;

        while(start1 <= end1 && start2 <= end2){
            if(str1[start1] != str2[start2]){
                return false;
            }
            start1++;
            start2++;
        }

        return true;
    }
}