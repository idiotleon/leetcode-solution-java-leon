/**
 * https://leetcode.com/problems/minimize-max-distance-to-gas-station/
 * 
 * Time Complexity: O(N * lg(M))
 *  N, number of stations
 *  M, search range, stations[N - 1] - stations[0]
 * 
 * Space Complexity: O(1)
 * 
 * References:
 *  https://leetcode.com/problems/minimize-max-distance-to-gas-station/discuss/113633/C%2B%2BJavaPython-Binary-Search
 *  https://leetcode.com/problems/minimize-max-distance-to-gas-station/discuss/113633/C++JavaPython-Binary-Search/114648
 */
package com.zea7ot.lc.lvl5.lc0774;

public class SolutionApproach0BinarySearch {
    public double minmaxGasDist(int[] stations, int K) {
        final int N = stations.length;
        
        double lo = 0, hi = stations[N - 1] - stations[0];
        
        while(lo + 1e-6 < hi){
            double mid = lo + (hi - lo) / 2;
            int guess = guess(stations, mid);
            
            if(guess > K) lo = mid;
            else hi = mid;
        }
        
        return lo;
        // the same
        // return hi;
    }
    
    private int guess(int[] stations, double guess){
        final int N = stations.length;
        int count = 0;
        for(int i = 0; i < N - 1; i++){
            count += Math.ceil((stations[i + 1] - stations[i]) / guess) - 1;
        }
        return count;
    }
}