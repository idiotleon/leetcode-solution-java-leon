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
import java.util.Random;

public class SolutionApproach0Hashmap {
    private Map<Integer, String> map = new HashMap<Integer, String>();
    private static final String TINY_URL = "http://tinyurl.com/";
    private Random rand = new Random();
    int key = rand.nextInt(10_000);

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        while (map.containsKey(key)) {
            key = rand.nextInt(10_000);
        }
        map.put(key, longUrl);
        return TINY_URL + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace(TINY_URL, "")));
    }
}