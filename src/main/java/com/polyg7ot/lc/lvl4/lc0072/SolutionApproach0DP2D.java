/**
 * https://leetcode.com/problems/edit-distance/
 * 
 * Time Complexity:     O(M * N)
 * Space Complexity:    O(M * N)
 * 
 * References:
 *  https://leetcode.com/problems/edit-distance/discuss/25849/Java-DP-solution-O(nm)
 *  https://leetcode.com/problems/edit-distance/discuss/25849/Java-DP-solution-O(nm)/424626
 *  https://web.stanford.edu/class/cs124/lec/med.pdf
 */
package com.polyg7ot.lc.lvl4.lc0072;

public class SolutionApproach0DP2D {
    public int minDistance(String word1, String word2) {
        final int M = word1.length(), N = word2.length();
        
        int[][] costs = new int[M + 1][N + 1];
        // to initialize costs(int[][])
        // please make sure it is fully initialized
        for(int i = 0; i <= M; i++){
            costs[i][0] = i;
        }
        // please make sure it is fully initialized
        for(int i = 1; i <= N; i++){
            costs[0][i] = i;
        }
        
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(word1.charAt(i) == word2.charAt(j)){
                    costs[i + 1][j + 1] = costs[i][j];
                }else{
                    int replace = costs[i][j];
                    int insert = costs[i][j + 1];
                    int delete = costs[i + 1][j];
                    
                    costs[i + 1][j + 1] = Math.min(replace, Math.min(insert, delete));
                    costs[i + 1][j + 1]++;
                }
            }
        }
        
        return costs[M][N];
    }
}