/**
 * https://leetcode.com/problems/video-stitching/
 * 
 * Time Complexity: O(nlgn)
 * Space Complexity: O(n) / O(1)
 * 
 * To sort clips by starting time, 
 * to find the clip with maximum end time w.r.t. (clips[i][0] <= lastIndex),
 * and extend the tape to clips[i][1]
 * 
 * https://youtu.be/G88X89Eo2C0?t=287
 * 
 */
package main.java.lcidiot.lc.lvl4.lc1024;

import java.util.Arrays;

public class SolutionApproachGreedy {
    public int videoStitching(int[][] clips, int T) {
        // sanity check
        if(clips == null || clips.length == 0) return -1;
        
        Arrays.sort(clips, (c1, c2) -> Integer.compare(c1[0], c2[0]));
        
        int ans = 0;
        // the current video clip
        int i = 0;
        // the previous video clip
        int left = 0;
        // the end of latest/newest video clip
        int end = 0;
        while(end < T){
            // to extend to the rightmost, w.r.t. clips[i][0] <= left
            while(i < clips.length && clips[i][0] <= left){
                end = Math.max(end, clips[i++][1]);
            }
            
            if(left == end) return -1;  // the situation where it cannot be extended
            // to reset the previous video clip
            left = end;
            ++ans;
        }
        
        return ans;
    }
}