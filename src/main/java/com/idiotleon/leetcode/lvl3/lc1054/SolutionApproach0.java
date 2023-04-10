/**
 * https://leetcode.com/problems/distant-barcodes/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/distant-barcodes/discuss/300394/JavaPython-3-2-easy-codes-w-comments-O(nlogn)-and-O(n)-respectively.
 */
package com.idiotleon.leetcode.lvl3.lc1054;

public class SolutionApproach0 {
    public int[] rearrangeBarcodes(int[] barcodes) {
        final int N = barcodes.length, RANGE = 10_001;
        int maxFreqCode = 0;
        int[] freq = new int[RANGE], ans = new int[N];
        
        for(int barcode : barcodes){
            if(++freq[barcode] > freq[maxFreqCode]){
                maxFreqCode = barcode;
            }
        }
        
        for(int i = 0, j = 0; j < RANGE; ++j){
            int code = j == 0 ? maxFreqCode : j;
            while(freq[code]-- > 0){
                ans[i] = code;
                i = i + 2 < N ? i + 2 : 1;
            }
        }
            
        return ans;
    }
}