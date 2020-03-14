/**
 * https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/
 */

package main.java.lcidiot.lc0801;

class Solution{
    public int minSwap(int[] A, int[] B) {
        int N = A.length;
        int[] swap = new int[N], notSwap = new int[N];
        swap[0] = 1;
        // can be omitted
        // notSwap[0] = 0;
        
        for(int i = 1; i < N; i++){
            notSwap[i] = swap[i] = N;
            if(A[i - 1] < A[i] && B[i - 1] < B[i]){
                notSwap[i] = notSwap[i - 1];
                swap[i] = swap[i - 1] + 1;
            }
            
            if(A[i - 1] < B[i] && B[i - 1] < A[i]){
                notSwap[i] = Math.min(notSwap[i], swap[i - 1]);
                swap[i] = Math.min(swap[i], notSwap[i - 1] + 1);
            }
        }
        
        return Math.min(swap[N - 1], notSwap[N - 1]);
    }
}