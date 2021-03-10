/**
 * https://leetcode.com/problems/number-of-operations-to-make-network-connected/
 * 
 * Time Complexity:     O(n + N * amortized(n)) ~ O(n + L)
 * 
 * Space Complexity:    O(n)
 * 
 * to apply both path compression and union by size
 * 
 * References:
 *  https://leetcode.com/problems/number-of-operations-to-make-network-connected/discuss/477660/Java-Count-number-of-connected-components-Clean-code
 */
package com.an7one.leetcode.lvl3.lc1319;

public class SolutionApproach0UnionFind {
    public int makeConnected(int n, int[][] connections) {
        // sanity check
        if(connections.length < n - 1) return -1;
        
        int[] roots = new int[n];
        int[] size = new int[n];
        for(int i = 0; i < n; i++){
            roots[i] = i;
            size[i] = 1;
        }
        
        int components = n;
        for(int[] connection : connections){
            int root1 = find(roots, connection[0]);
            int root2 = find(roots, connection[1]);
            if(root1 != root2){
                if(size[root1] < size[root2]){
                    size[root2] += size[root1];
                    roots[root1] = root2;
                }else{
                    size[root1] += size[root2];
                    roots[root2] = root1;
                }
                components--;
            }
        }
        
        return components - 1;
    }
    
    private int find(int[] roots, int i){
        if(i == roots[i]) return i;
        return roots[i] = find(roots, roots[i]);
    }
}