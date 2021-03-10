package com.an7one.leetcode.interativeprogram.lvl2;

import java.util.Arrays;
import java.util.List;

class FakeBinaryMatrix {
    protected List<Integer> dimensions() {
        return Arrays.asList(10, 10);
    }

    protected int get(int row, int col) {
        return 1;
    }
}
