/**
 * https://leetcode.com/problems/distinct-echo-substrings/
 * 
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(L)
 * 
 * References:
 *  https://leetcode.com/problems/distinct-echo-substrings/discuss/477217/Java-Brute-force-and-Hash-Solution-Clean-code/426033
 *  https://leetcode.com/problems/distinct-echo-substrings/discuss/477217/Java-Brute-force-and-Hash-Solution-Clean-code
 */
package com.an7one.leetcode.lvl4.lc1316;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0RollingHash {
    private static final long BASE = 29L;
    private static final long MOD = (long) 1e9 + 7;

    public int distinctEchoSubstrings(String text) {
        final Set<Long> SET = new HashSet<>();
        final int L = text.length();
        final char[] CHS = text.toCharArray();

        final long[] HASHES = new long[L + 1];
        final long[] POWERS = new long[L + 1];
        POWERS[0] = 1;

        for (int i = 1; i <= L; ++i) {
            HASHES[i] = (HASHES[i - 1] * BASE + CHS[i - 1]) % MOD;
            POWERS[i] = POWERS[i - 1] * BASE % MOD;
        }

        for (int i = 0; i < L; ++i)
            for (int len = 2; i + len <= L; len += 2) {
                int mid = i + len / 2;
                long hash1 = getHash(i, mid, HASHES, POWERS);
                long hash2 = getHash(mid, i + len, HASHES, POWERS);
                if (hash1 == hash2)
                    SET.add(hash1);
            }

        return SET.size();
    }

    private long getHash(int lo, int hi, final long[] HASHES, final long[] POWERS) {
        return (HASHES[hi] - HASHES[lo] * POWERS[hi - lo] % MOD + MOD) % MOD;
    }
}
