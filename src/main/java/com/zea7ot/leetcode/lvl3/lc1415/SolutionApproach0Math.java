/**
 * https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/
 * 
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/discuss/585590/C%2B%2BJava-DFS-and-Math
 */
package com.zea7ot.leetcode.lvl3.lc1415;

public class SolutionApproach0Math {
    public String getHappyString(int n, int k) {
        int permutation = 1 << (n - 1);
        if (k > 3 * permutation)
            return "";

        int ch = 'a' + (k - 1) / permutation;
        StringBuilder builder = new StringBuilder(Character.toString(ch));
        while (permutation > 1) {
            k = (k - 1) % permutation + 1;
            permutation >>= 1;
            ch = (k - 1) / permutation == 0 ? 'a' + (ch == 'a' ? 1 : 0) : 'b' + (ch != 'c' ? 1 : 0);
            builder.append((char) ch);
        }

        return builder.toString();
    }
}
