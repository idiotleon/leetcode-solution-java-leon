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
 */
package main.java.lcidiot.lc0410;

public class SolutionApproachBinarySearch {
    public int splitArray(int[] nums, int m) {
        if(nums == null || nums.length == 0) return 0;
        
        long left = 0, right = 1;
        for(int num : nums){
            left = Math.max(left, num);
            right += num;
        }
        
        while(left < right){
            long limit = left + (right - left) / 2;
            if(minGroups(nums, limit) > m){
                left = limit + 1;
            }else{
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