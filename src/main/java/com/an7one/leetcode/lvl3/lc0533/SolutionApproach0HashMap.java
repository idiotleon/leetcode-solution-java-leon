/**
 * https://leetcode.com/problems/lonely-pixel-ii/
 * 
 * Time Complexity:     O(NR * NC)
 * 
 * Space Complexity:    O(NR * NC) + O(NC)
 *  O(NR * NC), consumed by the map, with a length of NC per key
 *  O(NC), consumed by the colCount(int[])
 * 
 * References:
 *  https://leetcode.com/problems/lonely-pixel-ii/discuss/100216/Verbose-Java-O(m*n)-Solution-HashMap
 */
package com.an7one.leetcode.lvl3.lc0533;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0HashMap {
    public int findBlackPixel(char[][] picture, int N) {
        // santiy check
        if(picture == null || picture.length == 0 || picture[0].length == 0) return 0;
        
        final int NR = picture.length, NC = picture[0].length;
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        int[] colCount = new int[NC];
        
        for(int row = 0; row < NR; row++){
            String key = scanRow(picture, row, N, colCount);
            if(!key.isEmpty()){
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        
        int count = 0;
        for(String key: map.keySet()){
            if(map.get(key) == N){
                for(int col = 0; col < NC; col++){
                    if(key.charAt(col) == 'B' && colCount[col] == N){
                        count += N;
                    }
                }
            }
        }
        
        return count;
    }
    
    private String scanRow(char[][] picture, int row, int target, int[] colCount){
        final int N = picture[0].length;
        int rowCount = 0;
        StringBuilder builder = new StringBuilder();
        
        for(int col = 0; col < N; col++){
            if(picture[row][col] == 'B'){
                ++rowCount;
                ++colCount[col];
            }
            builder.append(picture[row][col]);
        }
        
        if(rowCount == target) return builder.toString();
        return "";
    }
}