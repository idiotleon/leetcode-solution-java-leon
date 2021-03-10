/**
 * https://leetcode.com/problems/read-n-characters-given-read4/
 * 
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(4) ~ O(1)
 * 
 * References:
 *  https://leetcode.com/problems/read-n-characters-given-read4/discuss/49496/Another-accepted-Java-solution
 */
package com.an7one.leetcode.lvl2.lc0157;

public class SolutionApproach0LinearScan extends FakeReader4{
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int total = 0;
        boolean eof = false;

        while (!eof && total < n) {
            int count = read4(buffer);

            eof = count < 4;

            count = Math.min(count, n - total);

            for (int i = 0; i < count; ++i)
                buf[total++] = buffer[i];
        }

        return total;
    }
}