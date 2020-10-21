/**
 * Time Complexity:     O(`CARDS_ALLOWED` * `FakeCardApi.WINNING_CRITERIAL` * N)
 *  N, number of calls/cards in total
 */
package com.zea7ot.by_companies.others.array.black_jack;

public class SolutionApproach0DP2Dimen1 {
    private boolean[][] dp;

    public SolutionApproach0DP2Dimen1(final int CARDS_ALLOWED) {
        this.dp = new boolean[CARDS_ALLOWED + 1][FakeCardApi.WINNING_CRITERIAL + 1];
    }

    public boolean canWin(FakeCardApi api) {
        final int NR = dp.length, NC = dp[0].length;

        final String CARD = api.getCards();
        if (FakeCardApi.TENS_MAP.containsKey(CARD)) {
            int[] values = FakeCardApi.TENS_MAP.get(CARD);
            for (int value : values) {
                for (int card = NR - 2; card >= 0; --card) {
                    for (int face = 1; face < NC; ++face) {
                        if (dp[card][face] && face + value < NC && card + 1 < NR) {
                            dp[card + 1][face + value] = true;
                            if (dp[card + 1][FakeCardApi.WINNING_CRITERIAL])
                                return true;
                        }
                    }
                }
            }
        } else {
            int value = Integer.parseInt(CARD);
            for (int card = NR - 2; card >= 0; --card) {
                for (int face = 1; face < NC; ++face) {
                    if (dp[card][face] && face + value < NC && card + 1 < NR) {
                        dp[card + 1][face + value] = true;
                        if (dp[card + 1][FakeCardApi.WINNING_CRITERIAL])
                            return true;
                    }
                }
            }
        }

        return false;
    }
}
