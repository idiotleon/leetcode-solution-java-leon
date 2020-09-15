package com.zea7ot.leetcode.lvl3.lc0253.folllowups.followup0;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.zea7ot.leetcode.lvl3.lc0253.followups.followup0.SolutionApproach0SweepLine;

import org.junit.jupiter.api.Test;

public class TestSolutionApproachSweepLine {
    private SolutionApproach0SweepLine solution = new SolutionApproach0SweepLine();

    @Test
    void test() {
        int[][] sample = { { 0, 30 }, { 5, 10 }, { 15, 20 } };

        List<int[]> scheduleMeeting0 = new ArrayList<int[]>() {
            {
                add(new int[] { 0, 30 });
            }
        };

        List<int[]> scheduleMeeting1 = Arrays.asList(new int[] { 5, 10 }, new int[] { 15, 20 });
        List<List<int[]>> expected = new ArrayList<>() {
            {
                add(scheduleMeeting0);
                add(scheduleMeeting1);
            }
        };

        List<List<int[]>> actual = solution.meetingRoomsSchedules(sample);

        assertTrue(isEqualByValues(actual, expected));
    }

    private boolean isEqualByValues(List<List<int[]>> actual, List<List<int[]>> expected) {
        final int SIZE = expected.size();
        for (int i = 0; i < SIZE; ++i) {
            List<int[]> list1 = actual.get(i);
            List<int[]> list2 = expected.get(i);

            final int SIZE1 = list1.size(), SIZE2 = list2.size();
            if (SIZE1 != SIZE2)
                return false;

            for (int j = 0; j < SIZE1; ++j) {
                int[] arr1 = list1.get(j);
                int[] arr2 = list2.get(j);

                if (!Arrays.equals(arr1, arr2))
                    return false;
            }
        }

        return true;
    }
}
