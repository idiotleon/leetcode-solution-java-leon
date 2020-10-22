package com.zea7ot.leetcode.lvl3.lc0838;

public class SolutionApproach0TwoPointers {
    public String pushDominoes(String dominoes) {
        final char[] CHS = ('L' + dominoes + 'R').toCharArray();
        final int LEN = CHS.length;

        StringBuilder builder = new StringBuilder();
        int lo = 0;

        for (int hi = 1; hi < LEN; ++hi) {
            if (CHS[hi] == '.')
                continue;

            int mid = hi - lo - 1;

            if (lo > 0) {
                builder.append(CHS[lo]);
            }

            if (CHS[lo] == CHS[hi]) {
                for (int k = 0; k < mid; ++k) {
                    builder.append(CHS[lo]);
                }
            } else if (CHS[lo] == 'L' && CHS[hi] == 'R') {
                for (int k = 0; k < mid; ++k) {
                    builder.append('.');
                }
            } else {
                for (int k = 0; k < mid / 2; ++k) {
                    builder.append('R');
                }

                if (mid % 2 == 1) {
                    builder.append('.');
                }

                for (int k = 0; k < mid / 2; ++k) {
                    builder.append('L');
                }
            }

            lo = hi;
        }

        return builder.toString();
    }
}
