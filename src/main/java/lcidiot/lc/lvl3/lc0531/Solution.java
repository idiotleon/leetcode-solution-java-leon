/**
 * https://leetcode.com/problems/lonely-pixel-i/
 * 
 * Time Complexity: O(mn)
 * Space Complexity: O(mn)
 */
package main.java.lcidiot.lc.lvl3.lc0531;

public class Solution {
    public int findLonelyPixel(char[][] picture) {
        int nr = picture.length, nc = picture[0].length;
        
        int[] blackRows = new int[nr], blackCols = new int[nc];
        for(int row = 0; row < nr; row++){
            for(int col = 0; col < nc; col++){
                if(picture[row][col] == 'B'){
                    blackRows[row]++;
                    blackCols[col]++;
                }
            }
        }
        
        int count = 0;
        for(int row = 0; row < nr; row++){
            for(int col = 0; col < nc; col++){
                if(blackRows[row] == 1 
                   && blackCols[col] == 1 
                   && picture[row][col] == 'B'){
                    count++;
                }
            }
        }
        
        return count;
    }
}