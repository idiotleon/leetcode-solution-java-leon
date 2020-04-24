/**
 * https://leetcode.com/problems/array-partition-i/
 * 
 * https://youtu.be/wDU72F6dhS4?t=224
 * 
 * Time Complexity: O(N + max(nums) - min(nums))
 * Space Complexity: O(max(nums) - min(nums))
 */
package main.java.lcidiot.lc.lvl2.lc0561;

public class SolutionApproachHashTable {
    public int arrayPairSum(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int maxVal = Integer.MIN_VALUE, minVal = Integer.MAX_VALUE;
        for(int num : nums){
            if(num > maxVal) maxVal = num;
            if(num < minVal) minVal = num;
        }
        
        final int offset = -minVal;
        int[] times = new int[maxVal - minVal + 1];
        
        for(int num : nums){
            ++times[num + offset];
        }
        
        int ans = 0, index = 0, n = minVal;
        while(n <= maxVal){
            if(times[n + offset] == 0){
                ++n;
                continue;
            }
            
            ans += (++index % 2 == 1) ? n : 0;
            --times[n + offset];
        }
        
        return ans;
    }
}