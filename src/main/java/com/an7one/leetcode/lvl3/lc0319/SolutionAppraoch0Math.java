/**
 * https://leetcode.com/problems/bulb-switcher/
 * 
 * Time Complexity:     O(1)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/bulb-switcher/discuss/77112/Share-my-o(1)-solution-with-explanation
 *  https://leetcode.com/problems/bulb-switcher/discuss/77132/The-simplest-and-most-efficient-solution-well-explained
 */
package com.an7one.leetcode.lvl3.lc0319;

public class SolutionAppraoch0Math {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}