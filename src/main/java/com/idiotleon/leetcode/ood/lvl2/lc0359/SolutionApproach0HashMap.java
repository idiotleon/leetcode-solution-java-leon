/**
 * https://leetcode.com/problems/logger-rate-limiter/
 * 
 * Time Complexity:     O(1)
 * Space Complexity:    O(N)
 *  N, total messages sent in the latest 20 second
 * 
 * References:
 *  https://leetcode.com/problems/logger-rate-limiter/discuss/365306/Simple-Two-HashMap-Solution-with-O(1)-time-and-little-memory
 */
package com.idiotleon.leetcode.ood.lvl2.lc0359;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0HashMap {
    private Map<String, Integer> cacheOld;
    private Map<String, Integer> cacheNew;
    private int latest;

    /** Initialize your data structure here. */
    public SolutionApproach0HashMap() {
        this.cacheOld = new HashMap<String, Integer>();
        this.cacheNew = new HashMap<String, Integer>();

        this.latest = 0;
    }

    /**
     * Returns true if the message should be printed in the given timestamp,
     * otherwise returns false. If this method returns false, the message will not
     * be printed. The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (timestamp >= latest + 20) {
            cacheOld.clear();
            cacheNew.clear();
            latest = timestamp;
        } else if (timestamp >= latest + 10) {
            cacheOld = new HashMap<>(cacheNew);
            cacheNew.clear();
            latest = timestamp;
        }

        if (cacheNew.containsKey(message))
            return false;

        if (cacheOld.containsKey(message)) {
            int last = cacheOld.get(message);
            if (last + 10 > timestamp)
                return false;
        }

        cacheNew.put(message, timestamp);
        return true;
    }
}