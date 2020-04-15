/**
 * https://leetcode.com/problems/array-partition-i/
 * 
 * https://youtu.be/wDU72F6dhS4?t=224
 * 
 * Time Complexity: O(N + max(nums) - min(nums))
 * Space Complexity: O(max(nums) - min(nums))
 */
package main.java.lcidiot.lc0561;

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

    public int arrayPairSum2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        final int MAX_RANGE = 10000;
        // to keep track of how many times an element appears
        int[] times = new int[2 * MAX_RANGE + 1];
        
        for(int num : nums){
            // MAX_RANGE here is the offset
            ++times[num + MAX_RANGE];
        }
        
        int ans = 0;
        // to initialize the cursor, with the minimum value possibly
        int i = -MAX_RANGE;
        // if the element is met for the first time, to return true
        // if the element is met for the 2nd time, or even more times, to return false
        boolean firstMet = true;
        
        while(i <= MAX_RANGE){
            // MAX_RANGE here is the offset
            if(times[i + MAX_RANGE] == 0){
                ++i;
                continue;
            }
            
            if(firstMet){
                ans += i;
                firstMet = false;
            }else{
                firstMet = true;
            }
            
            --times[i + MAX_RANGE];
        }
        
        return ans;
    }
}