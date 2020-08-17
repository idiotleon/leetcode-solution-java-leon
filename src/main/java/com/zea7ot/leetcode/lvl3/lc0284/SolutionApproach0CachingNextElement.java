/**
 * https://leetcode.com/problems/peeking-iterator/
 * 
 * References:
 *  https://leetcode.com/problems/peeking-iterator/discuss/72558/Concise-Java-Solution
 */
package com.zea7ot.leetcode.lvl3.lc0284;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SolutionApproach0CachingNextElement implements Iterator<Integer> {
    private Integer next;
    private Iterator<Integer> iter;
    private boolean noSuchElement;
    
	public SolutionApproach0CachingNextElement(Iterator<Integer> iterator) {
	    // initialize any member here.
	    iter = iterator;
        advancedIter();
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(noSuchElement)
            throw new NoSuchElementException();
        
        Integer res = next;
        advancedIter();
        return res;
	}
	
	@Override
	public boolean hasNext() {
	    return !noSuchElement;
	}
    
    private void advancedIter(){
        if(iter.hasNext())
            next = iter.next();
        else
            noSuchElement = true;
    }
}