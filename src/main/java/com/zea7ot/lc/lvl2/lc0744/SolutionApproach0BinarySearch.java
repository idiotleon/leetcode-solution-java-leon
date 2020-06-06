/**
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 * 
 * 
 * References:
 *  https://leetcode.com/problems/find-smallest-letter-greater-than-target/discuss/110005/Easy-Binary-Search-in-Java-O(log(n))-time
 */
package com.zea7ot.lc.lvl2.lc0744;

public class SolutionApproach0BinarySearch {
    public char nextGreatestLetter(char[] letters, char target) {
        if(letters == null || letters.length == 0) return 0;
        
        final int N = letters.length;
        
        int left = 0, right = N - 1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(letters[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        
        return letters[left % N];
    }
}