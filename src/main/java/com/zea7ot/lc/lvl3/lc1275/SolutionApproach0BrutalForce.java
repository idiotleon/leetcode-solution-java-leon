/**
 * https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/discuss/441319/JavaPython-3-Check-rows-columns-and-two-diagonals-w-brief-explanation-and-analysis.
 */
package com.zea7ot.lc.lvl3.lc1275;

public class SolutionApproach0BrutalForce {
    public String tictactoe(int[][] moves) {
        int[] aRow = new int[3], aCol = new int[3];
        int[] bRow = new int[3], bCol = new int[3];
        int aDiagonal = 0, aAntiDiagonal = 0;
        int bDiagonal = 0, bAntiDiagonal = 0;
        
        final int N = moves.length;
        for(int i = 0; i < N; i++){
            int row = moves[i][0], col = moves[i][1];
            if(i % 2 == 1){
                if(++bRow[row] == 3 
                   || ++bCol[col] == 3 
                   || row == col && ++bDiagonal == 3 
                   || row + col == 2 && ++bAntiDiagonal == 3) 
                    return "B";
            }else{
                if(++aRow[row] == 3 
                   || ++aCol[col] == 3 
                   || row == col && ++aDiagonal == 3 
                   || row + col == 2 && ++aAntiDiagonal == 3) 
                    return "A";
            }
        }
        
        return N == 9 ? "Draw" : "Pending";
    }
}