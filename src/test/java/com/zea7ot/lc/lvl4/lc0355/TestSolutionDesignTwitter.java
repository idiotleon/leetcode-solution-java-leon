package com.zea7ot.lc.lvl4.lc0355;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class TestSolutionDesignTwitter {
    private SolutionDesignTwitter solution = new SolutionDesignTwitter();


    /**
     * ["Twitter","postTweet","getNewsFeed","follow","postTweet","getNewsFeed","unfollow","getNewsFeed"]
     * 
     * [[],[1,5],[1],[1,2],[2,6],[1],[1,2],[1]]
     */
    @Test
    void test1(){
        solution.postTweet(1, 5);
        assertEquals(Arrays.asList(5), solution.getNewsFeed(1));
        
        solution.follow(1, 2);
        solution.postTweet(2, 6);
        assertEquals(Arrays.asList(6,5), solution.getNewsFeed(1)); 

        solution.unfollow(1, 2);
        assertEquals(Arrays.asList(5), solution.getNewsFeed(1));
    }
}