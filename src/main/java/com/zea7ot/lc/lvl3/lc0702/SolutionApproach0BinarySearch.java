/**
 * https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
 * 
 * Time Complexity: O(lg(target))
 * Space Complexity: O(1)
 * 
 * References:
 *  https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/discuss/595200/(SIMPLE)-Java-100-Faster-and-Memory-Less-than-100-of-Solution
 */
package com.zea7ot.lc.lvl3.lc0702;

public class SolutionApproach0BinarySearch {
    public int search(FakeArrayReader reader, int target) {
        int left = 0, right = target - reader.get(0);
        if(reader.get(right) == target) return right;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            int val = reader.get(mid);
            if(val == target) return mid;
            if(val == Integer.MAX_VALUE || val > target){
                right = mid - 1;
            }else left = mid + 1;
        }
        
        return -1;
    }
}