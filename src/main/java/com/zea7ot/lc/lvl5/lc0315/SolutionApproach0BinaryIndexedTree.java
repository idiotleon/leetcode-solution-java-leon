/**
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 * 
 * Time Complexity:
 * Space Complexity:
 * 
 * References:
 *  https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76674/3-Ways-(Segment-Tree-Binary-Indexed-Tree-Merge-Sort)-clean-Java-code
 */
package com.zea7ot.lc.lvl5.lc0315;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0BinaryIndexedTree {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if(nums == null || nums.length == 0) return ans;
        final int L = nums.length;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int num : nums){
            min = Math.min(min, num);
        }
        
        int[] nums2 = new int[L];
        for(int i = 0; i < L; i++){
            nums2[i] = nums[i] - min + 1;
            max = Math.max(nums2[i], max);
        }
        
        int[] tree = new int[max + 1];
        for(int i = nums2.length - 1; i >= 0; --i){
            ans.add(0, get(nums2[i] - 1, tree));
            update(nums2[i], tree);
        }
        
        return ans;
    }
    
    private int get(int i, int[] tree){
        int num = 0;
        while(i > 0){
            num += tree[i];
            i -= i & (-i);
        }
        
        return num;
    }
    
    private void update(int i, int[] tree){
        while(i < tree.length){
            ++tree[i];
            i += i & (-i);
        }
    }
}