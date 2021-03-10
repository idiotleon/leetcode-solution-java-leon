/**
 * https://leetcode.com/problems/exam-room/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/exam-room/discuss/139862/C%2B%2BJavaPython-Straight-Forward
 */
package com.an7one.leetcode.lvl4.lc0855;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach1ArrayList {
    private int N;
    private List<Integer> list;

    public SolutionApproach1ArrayList(int N) {
        this.N = N;
        this.list = new ArrayList<Integer>();
    }
    
    public int seat() {
        if(list.isEmpty()){
            list.add(0);
            return 0;
        }
        
        final int SIZE = list.size();
        int distance = Math.max(list.get(0), N - 1 - list.get(SIZE - 1));
        for(int i = 0; i < SIZE - 1; i++){
            distance = Math.max(distance, (list.get(i + 1) - list.get(i)) / 2 );
        }
        if(list.get(0) == distance){
            list.add(0, 0);
            return 0;
        }
        
        for(int i = 0; i < SIZE - 1; ++i){
            if((list.get(i + 1) - list.get(i)) / 2 == distance){
                list.add(i + 1, (list.get(i + 1) + list.get(i)) / 2);
                return list.get(i + 1);
            }
        }
        list.add(N - 1);
        return N - 1;
    }
    
    public void leave(int p) {
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) == p){
                list.remove(i);
            }
        }
    }
}