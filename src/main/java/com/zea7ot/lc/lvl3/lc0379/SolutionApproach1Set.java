/**
 * https://leetcode.com/problems/design-phone-directory/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/design-phone-directory/discuss/85332/Java-AC-solution-using-LinkedHashSet-clear-code-and-easy-to-understand/117927
 */
package com.zea7ot.lc.lvl3.lc0379;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SolutionApproach1Set {
    private Set<Integer> set;

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public SolutionApproach1Set(int maxNumbers) {
        this.set = new HashSet<Integer>();
        for(int i = 0; i < maxNumbers; i++) set.add(i);
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        Iterator<Integer> iter = set.iterator();
        if(iter.hasNext()){
            int num = iter.next();
            set.remove(num);
            return num;
        }
        return -1;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return set.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        set.add(number);
    }
}