/**
 * https://www.youtube.com/watch?v=CpZh4eF8QBw
 * 
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/string/ZAlgorithm.java
 */
package com.zea7ot.summaries.string.pattern_matching;

import java.util.ArrayList;
import java.util.List;

public class ZAlgorithm {
    private int[] calculateZ(char[] input){
        int[] Z = new int[input.length];
        int left = 0, right =0;
        for(int k = 1; k < input.length; k++){
            if(k > right){
                left = right = k;
                while(right < input.length && input[right] == input[right - left]){
                    right++;
                }
                Z[k] = right - left;
                right--;
            }else{
                int k1 = k - left;
                if(Z[k1] < right - k + 1){
                    Z[k] = Z[k1];
                }else{
                    left = k;
                    while(right < input.length && input[right] == input[right - left]){
                        right++;
                    }
                    Z[k] = right - left;
                    right--;
                }
            }
        }

        return Z;
    }

    public List<Integer> matchPattern(char[] text, char[] pattern){
        final int M = text.length, N = pattern.length;
        char[] newString = new char[M + N + 1];

        // to construct a big&new String combining text and pattern
        int i = 0;
        for(char ch : pattern){
            newString[i] = ch;
            i++;
        }

        newString[i] = '$';
        i++;

        for(char ch : text){
            newString[i] = ch;
            i++;
        }

        // to calculate Z array
        int[] Z = calculateZ(newString);
        
        List<Integer> ans = new ArrayList<Integer>();
        for(i = 0; i < Z.length; i++){
            if(Z[i] == N){
                ans.add(i - N - 1);
            }
        }

        return ans;
    }
}