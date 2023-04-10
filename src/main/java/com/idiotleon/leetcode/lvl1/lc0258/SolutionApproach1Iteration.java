/**
 * https://leetcode.com/problems/add-digits/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
package com.idiotleon.leetcode.lvl1.lc0258;

public class SolutionApproach1Iteration {
    public int addDigits(int num) {
        while(num >= 10){
            int temp = 0;
            while(num > 0){
                temp += num % 10;
                num /= 10;
            }
            num = temp;
        }
        
        return num;
    }
}