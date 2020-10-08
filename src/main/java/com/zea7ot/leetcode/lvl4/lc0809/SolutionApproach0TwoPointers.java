/**
 * https://leetcode.com/problems/expressive-words/
 * 
 * Time Complexity:     O(N * L)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/expressive-words/discuss/122660/C++JavaPython-2-Pointers-and-4-pointers/293460
 *  https://leetcode.com/problems/expressive-words/discuss/122660/C%2B%2BJavaPython-2-Pointers-and-4-pointers
 *  https://leetcode.com/problems/expressive-words/discuss/121706/Java-Solution-using-Two-Pointers-with-Detailed-Explanation
 */
package com.zea7ot.leetcode.lvl4.lc0809;

public class SolutionApproach0TwoPointers {
    public int expressiveWords(String S, String[] words) {
        int sketchy = 0;
        for (String word : words) {
            if (isSketchy(S, word)) {
                ++sketchy;
            }
        }

        return sketchy;
    }

    private boolean isSketchy(String str1, String str2) {
        final int LEN1 = str1.length(), LEN2 = str2.length();
        int idx1 = 0, idx2 = 0;

        while (idx1 < LEN1 && idx2 < LEN2) {
            if (str1.charAt(idx1) != str2.charAt(idx2))
                return false;

            int repeatedLen1 = getRepeatedLen(str1, idx1);
            int repeatedLen2 = getRepeatedLen(str2, idx2);

            if (repeatedLen1 < 3 && repeatedLen1 != repeatedLen2)
                return false;

            if (repeatedLen1 < repeatedLen2)
                return false;

            idx1 += repeatedLen1;
            idx2 += repeatedLen2;
        }

        return idx1 == LEN1 && idx2 == LEN2;
    }

    private int getRepeatedLen(String str, int idx) {
        final int L = str.length();
        final char[] CHS = str.toCharArray();

        int cur = idx;
        while (cur < L && CHS[cur] == CHS[idx]) {
            ++cur;
        }

        return cur - idx;
    }
}
