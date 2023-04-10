package com.idiotleon.leetcode.lvl3.lc0340.followup;

class FakeCharAPI {
    public char generateAChar(){
        return getRandomCharacter('\u0000', '\uFFFF');
    }

    private char getRandomCharacter(char start, char end){
        return (char)(start + Math.random() * (end - start + 1));
    }
}