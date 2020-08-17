/**
 * https://leetcode.com/problems/cut-off-trees-for-golf-event/
 */
package com.zea7ot.leetcode.lvl4.lc0675;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SolutionApproachPQAndBFS {
    private static final int[][] DIRS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    private int nr, nc;
    
    public int cutOffTree(List<List<Integer>> forest) {
        if(forest == null || forest.size() == 0) return 0;
        nr = forest.size();
        nc = forest.get(0).size();
        
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
        
        for(int row = 0; row < nr; row++){
            for(int col = 0; col < nc; col++){
                if(forest.get(row).get(col) > 1){
                    heap.add(new int[]{row, col, forest.get(row).get(col)});
                }
            }
        }
        
        int[] start = new int[2];
        int sum = 0;
        while(!heap.isEmpty()){
            int[] tree = heap.poll();
            int step = minStep(forest, start, tree);
            
            if(step < 0) return -1;
            sum += step;
            
            start[0] = tree[0];
            start[1] = tree[1];
        }
        
        return sum;
    }
    
    private int minStep(List<List<Integer>> forest, int[] start, int[] tree){
        int step = 0;
        boolean[][] visited = new boolean[nr][nc];
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cur = queue.poll();
                if(cur[0] == tree[0] && cur[1] == tree[1]) return step;
                
                for(int[] dir : DIRS){
                    int r = cur[0] + dir[0], c = cur[1] + dir[1];
                    if(r < 0 || r >= nr || c < 0 || c >= nc || forest.get(r).get(c) == 0 || visited[r][c]) continue;
                    
                    queue.add(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
            
            ++step;
        }
        
        return -1;
    }
}