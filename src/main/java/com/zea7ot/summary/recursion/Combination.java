/**
 * pseudo code:
 *  combination(depth, start)
 *      if depth == N: return func()
 *      for i in range(start, N):
 *          combination(depth + 1, i + 1)
 * 
 * 
 * Time Complexity:
 *  T(N) = T(N - 1) + T(N - 2) + ... + T(1) = T(2 ^ N)
 * 
 * Space Complexity:
 *  O(N)
 * 
 * References:
 *  https://www.youtube.com/watch?v=OQi4n8EKRD8
 */
package com.zea7ot.summary.recursion;

public class Combination {
    
}