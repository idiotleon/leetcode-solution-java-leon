/**
 * pseudo code:
 *  inorder(root):
 *      inorder(root.left)
 *      func(root.val)
 *      inorder(root.right)
 * 
 * Time Complexity:
 *  T(N) = 2 * T(N / 2) + O(1) = O(N), for a perfect binary tree
 *  T(N) = T(N - 1) + T(1) + O(1) = O(N), in the worst case
 * 
 * Space Complexity:
 *  O(lg(N))    for a perfect binary tree
 *  O(N)        in the worst case
 * 
 * 
 * 
 * References:
 *  https://www.youtube.com/watch?v=OQi4n8EKRD8
 */
package com.zea7ot.algorithm.summary.traversal;

public class InorderTraversal {
    
}