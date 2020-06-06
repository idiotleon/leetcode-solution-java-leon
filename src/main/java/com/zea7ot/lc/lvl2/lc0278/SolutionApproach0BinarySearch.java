/**
 * https://leetcode.com/problems/first-bad-version/
 * 
 * Time Complexity: O(lg(N))
 * Space Complexity: O(1)
 */
package com.zea7ot.lc.lvl2.lc0278;

public class SolutionApproach0BinarySearch extends FakeVersionControl{
    public int firstBadVersion(int n) {
        
        int left = 1, right = n;
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if(isBadVersion(mid)){
                if(!isBadVersion(mid - 1)) return mid;
                else right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        
        return n;
    }
}