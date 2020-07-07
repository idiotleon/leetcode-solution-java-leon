/**
 * DP with memoization:
 *  Time: (number of subproblems) * (exclusive time to solve each problem)
 *  Space: (max depth of the call stack) * (space used by each subproblem)
 * 
 * Recursion vs DP with memoization:
 * Recursion:
 *  fib(N):
 *      if N < 1: return 0
 *      return fib(N - 1) + fib(N - 2)
 *  Time Complexity:
 *      T(N) = T(N - 1) + T(N - 2) + O(1) = O(2 ^ N) = O(1.618 ^ N)
 * 
 * DP with memoization:
 *  fib(N):
 *      if N < 1: return 0;
 *      if cache[N] > 0: return m[N]
 *      cache[N] = fib(N - 1) + fib(N - 2)
 *      return cache[N]
 *  Time Complexity: O(N)
 *      each subproblem takes O(1) to solve
 *      fib(N) takes O(N) time to solve
 * 
 * Examples:
 *  741
 *  321
 *  https://youtu.be/OQi4n8EKRD8?t=1707
 * 
 * References:
 *  https://www.youtube.com/watch?v=OQi4n8EKRD8
 */
package com.zea7ot.algorithm.summaries.dynamic_programming;

public class DPWithMemoization {
    
}