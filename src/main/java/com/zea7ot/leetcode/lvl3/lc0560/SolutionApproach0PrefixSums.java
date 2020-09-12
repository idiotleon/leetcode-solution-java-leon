/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/subarray-sum-equals-k/discuss/102106/Java-Solution-PreSum-%2B-HashMap
 *  https://leetcode.com/problems/subarray-sum-equals-k/discuss/301242/General-summary-of-what-kind-of-problem-can-cannot-solved-by-Two-Pointers
 * 
 *  about `preifxSums.put(0, 1)`;
 *  https://leetcode.com/problems/subarray-sum-equals-k/discuss/102106/Java-Solution-PreSum-+-HashMap/416171
 *  https://leetcode.com/problems/subarray-sum-equals-k/discuss/102106/Java-Solution-PreSum-+-HashMap/238328
 */
package com.zea7ot.leetcode.lvl3.lc0560;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0PrefixSums {
    public int subarraySum(int[] nums, int k) {
        final Map<Integer, Integer> PREFIX_SUMS = new HashMap<>();
        // this is for situtations where (sum - k) == 0,
        // which are valid calculations, and should be counted.

        // (Were all elements not zeros)
        // Equivalently: if(sum == k) count++, in the loop

        // to handle the special case, where the subarray begins at index 0 with (sum ==
        // k)
        PREFIX_SUMS.put(0, 1);

        int sum = 0, count = 0;

        for (int num : nums) {
            sum += num;
            if (PREFIX_SUMS.containsKey(sum - k))
                count += PREFIX_SUMS.get(sum - k);

            PREFIX_SUMS.put(sum, PREFIX_SUMS.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}