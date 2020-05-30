/**
 * https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
 * 
 * Time Complexity: O((N ^ 2) * lg(N))
 * Space Complexity: O(N)
 * 
 * Really like the use of indexes, in stones(int[][]), identifying actual stones/elements
 * 
 * References:
 *  https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/discuss/197693/Java-Union-Find/299524
 */
package com.polyg7ot.lc.lvl4.lc0947;

public class SolutionApproach0UnionFind {
    public int removeStones(int[][] stones) {
        // sanity check
        if(stones == null || stones.length == 0) return 0;

        final int N = stones.length;
        int[] roots = new int[N];
        for(int i = 0; i < N; i++){
            roots[i] = i;
        }
        
        for(int i = 0; i < N - 1; i++){
            for(int j = i + 1; j < N; j++){
                int[] stone1 = stones[i], stone2 = stones[j];
                
                if(stone1[0] == stone2[0] 
                   || stone1[1] == stone2[1]){
                    int root1 = find(roots, i), root2 = find(roots, j);
                    roots[root2] = root1;
                }
            }
        }
        
        int count = 0;
        for(int i = 0; i < N; i++){
            if(roots[i] == i) count++;
        }
        
        return N - count;
    }
    
    private int find (int[] roots, int x) {
        if(x == roots[x]) return x;
        return roots[x] = find(roots, roots[x]);
    }
}