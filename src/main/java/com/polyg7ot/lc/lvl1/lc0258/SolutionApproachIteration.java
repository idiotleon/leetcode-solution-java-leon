/**
 * https://leetcode.com/problems/add-digits/
 */
package com.polyg7ot.lc.lvl1.lc0258;

public class SolutionApproachIteration {
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