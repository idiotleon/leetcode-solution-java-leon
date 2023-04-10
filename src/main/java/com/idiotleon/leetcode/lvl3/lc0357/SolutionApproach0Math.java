/**
 * https://leetcode.com/problems/count-numbers-with-unique-digits/
 * 
 * Time Complexity:     O(N), where N < 10 ~ O(1)
 *  N, any number that is larger than 10 cannot make any digit unique 
 * Space Complexity:    O(1)
 * 
 * Reference:
 *  https://leetcode.com/problems/count-numbers-with-unique-digits/discuss/83041/JAVA-DP-O(1)-solution.
 */
package com.idiotleon.leetcode.lvl3.lc0357;

public class SolutionApproach0Math {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;

        int ans = 10, uniqueDigits = 9, availableNumber = 9;
        while (n-- > 1 && availableNumber > 0) {
            uniqueDigits = uniqueDigits * availableNumber;
            ans += uniqueDigits;
            --availableNumber;
        }

        return ans;
    }
}