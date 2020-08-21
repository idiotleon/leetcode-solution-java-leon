/**
 * https://leetcode.com/problems/design-circular-queue/
 * 
 * Time Complexities:   O(1)
 * Space Complexity:    O(`k`)
 * 
 * References:
 *  https://leetcode.com/problems/design-circular-queue/discuss/149420/Concise-Java-using-array
 */
package com.zea7ot.leetcode.ood.lvl2.lc0622;

public class SolutionDesignCircularQueue {
    private final int[] NUMS;
    private final int CAPACITY;
    private int front;
    private int rear;
    private int idx;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public SolutionDesignCircularQueue(int k) {
        this.NUMS = new int[k];
        this.CAPACITY = k;
        this.front = 0;
        this.rear = -1;
        this.idx = 0;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is
     * successful.
     */
    public boolean enQueue(int value) {
        if (isFull())
            return false;
        rear = (rear + 1) % CAPACITY;
        // equivalently
        // if(++rear == CAPACITY) rear = 0;
        NUMS[rear] = value;
        ++idx;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is
     * successful.
     */
    public boolean deQueue() {
        if (isEmpty())
            return false;
        front = (front + 1) % CAPACITY;
        // equivalently
        // if(++front == CAPACITY) front = 0;
        --idx;
        return true;
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
        return idx == CAPACITY;
    }
}