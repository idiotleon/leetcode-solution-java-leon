/**
 * i.e. Fenwick Tree, 
 *  a data structure to efficiently calculate and manipulate 
 *  the prefix sums of a table of values
 * 
 * 
 * References:
 * https://www.youtube.com/watch?v=CWDQJGaN1gY
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/FenwickTree.java
 * https://en.wikipedia.org/wiki/Fenwick_tree
 */
package com.idiotleon.summary.tree.binary_indexed_tree;

public class BinaryIndexedTree {
    /**
     * to construct a Binary Indexed Tree
     * 
     * Time Complexity:     O(N * lg(N)) for the first time
     * Space Complexity:    O(N)
     */
    public int[] constructBinaryIndexedTree(int[] input){
        final int N = input.length;
        int[] binaryIndexedTree = new int[N + 1];
        for(int i = 1; i <= N; i++){
            updateBinaryIndexedTree(binaryIndexedTree, input[i - 1], i);
        }
        return binaryIndexedTree;
    }

    /**
     * to update one element in the Binary Indexed Tree
     * 
     * Time Complexity:     O(lg(N))
     * Space Complexity:    O(1)
     */
    public void updateBinaryIndexedTree(int[] binaryIndexedTree, int val, int index){
        final int N = binaryIndexedTree.length;
        while(index < N){
            binaryIndexedTree[index] += val;
            index = getNext(index);
        }
    }

    /**
     * to get the prefix sum
     * 
     * Time Complexity:     O(lg(N))
     * Space Complexity:    O(1)
     * 
     * @return the prefix sum
     */
    public int getSum(int[] binaryIndexedTree, int index){
        index = index + 1;
        int sum = 0;
        while(index > 0){
            sum += binaryIndexedTree[index];
            index = getParent(index);
        }
        return sum;
    }

    /**
     * to get the next                                  eg. 00000010
     *  1). to get its complement of 2s                     11111101 + 1 = 11111110
     *  2). to Bitwise AND it with the original number      00000010 & 11111110 = 00000010 (2)
     *  3). to add it to the original number                00000010 + 00000010 = 00000100
     * 
     * Time Complexity:     O(1)
     * Space Complexity:    O(1)
     * 
     * @param index
     * @return the next
     */
    private int getNext(int index){
        return index + (index & -index);
    }

    /**
     * to get the parent                                eg. 00001010
     *  1). to get its complement of 2s                     00000101 + 1 = 0110
     *  2). to Bitwise AND it with the original number      00001010 & 00000110 = 00000010
     *  3). to subtract it from the original number         00001010 - 00000010 = 00001000
     * 
     * Time Complexity:     O(1)
     * Space Complexity:    O(1)
     * 
     * @param index
     * @return the parent
     */
    private int getParent(int index){
        return index - (index & -index);
    }
}