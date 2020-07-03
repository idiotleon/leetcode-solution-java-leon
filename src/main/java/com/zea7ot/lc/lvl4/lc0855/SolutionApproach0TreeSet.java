/**
 * https://leetcode.com/problems/exam-room/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/exam-room/discuss/139885/Java-Solution-based-on-treeset
 */
package com.zea7ot.lc.lvl4.lc0855;

import java.util.Iterator;
import java.util.TreeSet;

public class SolutionApproach0TreeSet {
    private int N;
    private TreeSet<Integer> set;

    public SolutionApproach0TreeSet(int N) {
        this.N = N;
        this.set = new TreeSet<Integer>();
    }
    
    public int seat() {
        // where there is no student
        if(set.isEmpty()){
            set.add(0);
            return 0;
        }
        
        // where there is one student
        if(set.size() == 1){
            int num = set.first();
            if(num < (N / 2)){
                set.add(N - 1);
                return N - 1;
            }else{
                set.add(0);
                return 0;
            }
        }
        
        // where there are more than one student
        Iterator<Integer> iterator = set.iterator();
        int distance = -1;
        int position = -1;
        int left = iterator.next();
        // to check the distance between 0 and first student
        if(left > 0){
            position = 0;
            distance = left;
        }
        
        int right = -1;
        // to check the distance between adjacent indices (already sorted)
        while(iterator.hasNext()){
            right = iterator.next();
            if((right - left) / 2 > distance){
                distance = (right - left) / 2;
                position = left + distance;
            }
            
            left = right;
        }
        
        // to check the distance between the last student and (N - 1)
        if((N - 1) - left > distance){
            position = N - 1;
        }
        
        set.add(position);
        return position;
    }
    
    public void leave(int p) {
        set.remove(p);
    }
}