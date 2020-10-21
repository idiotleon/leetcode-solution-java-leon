package com.zea7ot.by_companies.others.array.black_jack;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class FakeCardApi {
    private static final String[] CARDS = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
    private Random random;

    public static final int WINNING_CRITERIAL = 21;
    public static final Map<String, int[]> TENS_MAP = new HashMap<>() {
        {
            put("A", new int[] { 1, 11 });
            put("J", new int[] { 1, 10 });
            put("Q", new int[] { 1, 10 });
            put("K", new int[] { 1, 10 });
        }
    };

    public FakeCardApi() {
        this.random = new Random();
    }

    public String getCards() {
        final int N = CARDS.length;
        int rand = random.nextInt(N);
        return CARDS[rand];
    }

    public int[] getCardsValues() {
        final String CARD = getCards();

        if (TENS_MAP.containsKey(CARD)) {
            return TENS_MAP.get(CARD);
        } else {
            return new int[] { Integer.parseInt(CARD) };
        }
    }
}
