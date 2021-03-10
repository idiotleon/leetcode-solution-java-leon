/**
 * References:
 *  https://github.com/mission-peace/interview/blob/master/src/com/interview/bits/NextPowerOf2.java
 */
package com.an7one.summary.bit_manipulation;

public class NextPowerOf2 {
    public int nextPowerOf2(int num){
        if(num == 0) return 1;
        if(num > 0 && (num & (num - 1)) == 0) return num;
        while((num & (num - 1)) > 0){
            num = num & (num - 1);
        }

        return num << 1;
    }
}