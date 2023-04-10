/**
 * 判断给定一个key和一个lyrics，能不能用lyrics中的字母组成key
 * 要求key中的每一个字母出现在不同的单词中
 * All lowerletters 
 * 
 * Example:
 * boom, 和 Best applicatiOn On Mainland china
 */
package com.idiotleon.bycompany.google.string.two_ptr;

public class SolutionSongAndLyric {
    public boolean canBeFound(String song, String lyric){
        // sanity check
        if(song == null || song.isEmpty() || lyric == null || lyric.isEmpty()) return false;

        final int S = song.length(), L = lyric.length();
        int i = 0, j = 0;
        while(i < S && j < L){
            if(song.charAt(i) == lyric.charAt(j)){
                i++;
                if(i == S - 1) return true;
                j++;
            }else{
                j++;
            }
        }

        return false;
    }
}