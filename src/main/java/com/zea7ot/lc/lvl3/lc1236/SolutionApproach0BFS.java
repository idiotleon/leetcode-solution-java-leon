/**
 * https://leetcode.com/problems/web-crawler/
 * 
 * Time Complexity:     O(n)
 * Space Complexity:    O(n)
 * 
 * References:
 *  https://leetcode.com/problems/web-crawler/discuss/409952/JAVA-BFS
 */
package com.zea7ot.lc.lvl3.lc1236;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class SolutionApproach0BFS {
    public List<String> crawl(String startUrl, FakeHtmlParser htmlParser) {
        Set<String> seen = new HashSet<String>();
        String hostname = getHostname(startUrl);
        
        Queue<String> queue = new LinkedList<String>();
        queue.offer(startUrl);
        seen.add(startUrl);
        
        while(!queue.isEmpty()){
            String top = queue.poll();
            for(String url : htmlParser.getUrls(top)){
                if(url.contains(hostname) && ! seen.contains(url)){
                    queue.offer(url);
                    seen.add(url);
                }
            }
        }
        
        return new ArrayList<String>(seen);
    }
    
    private String getHostname(String url){
        return url.split("/")[2];
    }
}