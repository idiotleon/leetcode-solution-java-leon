/**
 * https://leetcode.com/problems/read-n-characters-given-read4/
 * 
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(4) ~ O(1)
 * 
 * References:
 *  https://leetcode.com/problems/read-n-characters-given-read4/discuss/49557/Accepted-clean-java-solution/49785
 */
package com.zea7ot.leetcode.lvl2.lc0157;

public class SolutionApproach0LinearScan1 extends FakeReader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int idx = 0;

        while (true) {
            int count = read4(buffer);

            // to get the actual count
            // Even if we read 4 chars from Read4,
            // we don't want to exceed N and only want to read chars till n
            count = Math.min(count, n - idx);

            // to copy from buffer to buf
            for (int i = 0; i < count; ++i) {
                buf[idx++] = buffer[i];
            }

            if (count < 4)
                return idx;
        }
    }
}