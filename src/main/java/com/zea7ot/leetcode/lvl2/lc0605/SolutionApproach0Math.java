/**
 * https://leetcode.com/problems/can-place-flowers/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/can-place-flowers/discuss/103883/Java-Very-easy-solution
 */
package com.zea7ot.leetcode.lvl2.lc0605;

public class SolutionApproach0Math {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // sanity check
        if (flowerbed == null || flowerbed.length == 0)
            return false;

        final int N = flowerbed.length;

        int count = 1;
        int capacity = 0;

        for (int i = 0; i < N; ++i) {
            if (flowerbed[i] == 0)
                ++count;
            else {
                capacity += (count - 1) / 2;
                count = 0;
            }
        }

        if (count != 0)
            capacity += count / 2;

        return capacity >= n;
    }
}