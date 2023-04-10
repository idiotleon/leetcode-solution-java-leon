package com.idiotleon.leetcode.lvl4.lc1483;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
public class SolutionTestApproach1ControlledDFSMemo {
    private SolutionApproach1ControlledDFSMemo solution;
    
    @Test
    void test1(){
        final int N = 7;
        final int[] PARENTS = {-1, 0, 0, 1, 1, 2, 2};
        solution = new SolutionApproach1ControlledDFSMemo(N, PARENTS);

        assertEquals(1, solution.getKthAncestor(3, 1));
        assertEquals(0, solution.getKthAncestor(5, 2));
        assertEquals(-1, solution.getKthAncestor(6, 3));
    }


    /**
     * 
     * ["TreeAncestor","getKthAncestor","getKthAncestor","getKthAncestor","getKthAncestor","getKthAncestor"]
     * [[5,[-1,0,0,0,3]],[1,5],[3,2],[0,1],[3,1],[3,5]]
     */
    @Test
    void test2(){
        final int N = 5;
        final int[] PARENTS = {-1,0,0,0,3};

        solution = new SolutionApproach1ControlledDFSMemo(N, PARENTS);

        assertEquals(-1, solution.getKthAncestor(1, 5));
        assertEquals(-1, solution.getKthAncestor(3, 2));
        assertEquals(-1, solution.getKthAncestor(0, 1));
        assertEquals(0, solution.getKthAncestor(3, 1));
        assertEquals(-1, solution.getKthAncestor(3, 5));
    }

    /**
     * ["TreeAncestor","getKthAncestor","getKthAncestor","getKthAncestor","getKthAncestor","getKthAncestor"]
     * [[5,[-1,0,0,1,2]],[3,5],[3,2],[2,2],[0,2],[2,1]]
     */
    @Test
    void test3(){
        final int N = 5;
        final int[] PARENTS = {-1,0,0,1,2};

        solution = new SolutionApproach1ControlledDFSMemo(N, PARENTS);

        assertEquals(-1, solution.getKthAncestor(3, 5));
        assertEquals(0, solution.getKthAncestor(3, 2));
        assertEquals(-1, solution.getKthAncestor(2, 2));
        assertEquals(-1, solution.getKthAncestor(0, 2));
        assertEquals(0, solution.getKthAncestor(2, 1));
    }

    /**
     * ["TreeAncestor","getKthAncestor","getKthAncestor","getKthAncestor","getKthAncestor","getKthAncestor","getKthAncestor","getKthAncestor","getKthAncestor","getKthAncestor","getKthAncestor"]
     * [[10,[-1,0,0,1,2,0,1,3,6,1]],[8,6],[9,7],[1,1],[2,5],[4,2],[7,3],[3,7],[9,6],[3,5],[8,8]]
     */
    @Test
    void test4(){
        final int N = 10;
        final int[] PARENTS = {-1,0,0,1,2,0,1,3,6,1};

        solution = new SolutionApproach1ControlledDFSMemo(N, PARENTS);

        assertEquals(-1, solution.getKthAncestor(3, 5));
        assertEquals(-1, solution.getKthAncestor(9, 7));
        assertEquals(0, solution.getKthAncestor(1, 1));
        assertEquals(-1, solution.getKthAncestor(2, 5));
        assertEquals(0, solution.getKthAncestor(4, 2));
        assertEquals(0, solution.getKthAncestor(7, 3));
        assertEquals(-1, solution.getKthAncestor(3, 7));
        assertEquals(-1, solution.getKthAncestor(9, 6));
        assertEquals(-1, solution.getKthAncestor(3, 5));
        assertEquals(-1, solution.getKthAncestor(8, 8));
    }
}