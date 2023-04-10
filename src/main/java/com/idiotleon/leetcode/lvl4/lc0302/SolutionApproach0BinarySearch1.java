/**
 * https://leetcode.com/problems/smallest-rectangle-enclosing-black-pixels/
 * 
 * Time Complexity: O(NR * lg(NC) + NC * lg(NR))
 * Space Complexity: O(1)
 * 
 * please pay more attention to boundary conditions of searchRightmost(,,,)
 * 
 * References:  
 *  https://leetcode.com/problems/smallest-rectangle-enclosing-black-pixels/discuss/75128/1ms-Concise-Java-Binary-Search-(DFS-is-4ms)
 */
package com.idiotleon.leetcode.lvl4.lc0302;

public class SolutionApproach0BinarySearch1 {
    public int minArea(char[][] image, int x, int y) {
        final int NR = image.length, NC = image[0].length;
        
        int leftmost = searchLeftmost(image, 0, y, true);
        int rightmost = searchRightmost(image, y, NC - 1, true);
        int top = searchLeftmost(image, 0, x, false);
        int bottom = searchRightmost(image, x, NR - 1, false);
        
        return (rightmost - leftmost + 1) * (bottom - top + 1);
    }
    
    private int searchLeftmost(char[][] image, int left, int right, boolean isHorizontal){
        while(left < right){
            int mid = left + (right - left) / 2;
            if(!hasBlack(image, mid, isHorizontal)){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        
        return left;
    }
    
    private int searchRightmost(char[][] image, int left, int right, boolean isHorizontal){
        while(left < right){
            int mid = left + (right - left + 1) / 2;
            if(!hasBlack(image, mid, isHorizontal)){
                right = mid - 1;
            }else{
                left = mid;
            }
        }
        
        return right;
    }
    
    private boolean hasBlack(char[][] image, int mid, boolean isHorizontal){
        if(isHorizontal){
            for(int row = 0; row < image.length; row++){
                if(image[row][mid] == '1'){
                    return true;
                }
            }
        }else{
            for(int col = 0; col < image[0].length; col++){
                if(image[mid][col] == '1'){
                    return true;
                }
            }
        }
        
        return false;
    }
}