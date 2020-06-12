/**
 * https://leetcode.com/problems/count-numbers-with-unique-digits/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/count-numbers-with-unique-digits/discuss/83054/Backtracking-solution/263656
 */
package com.zea7ot.lc.lvl3.lc0357;

public class SolutionApproach0Backtrack1 {
    public int countNumbersWithUniqueDigits(int n) {
        if(n > 10) n = 10;
        
        long max = (long) Math.pow(10, n);
        final boolean[] USED = new boolean[10];
        return backtrack(0, max, USED);
    }
    
    private int backtrack(long cur, long max, final boolean[] USED){
        if(cur >= max) return 0;
        
        int count = 1;
        for(int i = 0; i < 10; i++){
            // to skip leading zeros
            if(cur == 0 && i == 0) continue;
            
            if(!USED[i]){
                USED[i] = true;
                count += backtrack(10 * cur + i, max, USED);
                USED[i] = false;
            }
        }
        
        return count;
    }
}