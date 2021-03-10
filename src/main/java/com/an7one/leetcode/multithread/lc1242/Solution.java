/**
 * https://leetcode.com/problems/web-crawler-multithreaded/
 * 
 * References:
 *  https://leetcode.com/problems/web-crawler-multithreaded/discuss/427435/Java-Solution-from-MonoThread-(78)-to-MultiThread-(2ms)-beats-100-time-and-100-space
 */
package com.an7one.leetcode.multithread.lc1242;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Solution {
    public List<String> crawl(String startUrl, FakeHtmlParser htmlParser) {
        int index = startUrl.indexOf("/", 7);
        String hostname = (index != -1) ? startUrl.substring(0, index) : startUrl;
        
        Crawler crawler = new Crawler(startUrl, hostname, htmlParser);
        Crawler.MAP = new ConcurrentHashMap<String, String>();
        Crawler.SEEN = ConcurrentHashMap.newKeySet();
        Thread thread = new Thread(crawler);
        thread.start();
        
        Crawler.joinThread(thread);
        return new ArrayList<String>(Crawler.SEEN);
    }
}

class Crawler implements Runnable{
    protected String startUrl;
    protected String hostname;
    protected FakeHtmlParser htmlParser;
        
    protected static ConcurrentHashMap<String, String> MAP = new ConcurrentHashMap<String, String>();
    protected static Set<String> SEEN = ConcurrentHashMap.newKeySet();
        
    protected Crawler(String startUrl, String hostname, FakeHtmlParser htmlParser){
        this.startUrl = startUrl;
        this.hostname = hostname;
        this.htmlParser = htmlParser;
    }
        
     @Override
    public void run(){
        if(this.startUrl.startsWith(hostname) && !SEEN.contains(this.startUrl)){
            SEEN.add(this.startUrl);
            List<Thread> threads = new ArrayList<Thread>();
            for(String str : htmlParser.getUrls(startUrl)){
                if(SEEN.contains(str)) continue;
                Crawler crawler = new Crawler(str, hostname, htmlParser);                    
                Thread thread = new Thread(crawler);
                thread.start();
                threads.add(thread);
            }
            
            threads.forEach(thread -> joinThread(thread));
        }
    }
    
    protected static void joinThread(Thread thread){
        try{
            thread.join();
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }
}