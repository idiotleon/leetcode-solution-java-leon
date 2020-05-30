/**
 * https://leetcode.com/problems/couples-holding-hands/
 * 
 * Time Complexity:
 * Space Complexity:
 * 
 * References:
 *  https://leetcode.com/problems/couples-holding-hands/discuss/113362/JavaC%2B%2B-O(N)-solution-using-cyclic-swapping
 * 
 * Similar Problems:
 *  2   0268    https://leetcode.com/problems/first-missing-positive/
 *  4   0041    https://leetcode.com/problems/first-missing-positive/
 */
package com.polyg7ot.lc.lvl4.lc0765;

public class SolutionApproach0UnionFind {
    public int minSwapsCouples(int[] row) {
        final int N = row.length / 2;
        UnionFind uf = new UnionFind(N);
        for(int i = 0; i < N; i++){
            int a = row[2 * i], b = row[2 * i + 1];
            uf.union(a / 2, b / 2);
        }
        
        return N - uf.getCount();
    }
    
    private class UnionFind{
        private int[] roots;
        private int count;
        
        protected UnionFind(final int N){
            this.roots = new int[N];
            for(int i = 0; i < N; i++){
                roots[i] = i;
            }
            
            this.count = N;
        }
        
        private int find(int i){
            if(i == roots[i]) return i;
            return roots[i] = find(roots[i]);
        }
        
        public void union(int i, int j){
            int a = find(i), b = find(j);
            if(a != b){
                roots[b] = a;
                count--;
            }
        }
        
        public int getCount(){
            return count;
        }
    }
}