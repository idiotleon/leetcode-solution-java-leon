/**
 * https://leetcode.com/problems/camelcase-matching/
 */
package com.an7one.leetcode.lvl3.lc1023;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionApproach2Regex {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        return Arrays.stream(queries).map(q -> q.matches("[a-z]*" + String.join("[a-z]*", pattern.split("")) + "[a-z]*")).collect(Collectors.toList());
    }
}