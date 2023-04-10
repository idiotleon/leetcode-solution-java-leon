/**
 * https://leetcode.com/problems/web-crawler/
 * 
 * Time Complexity:     O(n)
 * Space Complexity:    O(n)
 * 
 * References:
 *  https://leetcode.com/problems/web-crawler/discuss/409952/JAVA-BFS
 */
package com.idiotleon.leetcode.lvl3.lc1236;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionApproach0BFS {
    public List<String> crawl(String startUrl, FakeHtmlParser htmlParser) {
        Set<String> seen = new HashSet<>();
        final String HOST_NAME = parseHostName(startUrl);

        Deque<String> queue = new ArrayDeque<>();
        queue.offer(startUrl);
        seen.add(startUrl);

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            for (String url : htmlParser.getUrls(cur)) {
                if (!url.contains(HOST_NAME) || !seen.add(url))
                    continue;
                queue.offer(url);
            }
        }

        return new ArrayList<>(seen);
    }

    private String parseHostName(String url) {
        return url.split("/")[2];
    }
}