/**
 * https://leetcode.com/problems/logger-rate-limiter/
 * 
 * Time Complexity:     O(1)
 * Space Complexity:    O(N)
 *  N, total messages sent
 */
package com.zea7ot.lc.lvl2.lc0359;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0HashMap1 {
    private Map<String, Integer> cache;

    /** Initialize your data structure here. */
    public SolutionApproach0HashMap1() {
        this.cache = new HashMap<String, Integer>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp,
     * otherwise returns false. If this method returns false, the message will not
     * be printed. The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (cache.containsKey(message)) {
            int last = cache.get(message);
            if (timestamp - last < 10)
                return false;
        }

        cache.put(message, timestamp);
        return true;
    }
}