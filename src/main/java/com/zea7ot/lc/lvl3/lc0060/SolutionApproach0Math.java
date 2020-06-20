/**
 * https://leetcode.com/problems/permutation-sequence/
 * 
 * Time Complexity:     O(n)
 * Space Complexity:    O(n)
 * 
 * References:
 *  https://leetcode.com/problems/permutation-sequence/discuss/22508/An-iterative-solution-for-reference/22036
 */
package com.zea7ot.lc.lvl3.lc0060;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Math {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<Integer>();
        int[] factorial = new int[n + 1];
        
        int sum = 1;
        factorial[0] = 1;
        for(int i = 1; i <= n; i++){
            sum *= i;
            factorial[i] = sum;
        }
        
        for(int i = 1; i <= n; i++) nums.add(i);
        
        k--;
        
        StringBuilder builder = new StringBuilder();
        for(int i = n; i > 0; i--){
            int idx = k / factorial[i - 1];
            k = k % factorial[i - 1];
            
            builder.append(nums.get(idx));
            nums.remove(idx);
        }
        
        return builder.toString();
    }
}