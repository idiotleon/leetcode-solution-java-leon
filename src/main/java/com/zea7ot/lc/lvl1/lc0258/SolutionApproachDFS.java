package com.zea7ot.lc.lvl1.lc0258;

public class SolutionApproachDFS {
    public int addDigits(int num) {
        String n = Integer.toString(num);
        if(n.length() == 1) return Integer.parseInt(n);
        
        int sum = 0;
        for(char c : n.toCharArray()){
            sum += Character.getNumericValue(c);
        }
        return addDigits(sum);
    }
}