/**
 * https://leetcode.com/problems/repeated-dna-sequences/
 * 
 * 
 * Time complexity : O((N - L)L), that is O(N) for the constant L = 10. 
 *  In the loop executed N - L + 1N−L+1 one builds a substring of length L. 
 *  Overall that results in O((N - L)L) time complexity.
 * 
 * Space complexity : O((N - L)L) to keep the hashset, 
 *  that results in O(N) for the constant L = 10.
 */
package main.java.lcidiot.lc0187;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class SolutionApproachTwoSets {
    public List<String> findRepeatedDnaSequences(String s) {
        final int L = 10, N = s.length();
        HashSet<String> seen = new HashSet<String>(), output = new HashSet<String>();
        
        // to iterate over all sequences of length L
        for(int start = 0; start < N - L + 1; ++start){
            String temp = s.substring(start, start + L);
            if(seen.contains(temp)) output.add(temp);
            seen.add(temp);
        }
        
        return new ArrayList<String>(output);
    }
}