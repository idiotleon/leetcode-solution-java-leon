/**
 * https://leetcode.com/problems/candy/
 * 
 * Time Complexity:     O(2 * N) ~ O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/candy/discuss/42769/A-simple-solution/41219
 *  https://leetcode.com/problems/candy/discuss/42769/A-simple-solution
 */
package com.zea7ot.leetcode.lvl4.lc0135;

import java.util.Arrays;

public class SolutionApproach0TwoPasses {
    public int candy(int[] ratings) {
        // sanity check
        if(ratings == null || ratings.length == 0) return 0;

        final int N = ratings.length;
        int[] candies = new int[N];
        Arrays.fill(candies, 1);
        
        for(int i = 1; i < N; i++){
            if(ratings[i] > ratings[i - 1]){
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        for(int i = N - 1; i > 0; i--){
            if(ratings[i - 1] > ratings[i]){
                candies[i - 1] = Math.max(candies[i] + 1, candies[i - 1]);
            }
        }
        
        int totalCandies = 0;
        for(int candy : candies) totalCandies += candy;
        return totalCandies;
    }
}