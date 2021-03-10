/**
 * https://leetcode.com/problems/kth-ancestor-of-a-tree-node/
 * 
 * Time Complexities:
 *  O(N * lg(N))
 *  `getKthAncestor()`, O(lg(N))
 *  
 * Space Complexity:    O()
 * 
 * 
 * dynamic programming + binary search
 * 
 * dp state:
 *  dp[i][j], the j-th node's (2 ^ i)-th ancestor in the path
 * dp init:
 *  dp[0][j], the first parent (2 ^ 0) of each node given
 * dp transition:
 *  dp[i][j] = dp[i - 1][dp[i - 1][j]]
 *      find(j, 2 ^ i) = find(find(j, 2 ^ i - 1), 2 ^ i - 1)
 *      to find the (2 ^ i)-th ancestor of j, to recrusively find the 2 ^(i - 1)-th ancestor of j-th node.
 *      (2 ^ i = 2 ^ (i - 1) + 2 ^ (i - 1))
 * 
 * References:
 *  https://leetcode.com/problems/kth-ancestor-of-a-tree-node/discuss/686362/JavaC++Python-Binary-Lifting/600538
 *  https://leetcode.com/problems/kth-ancestor-of-a-tree-node/discuss/686362/JavaC%2B%2BPython-Binary-Lifting
 */
package com.an7one.leetcode.lvl5.lc1483;

public class SolutionApproach0BinaryLifting {
    private int[][] dp;
    private final int MAX_POWER;

    /**
     * to build up `dp`
     * 
     * Time Complexity:     O(N * lg(N))
     * 
     * @param n
     * @param parent
     */
    public SolutionApproach0BinaryLifting(int n, int[] parent) {
        // 
        this.MAX_POWER = (int)(Math.log(n) / Math.log(2)) + 1;
        // to initialize `dp`
        this.dp = new int[MAX_POWER][n];
        dp[0] = parent;
        
        // to build up `dp` by transition
        for(int i = 1; i < MAX_POWER; i++){
            for(int j = 0; j < n; j++){
                // the (2 ^ (i - 1))-th ancestor of j-th node
                int ancestor = dp[i - 1][j];
                // no more ancestors in 1/2 step
                if(ancestor == -1) dp[i][j] = -1;
                // the (2 ^ (i -1))-th ancestor of the (2 ^ (i - 1))-th ancestor of the j-th node
                else dp[i][j] = dp[i - 1][ancestor];
            }
        }
    }
    
    /**
     * to binary search 
     * 
     * Time Complexity:     O(lg(N))
     * 
     * @param node
     * @param k
     * @return
     */
    public int getKthAncestor(int node, int k) {
        int curPower = this.MAX_POWER; // base 2
        while(k > 0 && node >= 0){
            // to try steps from 2 ^ (MAX_POWER), 2 ^ (MAX_POWER - 1), ...
            if(k >= (1 << curPower)){
                node = dp[curPower][node];
                k -= (1 << curPower);
            }else curPower -= 1; // to take the smaller step
        }
        return node;
    }
}