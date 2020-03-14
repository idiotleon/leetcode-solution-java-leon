/**
 * 305. Number of Islands II
 * 
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water
 * 
 * Example:
 * Input: m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]
 * Output: [1,1,2,3]
 * 
 * Explanation:
 * Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).
 * 
 * 0 0 0
 * 0 0 0
 * 0 0 0
 * 
 * Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
 * 1 0 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 * 
 * Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
 * 1 1 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 * 
 * Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
 * 1 1 0
 * 0 0 1   Number of islands = 2
 * 0 0 0
 * 
 * Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
 * 1 1 0
 * 0 0 1   Number of islands = 3
 * 0 1 0
 * 
 * Follow up:
 * Can you do it in time complexity O(k log mn), where k is the length of the positions?
 */

package main.java.lcidiot.lc0305;

import java.util.List;
import java.util.ArrayList;

class SolutionApproachUnionFind {
    class UnionFind {
        int count;
        int[] parent, rank;
        int[][] board;

        public UnionFind(int m, int n) {
            board = new int[m][n];
            parent = new int[m * n];
            rank = new int[m * n];

            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    rank[r * n + c] = 0;
                }
            }
        }

        public int find(int i) {
            if (parent[i] != i)
                parent[i] = find(parent[i]);
            return parent[i];
        }

        public void union(int x, int y) {
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

        public int getCount() {
            return count;
        }

        public int add(int m, int n, int[] position) {
            int r = position[0], c = position[1];
            if (board[r][c] == 0) {
                board[r][c] = 1;
                ++count;
                parent[r * n + c] = r * n + c;

                if (r - 1 >= 0 && board[r - 1][c] == 1)
                    union(r * n + c, (r - 1) * n + c);

                if (r + 1 < m && board[r + 1][c] == 1)
                    union(r * n + c, (r + 1) * n + c);

                if (c - 1 >= 0 && board[r][c - 1] == 1)
                    union(r * n + c, r * n + c - 1);

                if (c + 1 < n && board[r][c + 1] == 1)
                    union(r * n + c, r * n + c + 1);
            }
            return getCount();
        }
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<Integer>();
        if (positions == null || m == 0)
            return ans;

        UnionFind uf = new UnionFind(m, n);
        for (int[] position : positions)
            ans.add(uf.add(m, n, position));

        return ans;
    }
}