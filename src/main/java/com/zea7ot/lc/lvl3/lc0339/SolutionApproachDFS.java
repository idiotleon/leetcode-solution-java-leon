/**
 * https://leetcode.com/problems/nested-list-weight-sum/
 */
package com.zea7ot.lc.lvl3.lc0339;

import java.util.List;

import com.zea7ot.lc.utils.NestedInteger;

public class SolutionApproachDFS {
    private int sum;
    
    public int depthSum(List<NestedInteger> nestedList) {
        this.sum = 0;
        depthSum(nestedList, 1);
        return sum;
    }
    
    private void depthSum(List<NestedInteger> nestedList, int depth){
        for(NestedInteger cur : nestedList){
            if(cur.isInteger()){
                sum += cur.getInteger() * depth;
            }else{
                depthSum(cur.getList(), depth + 1);
            }
        }
    }
}