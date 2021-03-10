/**
 * https://leetcode.com/problems/encode-and-decode-tinyurl/
 * 
 * Time Complexities:
 *  `encode()`:     O()
 *  `decode()`:     O()
 */
package com.an7one.leetcode.ood.lvl2.lc0535;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach1HashMap {
    private Map<Integer, String> map = new HashMap<Integer, String>();
    int count = 0;
    
    final static String TINY_URL = "http://tinyurl.com/";
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.put(count, longUrl);
        return TINY_URL + count++;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace(TINY_URL, "")));
    }
}