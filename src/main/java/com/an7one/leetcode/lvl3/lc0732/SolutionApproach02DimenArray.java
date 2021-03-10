/**
 * https://leetcode.com/problems/design-hashset/
 * 
 * Time Complexities:
 *  add:        O(1)
 *  remove:     O(1)
 *  contains:   O(1)
 * 
 * Space Complexity:    O(1000 * 1000)
 * 
 * References:
 *  https://leetcode.com/problems/design-hashset/discuss/143434/Beats-100-Real-Java-Solution-(Not-boolean-array)
 */
package com.an7one.leetcode.lvl3.lc0732;

public class SolutionApproach02DimenArray {
    private static final int MOD = 1000;
    private boolean[][] table;

    /** Initialize your data structure here. */
    public SolutionApproach02DimenArray() {
        this.table = new boolean[MOD][];
    }
    
    public void add(int key) {        
        if(table[getRow(key)] == null){
            table[getRow(key)] = new boolean[MOD];
        }
        table[getRow(key)][getCol(key)] = true;
    }
    
    public void remove(int key) {
        if(table[getRow(key)] != null){
            table[getRow(key)][getCol(key)] = false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return table[getRow(key)] != null && table[getRow(key)][getCol(key)];
    }
    
    private int getRow(int key){
        return key % MOD;
    }
    
    private int getCol(int key){
        return key / MOD;
    }
}