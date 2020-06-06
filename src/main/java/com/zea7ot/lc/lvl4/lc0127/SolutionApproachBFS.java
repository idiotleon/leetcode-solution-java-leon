/**
 * https://leetcode.com/problems/word-ladder/
 */
package com.zea7ot.lc.lvl4.lc0127;

import java.util.LinkedList;
import java.util.List;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class SolutionApproachBFS {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        
        Set<String> set = new HashSet<String>(wordList);
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        
        // to count the number of words transformed
        int count = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            
            // for all words in this round
            for(int i = 0; i < size; i++){
                char[] current = queue.poll().toCharArray();
                
                // to traverse the current word
                for(int j = 0; j < current.length; j++){
                    char temp = current[j];
                    
                    // to change one letter at a time
                    for(char c = 'a'; c <= 'z'; c++){
                        current[j] = c;
                        String next = new String(current);
                        
                        // when "next" word is in the set
                        if(set.contains(next)){
                            if(next.equals(endWord)) return count + 1;
                            queue.add(next);
                            set.remove(next);
                        }
                    }
                    
                    // have to undo for the next change of letter
                    current[j] = temp;
                }
            }
            
            // this round ends with one letter changed
            count++;
        }
        
        return 0;
    }
}