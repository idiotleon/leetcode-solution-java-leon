/**
 * Time Complexity:     O(3 * 21 * N) ~ O(N)
 *  N, number of calls/cards in total
 */
package com.idiotleon.bycompany.others.array.black_jack;

public class SolutionApproach0DP2Dimen2 {
    private boolean[][] dp;

    public SolutionApproach0DP2Dimen2() {
        // 1-indexed, instead of 0-indexed
        this.dp = new boolean[3 + 1][21 + 1];
    }

    public boolean canWin(FakeCardApi api) {
        // NR == 3 + 1, NC == 21 + 1
        final int NR = dp.length, NC = dp[0].length;

        int[] cardsValues = api.getCardsValues();
        for (int value : cardsValues) {
            dp[1][value] = true; // with only one card, one canNOT win (reach 21) by any chance
            for (int card = NR - 2; card >= 1; --card) { // to start with the second last row, to the first row, to
                                                         // avoid repetitive face value addition(s)
                for (int face = 1; face < NC; ++face) { // to start with low/left to high/right
                    if (dp[card][face] && face + value < NC && card + 1 < NR) {
                        dp[card + 1][face + value] = true;

                        // to return true if it ever reaches `21`
                        if (dp[card + 1][21])
                            return true;
                    }
                }
            }
        }

        return false;
    }
}
