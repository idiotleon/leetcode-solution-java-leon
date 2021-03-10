/**
 * https://leetcode.com/problems/web-crawler/
 * 
 * Time Complexity:     O(n)
 * Space Complexity:    O(n)
 * 
 * References:
 *  https://leetcode.com/problems/web-crawler/discuss/409952/JAVA-BFS/369756
 *  https://leetcode.com/problems/web-crawler/discuss/409952/JAVA-BFS
 */
package com.an7one.leetcode.lvl3.lc1236;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionApproach0DFSRecursive {
    public List<String> crawl(String startUrl, FakeHtmlParser htmlParser) {
        final String HOST_NAME = parseHostname(startUrl);
        Set<String> seen = new HashSet<>();
        seen.add(startUrl);
        dfs(startUrl, HOST_NAME, htmlParser, seen);
        return new ArrayList<>(seen);
    }

    private void dfs(String curUrl, String hostname, FakeHtmlParser htmlParser, Set<String> seen) {
        for (String url : htmlParser.getUrls(curUrl)) {
            if (url.contains(hostname) && seen.add(url)) {
                dfs(url, hostname, htmlParser, seen);
            }
        }
    }

    private String parseHostname(String url) {
        return url.split("/")[2];
    }
}