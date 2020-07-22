/**
 * https://leetcode.com/problems/edit-distance/
 * 
 * Time Complexity:     O(L1 * L2)
 * Space Complexity:    O(L1 * L2)
 * 
 * References:
 *  https://leetcode.com/problems/edit-distance/discuss/25849/Java-DP-solution-O(nm)
 *  https://leetcode.com/problems/edit-distance/discuss/25849/Java-DP-solution-O(nm)/424626
 *  https://web.stanford.edu/class/cs124/lec/med.pdf
 */
package com.zea7ot.lc.lvl4.lc0072;

public class SolutionApproach0DP2Dimen {
    public int minDistance(String word1, String word2) {
        final int L1 = word1.length(), L2 = word2.length();
        
        int[][] costs = new int[L1 + 1][L2 + 1];
        // to initialize costs(int[][])
        for(int i = 0; i <= L1; ++i) costs[i][0] = i;
        for(int j = 1; j <= L2; ++j) costs[0][j] = j;
        
        for(int i = 0; i < L1; ++i){
            for(int j = 0; j < L2; ++j){
                if(word1.charAt(i) == word2.charAt(j)){
                    costs[i + 1][j + 1] = costs[i][j];
                }else{
                    int replace = costs[i][j];
                    int insert = costs[i][j + 1];
                    int delete = costs[i + 1][j];
                    
                    costs[i + 1][j + 1] = Math.min(replace, Math.min(insert, delete));
                    ++costs[i + 1][j + 1];
                }
            }
        }
        
        return costs[L1][L2];
    }
}