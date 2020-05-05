package com.polyg7ot.lc.lvl4.lc0305;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTestsApproachUnionFind {
    private final SolutionApproachUnionFind approachUnionFind = new SolutionApproachUnionFind();

    @Test
    @DisplayName("0305. Number of Islands II - Union Find")
    void test() {
        assertEquals(Arrays.asList(1, 1, 2, 3),
                approachUnionFind.numIslands2(3, 3, new int[][] { { 0, 0 }, { 0, 1 }, { 1, 2 }, { 2, 1 } }));

        assertEquals(Arrays.asList(1, 1, 2, 2),
                approachUnionFind.numIslands2(3, 3, new int[][] { { 0, 0 }, { 0, 1 }, { 1, 2 }, { 1, 2 } }));
    }
}