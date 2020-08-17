/**
 * https://leetcode.com/problems/the-skyline-problem/
 * 
 * Time Complexity:     O(N)
 *  Recurrence Relation:    T(n) = 2T(n / 2) + 1
 * 
 * Space Complexity:    O(lg(N)) + O(N)
 *  O(lg(N)), consumed by the call stacks
 *  O(N), consumed by the answer List
 * 
 * References:
 *  https://leetcode.com/problems/the-skyline-problem/discuss/61281/Java-divide-and-conquer-solution-beats-96/188836
 *  https://leetcode.com/problems/the-skyline-problem/discuss/61281/Java-divide-and-conquer-solution-beats-96
 */
package com.zea7ot.leetcode.lvl4.lc0218;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SolutionApproach0DivideAndConquer {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // sanity check
        if(buildings == null || buildings.length == 0 || buildings[0].length == 0) return ans;
        
        final int N = buildings.length;
        return findSkyline(buildings, 0, N - 1);
    }
    
    private LinkedList<List<Integer>> findSkyline(int[][] buildings, int lo, int hi){
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        if(lo > hi) return res;
        if(lo == hi){
            res.add(Arrays.asList(buildings[lo][0], buildings[lo][2]));
            res.add(Arrays.asList(buildings[lo][1], 0));
            return res;
        }
        
        int mid = lo + (hi - lo) / 2;
        LinkedList<List<Integer>> left = findSkyline(buildings, lo, mid);
        LinkedList<List<Integer>> right = findSkyline(buildings, mid + 1, hi);
        int leftH = 0, rightH = 0;
        
        while(!left.isEmpty() && !right.isEmpty()){
            int x1 = left.peekFirst().get(0);
            int x2 = right.peekFirst().get(0);
            int x = Math.min(x1, x2);
            if(x1 < x2){
                leftH = left.pollFirst().get(1);
            }else if(x1 > x2){
                rightH = right.pollFirst().get(1);
            }else{
                leftH = left.pollFirst().get(1);
                rightH = right.pollFirst().get(1);
            }
            
            int h = Math.max(leftH, rightH);
            if(res.isEmpty() || h != res.peekLast().get(1)){
                res.add(Arrays.asList(x, h));
            }
        }
        
        if(!left.isEmpty()) res.addAll(left);
        if(!right.isEmpty()) res.addAll(right);
        return res;
    }
}