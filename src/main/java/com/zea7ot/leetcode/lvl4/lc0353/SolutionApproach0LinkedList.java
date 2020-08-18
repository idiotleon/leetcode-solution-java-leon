/**
 * https://leetcode.com/problems/design-snake-game/
 * 
 * References:
 *  https://leetcode.com/problems/design-snake-game/discuss/82668/Java-Deque-and-HashSet-design-with-detailed-comments/185647
 */
package com.zea7ot.leetcode.lvl4.lc0353;

import java.util.LinkedList;

public class SolutionApproach0LinkedList {
    private int width, height;
    private int[][] food;
    
    private int len;
    private LinkedList<Point> snake;

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SolutionApproach0LinkedList(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        
        this.len = 0;
        this.snake = new LinkedList<Point>();
        snake.addFirst(new Point(0, 0));
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        Point head = snake.getFirst();
        Point newHead = new Point(head.row, head.col);
        Point tail = snake.removeLast();
        
        switch(direction){
            case "U":
                newHead.row--;
                break;
            case "D":
                newHead.row++;
                break;
            case "L":
                newHead.col--;
                break;
            default:
                newHead.col++;
        }
        
        if(newHead.row < 0 
           || newHead.row == height 
           || newHead.col < 0 
           || newHead.col == width 
           || snake.contains(newHead)) 
            return -1;
        
        snake.addFirst(newHead);
        
        if(len < food.length 
           && food[len][0] == newHead.row 
           && food[len][1] == newHead.col){
            snake.addLast(tail);
            len++;
        }
        
        return len;
    }
    
    private class Point{
        protected int row, col;
        protected Point(int row, int col){
            this.row = row;
            this.col = col;
        }
        
        @Override
        public boolean equals(Object o){
            if(o instanceof Point){
                return ((Point)o).row == row && ((Point)o).col == col;
            }
            return false;
        }
    }
}