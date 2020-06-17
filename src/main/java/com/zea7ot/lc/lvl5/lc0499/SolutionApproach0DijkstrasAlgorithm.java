/**
 * https://leetcode.com/problems/the-maze-iii/
 * 
 * Time Complexity:     O(V + Elg(V)) ~ 
 * Space Compelxity:    O(Elg(V)) ~ 
 * 
 * References:
 *  https://leetcode.com/problems/the-maze-iii/discuss/97831/Shortclean-and-straight-forward-BFS-solution-with-PriorityQueue
 */
package com.zea7ot.lc.lvl5.lc0499;

import java.util.PriorityQueue;

public class SolutionApproach0DijkstrasAlgorithm {
    private static final int[][] DIRS = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
    // to strictly align with DIRS(int[][])
    private static final char[] MOVES = {'d', 'l', 'r', 'u'};
    
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        final int M = maze.length, N = maze[0].length;
        boolean[][] visited = new boolean[M][N];
        
        PriorityQueue<Coordinate> minHeap = new PriorityQueue<Coordinate>();
        minHeap.offer(new Coordinate(ball[0], ball[1], 0, ""));
        
        while(!minHeap.isEmpty()){
            Coordinate cur = minHeap.poll();
            
            if(cur.row == hole[0] && cur.col == hole[1])
                return cur.moves;
            
            if(visited[cur.row][cur.col]) continue;
            visited[cur.row][cur.col] = true;
            
            for(int d = 0; d < 4; d++){
                Coordinate next = moveForward(maze, cur, d, hole);
                minHeap.offer(new Coordinate(next.row, next.col, next.distance, next.moves + MOVES[d]));
            }
        }
        
        return "impossible";
    }
    
    /**
     * to move from the currently given position,
     *  and move in the currently given direction,
     *  until hitting a wall
     * 
     * @param maze
     * @param cur
     * @param direction
     * @param hole
     * @return the last position/coordinate of the ball right before hitting the wall
     */
    private Coordinate moveForward(int[][] maze, Coordinate cur, int direction, int[] hole){
        final int M = maze.length, N = maze[0].length;
        int row = cur.row, col = cur.col, distance = cur.distance;
        while(row >= 0 && row < M && col >= 0 && col < N && maze[row][col] == 0){
            row += DIRS[direction][0];
            col += DIRS[direction][1];
            distance++;
            if(row == hole[0] && col == hole[1]){
                return new Coordinate(row, col, distance, cur.moves);
            }
        }
        
        // to move one step back from the wall
        row -= DIRS[direction][0];
        col -= DIRS[direction][1];
        distance--;
        return new Coordinate(row, col, distance, cur.moves);
    }
    
    private class Coordinate implements Comparable<Coordinate>{
        protected int row, col, distance;
        protected String moves;
        
        protected Coordinate(int row, int col, int distance, String moves){
            this.row = row;
            this.col = col;
            this.distance = distance;
            this.moves = moves;
        }
        
        // @Override
        public int compareTo(Coordinate that){
            if(this.distance == that.distance) 
                return this.moves.compareTo(that.moves);
            return this.distance - that.distance;
        }
    }
}