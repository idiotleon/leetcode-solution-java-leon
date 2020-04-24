/**
 * https://leetcode.com/problems/maximum-subarray/
 * 
 * Kadane's Algorithm
 * https://hackernoon.com/kadanes-algorithm-explained-50316f4fd8a6
 */

package main.java.lcidiot.lc.lvl2.lc0053;

class SolutionApproachDP{
    /**
     * Maximum sum subvector seen so far. The maximum is initially nums[0]. 
     * Suppose we've solved the problem for nums[1 .. i - 1], how can we extend that to nums[1 .. i]? 
     * The maximum sum in the first (i) elements is either the maximum sum in the first (i - 1) elements (which we'll call MaxSoFar), 
     * or it is that of a subvector that ends in position i (which we'll call MaxEndingHere).
     * MaxEndingHere is either nums[i] plus the previous MaxEndingHere, or just nums[i], whichever is larger.
     * https://leetcode.com/problems/maximum-subarray/discuss/20211/Accepted-O(n)-solution-in-java
     */
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0], maxEndingHere = nums[0];
        for(int i = 1; i < nums.length; ++i){
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        
        return maxSoFar;
    }

    /**
     * to reset if left sum is a negative value
     * https://leetcode.com/problems/maximum-subarray/discuss/20211/Accepted-O(n)-solution-in-java/20527
     */
    public int maxSubArray2(int[] nums) {
        int maxSub = Integer.MIN_VALUE, leftPositive = 0;
        for(int i = 0; i < nums.length; i++){
            maxSub = Math.max(maxSub, leftPositive + nums[i]);
            leftPositive = Math.max(0, leftPositive + nums[i]);
        }
        
        return maxSub;
    }

    public int maxSubArray3(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            sum = sum < 0 ? nums[i] : (sum + nums[i]);
            max = Math.max(max, sum);
        }
        
        return max;
    }

    public int maxSubArray4(int[] nums) {
        int localMax = 0, globalMax = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++){
            localMax = Math.max(nums[i], localMax + nums[i]);
            if(localMax > globalMax){
                globalMax = localMax;
            }
        }
        
        return globalMax;
    }
}