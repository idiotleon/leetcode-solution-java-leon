package com.idiotleon.leetcode.lvl3.lc0277;

class FakeAPI {
    protected static int[][] graph = new int[10][10];

    protected static boolean knows(int a, int b){
        return graph[a][b] == 1;
    }
}