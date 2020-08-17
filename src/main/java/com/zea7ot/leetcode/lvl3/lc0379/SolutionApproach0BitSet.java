/**
 * https://leetcode.com/problems/design-phone-directory/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/design-phone-directory/discuss/85335/Java-AC-solution-with-Bitset-and-efficient-get()-+-comments/120445
 */
package com.zea7ot.leetcode.lvl3.lc0379;

import java.util.BitSet;

public class SolutionApproach0BitSet {
    private final BitSet bitSet;
    private final int N;

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public SolutionApproach0BitSet(int maxNumbers) {
        this.N = maxNumbers;
        this.bitSet = new BitSet(N);
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        int num = bitSet.nextClearBit(0);
        if(num == N) return -1;
        bitSet.flip(num);
        return num;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !bitSet.get(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        bitSet.clear(number);
    }
}