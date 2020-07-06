package com.zea7ot.algorithm.summaries.search.biselect_search;
// package com.polyg7ot.algorithm.template.search.biselect_search;

// import java.util.Arrays;

// public class KthSmallest {
//     /**
//      * Time Complexity: O(N)
//      * Space Complexity: O(N)
//      * 
//      * @param matrix
//      * @param k
//      * @return
//      * 
//      * References:
//      *  https://leetcode.com/problems/k-th-smallest-prime-fraction/discuss/115819/Summary-of-solutions-for-problems-%22reducible%22-to-LeetCode-378
//      */
//     public int KthSmallestWithBiSelectSearch(int[][] matrix, int k){
//         public int kthSmallest(int[][] matrix, int k) {
//             final int NR = matrix.length;

//             int[] index = new int[NR];

//             for(int i = 0; i < NR; i++){
//                 index[i] = i;
//             }

//             int[] L = new int[12 * NR];

//             return biselect(matrix, index, k, k, L)[0];
//         }

//         private int[] biselect(int[][] matrix, int[] index, int k1, int k2, int[] L){
//             final int N = index.length;

//             if(N <= 2){
//                 int[] nums = new int[N * N];

//                 for(int i = 0, k = 0; i < N; i++){
//                     for(int j = 0; j < N; j++){
//                         nums[k++] = matrix[index[i]][index[j]];
//                     }
//                 }

//                 Arrays.sort(nums);

//                 return new int[]{nums[k1 - 1], nums[k2 - 1]};
//             }


            
//         }
        
//         private int pick(int[] nums, int left, int right, int k){
//             int[] pos = partition(nums, left, right, medianOfMedians(nums, left, right));
            
//             int p = pos[0], q = pos[1];
            
//             if(q - left < k){
//                 return pick(nums, q, right, k - (q - left));
//             }else if(k <= p - left){
//                 return pick(nums, left, p, k);
//             }else return p;
//         }
        
//         private int[] partition(int[] nums, int left, int right, int pos){
//             int pivot = nums[pos];
//             swap(nums, pos, right - 1);
            
//             int p = left, q = right - 1;
            
//             for(int i = left; i < q;){
//                 if(nums[i] < pivot){
//                     swap(nums, p++, i++);
//                 }else if(nums[i] > pivot){
//                     swap(nums, i, --q);
//                 }else{
//                     i++;
//                 }
//             }
            
//             swap(nums, q++, right - 1);
//             return new int[]{p, q};
//         }
        
//         private int medianOfMedians(int[] nums, int left, int right){
//             if(right - left <= 5) return medianOfFive(nums, left, right);
            
//             int rr = left;
            
//             for(int i = left; i < right; i += 5){
//                 swap(nums, rr++, medianOfFive(nums, i, Math.min(i + 5, right)));
//             }
            
//             return pick(nums, left, rr, (rr - left + 1) / 2);
//         }
        
//         private int medianOfFive(int[] nums, int left, int right){
//             Arrays.sort(nums, left, right);
//             return left + (right - left - 1) / 2;
//         }
        
//         private void swap(int[] nums, int i, int j){
//             int temp = nums[i];
//             nums[i] = nums[j];
//             nums[j] = temp;
//         }
// }