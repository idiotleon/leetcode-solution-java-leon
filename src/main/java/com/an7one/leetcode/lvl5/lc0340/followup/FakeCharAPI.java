package com.an7one.leetcode.lvl5.lc0340.followup;

class FakeCharAPI {
    public char generateAChar(){
        return getRandomCharacter('\u0000', '\uFFFF');
    }

    private char getRandomCharacter(char start, char end){
        return (char)(start + Math.random() * (end - start + 1));
    }
}