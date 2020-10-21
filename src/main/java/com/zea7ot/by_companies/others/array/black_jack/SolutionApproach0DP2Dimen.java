/**
 * Time Complexity:     O(`CARDS_ALLOWED` * `FakeCardApi.WINNING_CRITERIAL` * N)
 *  N, number of calls/cards in total
 */
package com.zea7ot.by_companies.others.array.black_jack;

public class SolutionApproach0DP2Dimen {
    private boolean[][] dp;

    public SolutionApproach0DP2Dimen(final int CARDS_ALLOWED) {
        // 1-indexed, instead of 0-indexed
        this.dp = new boolean[CARDS_ALLOWED + 1][FakeCardApi.WINNING_CRITERIAL + 1];
    }

    public boolean canWin(FakeCardApi api) {
        final int NR = dp.length, NC = dp[0].length;

        int[] cardsValues = api.getCardsValues();
        for (int value : cardsValues) {
            dp[1][value] = true; // with only one card
            if (dp[1][FakeCardApi.WINNING_CRITERIAL])
                return true; // depending on `WINNING_CRITERIAL`, one with only one card might win

            for (int card = NR - 2; card >= 1; --card) { // to start with the second last row
                for (int face = 1; face < NC; ++face) { // to start with low/left to high/right
                    if (dp[card][face] && face + value < NC && card + 1 < NR) {
                        dp[card + 1][face + value] = true;

                        // to return true if it ever reaches `FakeCardApi.WINNING_CRITERIAL`
                        if (dp[card + 1][FakeCardApi.WINNING_CRITERIAL])
                            return true;
                    }
                }
            }
        }

        return false;
    }
}
