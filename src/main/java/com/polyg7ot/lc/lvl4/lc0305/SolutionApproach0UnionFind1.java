/**
 * https://leetcode.com/problems/number-of-islands-ii/
 * 
 * Time Complexity: O()
 * Space Complexity: O(2 * m * n) ~ O(m * n)
 */
package com.polyg7ot.lc.lvl4.lc0305;

import java.util.List;
import java.util.ArrayList;

public class SolutionApproach0UnionFind1 {
    private static final int[] DIRS = {0, -1, 0, 1, 0};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if (positions == null || m == 0 || n == 0) return ans;

        UnionFind uf = new UnionFind(m, n);
        for (int[] position : positions){
            ans.add(uf.add(m, n, position));
        }

        return ans;
    }

    private class UnionFind {
        protected int count;
        protected int[] parent, rank;
        protected int[][] board;

        protected UnionFind(int m, int n) {
            board = new int[m][n];
            parent = new int[m * n];
            rank = new int[m * n];

            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    rank[row * n + col] = 0;
                }
            }
        }

        protected int find(int i) {
            if (parent[i] != i){
                parent[i] = find(parent[i]);    // path compression
            }
            return parent[i];
        }

        protected void union(int x, int y) {
            int rootx = find(x), rooty = find(y);

            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty])
                    parent[rooty] = rootx;
                else if (rank[rootx] < rank[rooty])
                    parent[rootx] = rooty;
                else {
                    parent[rooty] = rootx;
                    rank[rootx] += 1;
                }

                --count;
            }
        }

        protected int getCount() {
            return count;
        }

        protected int add(int m, int n, int[] position) {
            int row = position[0], col = position[1];
            if (board[row][col] == 0) {
                board[row][col] = 1;
                ++count;
                parent[row * n + col] = row * n + col;
                
                for(int d = 0; d < 4; d++){
                    int r = row + DIRS[d], c = col + DIRS[d + 1];
                    if(r < 0 || r >= m || c < 0 || c >= n || board[r][c] != 1) continue;
                    union(row * n + col, r * n + c);
                }
            }
            
            return getCount();
        }
    }
}