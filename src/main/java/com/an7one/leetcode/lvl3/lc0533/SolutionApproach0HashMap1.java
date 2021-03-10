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
 *  https://leetcode.com/problems/lonely-pixel-ii/discuss/100216/Verbose-Java-O(m*n)-Solution-HashMap/117891
 */
package com.an7one.leetcode.lvl3.lc0533;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0HashMap1 {
    public int findBlackPixel(char[][] picture, int N) {
        // sanity check
        if(picture == null || picture.length == 0 || picture[0].length == 0) return 0;
        
        Map<BitSet, Integer> map = new HashMap<BitSet, Integer>();
        
        final int NC = picture[0].length;
        // not used
        // final int NR = picture.length, 
        int[] colCount = new int[NC];
        
        for(char[] pictureRow : picture){
            BitSet row = new BitSet(NC);
            for(int col = 0; col < NC; col++){
                if(pictureRow[col] == 'B'){
                    row.flip(col);
                    ++colCount[col];
                }
            }
            if(row.cardinality() == N){
                map.put(row, map.getOrDefault(row, 0) + 1);
            }
        }
        
        int count = 0;
        for(Map.Entry<BitSet, Integer> entry : map.entrySet()){
            if(entry.getValue() == N){
                BitSet row = entry.getKey();
                for(int i = row.nextSetBit(0); i >= 0; i = row.nextSetBit(i + 1)){
                    if(colCount[i] == N){
                        count += N;
                    }
                }
            }
        }
        
        return count;
    }
}