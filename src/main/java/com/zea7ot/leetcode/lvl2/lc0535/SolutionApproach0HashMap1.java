/**
 * https://leetcode.com/problems/encode-and-decode-tinyurl/
 */
package com.zea7ot.leetcode.lvl2.lc0535;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0HashMap1 {
    private Map<Integer, String> map = new HashMap<Integer, String>();
    private static final String TINY_URL = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.put(longUrl.hashCode(), longUrl);
        return TINY_URL + longUrl.hashCode();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace(TINY_URL, "")));
    }
}