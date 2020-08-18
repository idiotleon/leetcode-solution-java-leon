/**
 * https://leetcode.com/problems/random-pick-with-weight/
 * 
 * Time Complexity:     O(lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/random-pick-with-weight/discuss/671445/Question-explained
 */
package com.zea7ot.leetcode.lvl3.lc0528;

public class SolutionApproach0BinarySearch {
    private double[] probabilities;
    
    public SolutionApproach0BinarySearch(int[] weights) {
        final int N = weights.length;
        double sum = 0;
        this.probabilities = new double[N];
        for(int weight : weights){
            sum += weight;
        }
        
        for(int i = 0; i < N; i++){
            weights[i] += (i == 0) ? 0 : weights[i - 1];
            probabilities[i] = weights[i] / sum;
        }
    }
    
    public int pickIndex() {
        return Math.abs(lowerBound(Math.random()));
    }
    
    private int lowerBound(double target){
        int lo = 0, hi = probabilities.length;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            
            if(target > probabilities[mid]) lo = mid + 1;
            else hi = mid;
        }
        
        return lo;
    }
}