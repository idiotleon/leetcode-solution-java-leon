/**
 * https://leetcode.com/problems/circular-array-loop/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/circular-array-loop/discuss/94148/Java-SlowFast-Pointer-Solution/98467
 *  https://leetcode.com/problems/circular-array-loop/discuss/94148/Java-SlowFast-Pointer-Solution
 */
package com.zea7ot.leetcode.lvl3.lc0457;

public class SolutionApproach1FloydCycle {
    public boolean circularArrayLoop(int[] nums) {
        final int N = nums.length;
        // required
        if (N < 2)
            return false;

        for (int i = 0; i < N; ++i) {
            if (nums[i] == 0)
                continue;

            int slow = i, fast = proceed(slow, nums);

            while (nums[i] * nums[fast] > 0 && nums[i] * nums[proceed(fast, nums)] > 0) {
                if (slow == fast) {
                    if (slow == proceed(slow, nums))
                        break;
                    return true;
                }

                slow = proceed(slow, nums);
                fast = proceed(proceed(fast, nums), nums);
            }

            slow = i;
            int sign = nums[i];
            while (sign * nums[slow] > 0) {
                int temp = proceed(slow, nums);
                nums[slow] = 0;
                slow = temp;
            }
        }

        return false;
    }

    private int proceed(int cur, int[] nums) {
        final int N = nums.length;

        int next = cur + nums[cur];
        next %= N;
        if (next < 0)
            next += N;

        return next;
    }
}
