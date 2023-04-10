/**
 * Time Complexity:
 * Space Complexity: O(N)
 * 
 * Problems:
 *  https://leetcode.com/problems/redundant-connection/
 */
package com.idiotleon.summary.union_find;

public class UnionFindLightWeight {
    public int find(int[] parents, int vertex){
        if(parents[vertex] != vertex){
            // path compression
            parents[vertex] = find(parents, parents[vertex]);
        }

        return parents[vertex];
    }
}