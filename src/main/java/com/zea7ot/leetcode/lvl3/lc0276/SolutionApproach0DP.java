/**
 * https://leetcode.com/problems/paint-fence/
 * 
 * Time Complexity:     O(n)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/paint-fence/discuss/71156/O(n)-time-java-solution-O(1)-space/151116
 *  https://youtu.be/FLbqgyJ-70I?t=1430
 *  https://docs.google.com/presentation/d/1OeA0rsnOrklarLM5G2tHHJ6EE37HpRqD7KedzOqkihk/edit#slide=id.g8285dd8f3f_1_331
 */
package com.zea7ot.leetcode.lvl3.lc0276;

public class SolutionApproach0DP {
    public int numWays(int n, int k) {
        // sanity check
        if(n <= 0) return 0;
        
        // the previous two are of the same color
        int same = 0;
        // the previous two are of the different color
        int diff = k;
        
        for(int i = 1; i < n; i++){
            int temp = same;
            same = diff;
            diff = (temp + diff) * (k - 1);
        }
        
        return same + diff;
    }
}