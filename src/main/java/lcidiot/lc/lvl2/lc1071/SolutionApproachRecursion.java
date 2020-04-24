/**
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/
 * 
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/discuss/303781/JavaPython-3-3-codes-each%3A-Recursive-iterative-and-regex-w-brief-comments-and-analysis.
 * 
 * Time Complexity: O(N ^ 2), where N = Math.max(str1.length(), str2.length())
 */
package main.java.lcidiot.lc.lvl2.lc1071;

public class SolutionApproachRecursion {
    public String gcdOfStrings(String str1, String str2) {
        if(str1.length() < str2.length()){
            return gcdOfStrings(str2, str1);
        }else if(!str1.startsWith(str2)){
            return "";
        }else if(str2.isEmpty()){
            return str1;
        }else{
            return gcdOfStrings(str1.substring(str2.length()), str2);
        }
    }
}