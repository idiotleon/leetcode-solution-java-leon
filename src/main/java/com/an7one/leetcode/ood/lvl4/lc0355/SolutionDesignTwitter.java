/**
 * https://leetcode.com/problems/design-twitter/
 * 
 * Time Complexities:
 *  postTweet:      O(1)
 *  getNewsFeed:    O(total_num(tweets) * lg(total_num(tweets)))
 *      total_num(tweets): all tweets from the user himself/herself, and all his/her followees'
 *  follow:         O(1)
 *  unfollow:       O(1)
 * 
 * Space Complexities:  O(total_num(tweets) + total_num(users)) ~ O(total_num(tweets))
 */
package com.an7one.leetcode.ood.lvl4.lc0355;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class SolutionDesignTwitter {
    private static int timestamp = 0;
    private Map<Integer, User> roster;

    /** Initialize your data structure here. */
    public SolutionDesignTwitter() {
        this.roster = new HashMap<Integer, User>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        roster.putIfAbsent(userId, new User(userId));
        User user = roster.get(userId);

        user.tweets.add(new Tweet(tweetId));
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
     * the news feed must be posted by users who the user followed or by the user
     * herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        if (!roster.containsKey(userId))
            return new ArrayList<Integer>();

        User user = roster.get(userId);
        Set<User> followees = user.followees;

        // to grasp ALL tweets from the user himself/herself, as well as all his/hers
        // followees',
        // and pick the most recent 10
        Queue<Tweet> minHeap = new PriorityQueue<Tweet>((a, b) -> a.time - b.time);

        for (Tweet tweet : user.tweets) {
            minHeap.add(tweet);

            if (minHeap.size() > 10)
                minHeap.poll();
        }

        for (User followee : followees) {
            for (Tweet tweet : followee.tweets) {
                minHeap.add(tweet);

                if (minHeap.size() > 10)
                    minHeap.poll();
            }
        }

        LinkedList<Integer> ans = new LinkedList<Integer>();
        while (!minHeap.isEmpty())
            ans.addFirst(minHeap.poll().tweetId);

        return ans;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a
     * no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId)
            return;
        roster.putIfAbsent(followeeId, new User(followeeId));
        roster.putIfAbsent(followerId, new User(followerId));

        User followee = roster.get(followeeId), follower = roster.get(followerId);
        follower.followees.add(followee);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a
     * no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followeeId == followerId)
            return;
        roster.putIfAbsent(followeeId, new User(followeeId));
        roster.putIfAbsent(followerId, new User(followerId));

        User followee = roster.get(followeeId), follower = roster.get(followerId);
        if (follower.followees.contains(followee)) {
            follower.followees.remove(followee);
        }
    }

    private class User {
        @SuppressWarnings("unused")
        protected int userId;
        protected Set<User> followees;
        protected List<Tweet> tweets;

        protected User(int userId) {
            this.userId = userId;
            this.followees = new HashSet<User>();
            this.tweets = new ArrayList<Tweet>();
        }
    }

    private class Tweet {
        protected int tweetId;
        protected int time;

        protected Tweet(int tweetId) {
            this.tweetId = tweetId;
            this.time = timestamp++;
        }
    }
}