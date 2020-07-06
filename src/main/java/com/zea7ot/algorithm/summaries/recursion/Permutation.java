/**
 * pseudo code:
 *  permutation(depth, used):
 *      if depth == N: return func()
 *      for i in range(0, N):
 *          if i in used: continue
 *          used.add(i)
 *          permutation(depth + 1, used)
 *          used.remove(i)
 * 
 * Time Complexity:
 *  T(N) = N * T(N - 1) = N * (N - 1) * (N - 2) * ... * 1 = O(N!)
 * 
 * Space Complexity:
 *  O(N)
 * 
 * References:
 *  https://www.youtube.com/watch?v=OQi4n8EKRD8
 */
package com.zea7ot.algorithm.summaries.recursion;

public class Permutation {
    
}