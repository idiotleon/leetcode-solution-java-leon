/**
 * https://leetcode.com/problems/design-circular-queue/
 * 
 * References:
 *  https://leetcode.com/problems/design-circular-queue/discuss/149420/Concise-Java-using-array
 */
package com.zea7ot.leetcode.lvl2.lc0622;

public class SolutionDesignCircularQueue {
    private final int[] NUMS;
    private int front;
    private int rear;
    private int idx;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public SolutionDesignCircularQueue(int k) {
        this.NUMS = new int[k];
        this.front = 0;
        this.rear = -1;
        this.idx = 0;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(!isFull()){
            rear = (rear + 1) % NUMS.length;
            // equivalently
            // if(++rear == NUMS.length) rear = 0;
            NUMS[rear] = value;
            idx++;
            return true;
        }else return false;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(!isEmpty()){
            front = (front + 1) % NUMS.length;
            // equivalently
            // if(++front == NUMS.length) front = 0;
            idx--;
            return true;
        }else return false;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        return isEmpty() ? -1 : NUMS[front];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        return isEmpty() ? -1 : NUMS[rear];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return idx == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return idx == NUMS.length;
    }
}