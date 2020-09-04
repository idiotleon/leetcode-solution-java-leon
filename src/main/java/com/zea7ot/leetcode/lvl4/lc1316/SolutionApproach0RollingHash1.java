/**
 * https://leetcode.com/problems/distinct-echo-substrings/
 * 
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(L)
 * 
 * References:
 *  https://leetcode.com/problems/distinct-echo-substrings/discuss/492704/Easy100-Sliding-Window-Rolling-Counter
 */
package com.zea7ot.leetcode.lvl4.lc1316;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SolutionApproach0RollingHash1 {
    public int distinctEchoSubstrings(String text) {
        // sanity check
        if (text == null || text.isEmpty())
            return 0;

        final int L = text.length();
        final char[] CHS = text.toCharArray();

        final int RADIX = 256;
        final long PRIME = calculateRandomPrime();
        final long[] HASHES = new long[L + 1];
        final long[] POWERS = new long[L + 1];
        POWERS[0] = 1;
        for (int i = 1; i <= L; ++i) {
            HASHES[i] = (HASHES[i - 1] * RADIX + CHS[i - 1]) % PRIME;
            POWERS[i] = (POWERS[i - 1] * RADIX) % PRIME;
        }

        final Set<Long> SET = new HashSet<>();

        for (int len = 1; len <= L / 2; ++len) {
            int lo = 0, hi = len;
            int count = 0;
            while (lo < L - len) {
                if (CHS[lo] == CHS[hi])
                    ++count;
                else
                    count = 0;

                if (count == len) {
                    SET.add(getHash(lo - len + 1, lo + 1, HASHES, POWERS, PRIME));
                    --count;
                }

                ++hi;
                ++lo;
            }
        }

        return SET.size();
    }

    private long getHash(int lo, int hi, final long[] HASHES, final long[] POWERS, final long PRIME) {
        return (HASHES[hi] + PRIME - HASHES[lo] * POWERS[hi - lo] % PRIME) % PRIME;
    }

    private long calculateRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }
}
