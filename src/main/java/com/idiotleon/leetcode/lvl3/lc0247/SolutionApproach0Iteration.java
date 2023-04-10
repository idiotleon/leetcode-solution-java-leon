package com.idiotleon.leetcode.lvl3.lc0247;

import com.idiotleon.util.Constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Iteration {
    public List<String> findStrobogrammatic(int n) {
        List<String> ans = new ArrayList<>((n & 1) == 0 ? List.of("") : Arrays.asList("0", "1", "8"));
        if (n < 2)
            return ans;

        List<String> prev;
        while (n > 1) {
            prev = ans;
            ans = new ArrayList<>();
            for (String str : prev) {
                if (n > 3)
                    ans.add("0" + str + "0");

                ans.add("1" + str + "1");
                ans.add("8" + str + "8");
                ans.add("6" + str + "9");
                ans.add("9" + str + "6");
            }

            n -= 2;
        }

        return ans;
    }
}