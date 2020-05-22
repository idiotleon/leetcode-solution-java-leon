/**
 * https://leetcode.com/problems/split-array-largest-sum/
 * 
 * https://youtu.be/_k-Jb4b7b_0
 * http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-410-split-array-largest-sum/
 * 
 * Time Complexity: O(lg(sum(nums)) * n)
 * Space Complexity: O(1)
 * 
 * #BinarySearch
 * #Greedy
 * 
 * The answer must be in the range:
 * Lower Bound: max value of nums
 *  this means, no matter what nums, m is, how nums is going to be splitted, 
 *  the min value of largest sum always is bigger than the largest value in nums
 * 
 * Upper Bound: sum of nums (plus 1, depending on whether the last value is exclusive or inclusive)
 *  this means, no matter what nums, m is, how nums is going to be splitted, 
 *  the min value of largest sum always is smaller than the total sum of nums
 * 
 * Given a candidate C, to compute the number groups k needed
 * 
 * if k > m: C is too small
 *  left = C + 1
 * else
 *  right = C
 * 
 * References: 
 *  https://leetcode.com/problems/divide-chocolate/discuss/408503/JavaC++Python-Binary-Search/494896
 *  https://leetcode.com/problems/divide-chocolate/discuss/408503/JavaC++Python-Binary-Search/380399
 *  https://leetcode.com/problems/divide-chocolate/discuss/408503/JavaC++Python-Binary-Search/394052
 * 
 * Similar Problems:
 *  https://leetcode.com/problems/divide-chocolate/
 *  https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 */
package com.polyg7ot.lc.lvl4.lc0410;

public class SolutionApproach0BinarySearch {
    public int splitArray(int[] nums, int m) {
        if(nums == null || nums.length == 0) return 0;
        
        long left = 0, right = 1;
        for(int num : nums){
            left = Math.max(left, num);
            right += num;
        }
        
        while(left < right){
            long limit = left + (right - left) / 2;
            // if there are too many groups with such a limit
            if(minGroups(nums, limit) > m){
                // to increase the limit
                left = limit + 1;
            }else{
                // otherwise to decrease the limit
                right = limit;
            }
        }
        
        return (int)left;
    }
    
    private int minGroups(int[] nums, long limit){
        long sum = 0;
        int groups = 1;
        for(int num : nums){
            if(sum + num > limit){
                sum = num;
                ++groups;
            }else{
                sum += num;
            }
        }
        
        return groups;
    }
}