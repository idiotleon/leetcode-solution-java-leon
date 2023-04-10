/**
 * https://leetcode.com/problems/design-snake-game/
 * 
 * References:
 *  https://leetcode.com/problems/design-snake-game/discuss/82668/Java-Deque-and-HashSet-design-with-detailed-comments
 */
package com.idiotleon.leetcode.lvl4.lc0353;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class SolutionApproach0Deque {
    private Set<Integer> seen;
    private Deque<Integer> body;
    private int score;
    private int[][] food;
    private int foodIdx;
    private int width, height;

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SolutionApproach0Deque(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        this.seen = new HashSet<Integer>();
        this.body = new LinkedList<Integer>();
        body.offerLast(0);
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        if(score == -1) return -1;
        
        int rowHead = body.peekFirst() / width;
        int colHead = body.peekFirst() % width;
        switch(direction){
            case "U":
                rowHead--;
                break;
            case "D":
                rowHead++;
                break;
            case "L":
                colHead--;
                break;
            default:
                colHead++;
        }
        
        int head = rowHead * width + colHead;
        
        seen.remove(body.peekLast());
        if(rowHead < 0 
            || rowHead == height 
            || colHead < 0 
            || colHead == width 
            || seen.contains(head)) 
                return score = -1;
        
        seen.add(head);
        body.offerFirst(head);
        
        if(foodIdx < food.length && rowHead == food[foodIdx][0] && colHead == food[foodIdx][1]){
            seen.add(body.peekLast());
            foodIdx++;
            return ++score;
        }
        
        body.pollLast();
        return score;
    }
}