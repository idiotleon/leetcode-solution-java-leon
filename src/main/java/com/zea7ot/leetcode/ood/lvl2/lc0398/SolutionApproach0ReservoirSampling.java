/**
 * https://leetcode.com/problems/random-pick-index/
 * 
 * Reservoir Sampling
 * 
 * References:
 *  https://www.youtube.com/watch?v=TWhCNrftDGM
 *  https://leetcode.com/problems/random-pick-index/discuss/88072/Simple-Reservoir-Sampling-solution
 */
package com.zea7ot.leetcode.ood.lvl2.lc0398;

import java.util.Random;

public class SolutionApproach0ReservoirSampling {
    private int[] nums;
    private Random random;

    public SolutionApproach0ReservoirSampling(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int pick(int target) {
        int res = -1;
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != target)
                continue;

            if (random.nextInt(++count) == 0) {
                res = i;
            }
        }

        return res;
    }
}