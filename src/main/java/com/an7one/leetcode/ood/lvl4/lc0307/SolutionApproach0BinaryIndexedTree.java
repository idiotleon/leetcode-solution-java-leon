/**
 * https://leetcode.com/problems/range-sum-query-mutable/
 * 
 * Time Complexities:   O(N_CALLS * lg(`N`))
 *  N_CALLS, number of calls
 *
 * Space Complexity:    O(`nNums`)
 * 
 * References:
 *  https://leetcode.com/problems/range-sum-query-mutable/discuss/75753/Java-using-Binary-Indexed-Tree-with-clear-explanation
 *  https://cs.stackexchange.com/questions/10538/bit-what-is-the-intuition-behind-a-binary-indexed-tree-and-how-was-it-thought-a
 */
package com.an7one.leetcode.ood.lvl4.lc0307;

public class SolutionApproach0BinaryIndexedTree {
    private int[] nums;
    private final int[] BIT;
    private int N;

    public SolutionApproach0BinaryIndexedTree(int[] nums) {
        this.nums = nums;
        this.N = nums.length;
        this.BIT = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            init(i, nums[i]);
        }
    }

    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        init(i, diff);
    }

    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }

    private int getSum(int i) {
        int sum = 0;
        i++;
        while (i > 0) {
            sum += BIT[i];
            i -= (i & -i);
        }
        return sum;
    }

    private void init(int i, int val) {
        ++i;
        while (i <= N) {
            BIT[i] += val;
            i += (i & -i);
        }
    }
}