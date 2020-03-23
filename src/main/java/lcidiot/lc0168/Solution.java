/**
 * https://leetcode.com/problems/excel-sheet-column-title/
 */
package main.java.lcidiot.lc0168;

class Solution {
    public String convertToTitle(int n) {
        String res = "";
        
        while(n != 0){
            char ch = (char)((n - 1) % 26 + 'A');
            n = (n - 1) / 26;
            res = ch + res;
        }
        
        return res;
    }

    public String convertToTitle2(int n) {
        return n == 0 ? "" : convertToTitle((n - 1) / 26) + (char)((n - 1) % 26 + 'A');
    }
}