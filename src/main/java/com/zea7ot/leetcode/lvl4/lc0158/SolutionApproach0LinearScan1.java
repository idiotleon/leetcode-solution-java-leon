/**
 * https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/
 * 
 * Time Complexity:     O(n)
 * Space Complexity:    O(4) ~ O(1)
 * 
 * References:
 *  https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/discuss/49598/A-simple-Java-code
 *  https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/discuss/49601/What-is-the-difference-between-call-once-and-call-multiple-times
 *  https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/discuss/49607/The-missing-clarification-you-wish-the-question-provided
 */
package com.zea7ot.leetcode.lvl4.lc0158;

public class SolutionApproach0LinearScan1 extends FakeReader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */
    private int buffPtr = 0;
    private int buffCnt = 0;
    private char[] buff = new char[4];

    public int read(char[] buf, int n) {
        int ptr = 0;
        while (ptr < n) {
            if (buffPtr == 0)
                buffCnt = read4(buff);

            if (buffCnt == 0)
                break;

            while (ptr < n && buffPtr < buffCnt)
                buf[ptr++] = buff[buffPtr++];

            if (buffPtr >= buffCnt)
                buffPtr = 0;
        }

        return ptr;
    }
}