/**
 * https://leetcode.com/problems/strong-password-checker/
 * 
 * References:
 *  https://leetcode.com/problems/strong-password-checker/discuss/91003/O(n)-java-solution-by-analyzing-changes-allowed-to-fix-each-problem
 */
package com.zea7ot.lc.lvl6.lc0420;

public class Solution {
    public int strongPasswordChecker(String s) {
        final int L = s.length();
        int ans = 0, a = 1, A = 1, d = 1;
        char[] chs = s.toCharArray();
        int[] arr = new int[L];
        
        for(int i = 0; i < L;){
            if(Character.isLowerCase(chs[i])) a = 0;
            if(Character.isUpperCase(chs[i])) A = 0;
            if(Character.isDigit(chs[i])) d = 0;
            
            int j = i;
            while(i < L && chs[i] == chs[j]) i++;
            arr[j] = i - j;
        }
        
        int totalMissing = a + A + d;
        
        if(L < 6) ans += totalMissing + Math.max(0, 6 - (L + totalMissing));
        else{
            int overLen = Math.max(L - 20, 0), leftOver = 0;
            ans += overLen;
            
            for(int k = 1; k < 3; k++){
                for(int i = 0; i < L && overLen > 0; i++){
                    if(arr[i] < 3 || arr[i] % 3 != (k - 1)) continue;
                    arr[i] -= Math.min(overLen, k);
                    overLen -= k;
                }
            }
            
            for(int i = 0; i < L; i++){
                if(arr[i] >= 3 && overLen > 0){
                    int need = arr[i] - 2;
                    arr[i] -= overLen;
                    overLen -= need;
                }
                
                if(arr[i] >= 3) leftOver += arr[i] / 3;
            }
            
            ans += Math.max(totalMissing, leftOver);
        }
        
        return ans;
    }
}