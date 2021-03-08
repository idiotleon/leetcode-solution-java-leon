package com.zea7ot.summary.search.zigzag_search;

public class KthSmallest {
    /**
     * Time Complexity: O(NR * NC)
     * Space Complexity: O(1)
     * 
     * Note that the verification algorithm is based on the following two observations:
     *  There will be at most k - 1 elements in the matrix that are less than the kth smallest element.
     *  There will be at least k elements in the matrix that are less than or equal to the kth smallest element
     * 
     * @param matrix
     * @param k
     * @return
     * 
     * References:
     *  https://leetcode.com/problems/k-th-smallest-prime-fraction/discuss/115819/Summary-of-solutions-for-problems-%22reducible%22-to-LeetCode-378
     */
    public int KthSmallestWithZigzagSearch(int[][] matrix, int k){
        final int NR = matrix.length, NC = matrix[0].length;

        // to start from the upper-right corner
        int row = 0, col = NC - 1;

        while(true){
            int countLessAndEqual = 0, countLessThan = 0;
            for(int i = 0, j = NC - 1, p = NC - 1; i < NR; i++){
                while(j >= 0 && matrix[i][j] > matrix[row][col]) j--;   // pointer j to count "countLessAndEqual"
                countLessAndEqual += (j + 1);

                while(p >= 0 && matrix[i][p] >= matrix[row][col]) p--;  // pointer p to count "countLessThan"
                countLessThan += (p + 1);
            }

            if(countLessAndEqual < k) row++;    // candidate is too small, so should increase it
            else if(countLessThan >= k) col--;  // candidate is too large, so should decrease it
            else return matrix[row][col];       // candidate is equal to the kth smallest element
        }
    }
}