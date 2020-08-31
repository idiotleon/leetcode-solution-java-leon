/**
 * https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/
 * 
 * Time Complexity:     O(n)
 * Space Complexity:    O(4) ~ O(1)
 * 
 * References:
 *  https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/discuss/49607/The-missing-clarification-you-wish-the-question-provided/199964
 *  https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/discuss/49601/What-is-the-difference-between-call-once-and-call-multiple-times
 *  https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/discuss/49607/The-missing-clarification-you-wish-the-question-provided
 */
package com.zea7ot.leetcode.lvl4.lc0158;

public class SolutionApproach0LinearScan extends FakeReader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */
    private int bufferIdx = 0;
    private int charsToRead = 0;
    private char[] buffer = new char[4];

    public int read(char[] buf, int n) {
        int idx = 0;
        while (idx < n) {
            // to reset the counter and buffer
            if (bufferIdx == charsToRead) {
                bufferIdx = 0;
                charsToRead = read4(buffer);
                if (charsToRead == 0)
                    break;
            }

            buf[idx++] = buffer[bufferIdx++];
        }

        return idx;
    }
}