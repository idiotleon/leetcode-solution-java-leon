/**
 * 给一个用字符串表示的json，
 * 比如 '{"a": {"b": [{"c": "d"}, {"e": "f"}] }}', 
 * 再给一个input，比如 a.b[1].e，计算输出的结果，
 * 这个例子的话输出结果就是"f"。
 * 
 * assume所有的输入都是合法的
 * 
 * assuming that there are only lower case letters
 */
package com.an7one.bycompany.google.string.parse_json;

// import java.util.ArrayList;
// import java.util.List;

public class SolutionApproach0Trie {
    // private static final char IMPOSSIBLE = '#';

    // private static final char OPEN_BRACKET = '{';
    // private static final char CLOSED_BRACKET = '}';
    // private static final char OPEN_SQUARE_BRACKET = '[';
    // private static final char CLOSED_SQUARE_BRACKET = ']';

    // private static final char COLON = ':';
    // private static final char SPACE = ' ';

    // public String parseString(String json, String input) {

    // }

    // private TrieNode buildeTrie(String json) {
    // final int L = json.length();
    // final char[] CHS = json.toCharArray();

    // TrieNode root = new TrieNode(IMPOSSIBLE);

    // int stack = 0;
    // int stackSquareBracket = 0;
    // int idx = 0;

    // while (idx < L) {
    // TrieNode cur = root;
    // final char CH = CHS[idx];

    // switch (CH) {
    // case COLON:
    // continue;

    // case SPACE:
    // continue;

    // case OPEN_BRACKET:
    // ++stack;
    // break;

    // case CLOSED_BRACKET:
    // if (--stack == 0)
    // cur = root;
    // break;

    // case OPEN_SQUARE_BRACKET:
    // ++stackSquareBracket;
    // break;

    // case CLOSED_SQUARE_BRACKET:
    // --stackSquareBracket;
    // break;

    // default:
    // if (cur.CHILDREN[CH - 'a'] == null)
    // cur.CHILDREN[CH - 'a'] = new TrieNode(CH);

    // cur = cur.CHILDREN[CH - 'a'];
    // break;
    // }

    // ++idx;
    // }

    // return root;
    // }

    // // [{"c":"d"}, {"e":"f"}]"
    // // node: "b"
    // private void dfs(int idxStart, int idxEnd, String json, TrieNode node) {
    // TrieNode cur = node;

    // int stack = 0;

    // }

    // private class TrieNode {
    // private final char CH;
    // private final List<TrieNode> CHILDREN;

    // private TrieNode(final char CH) {
    // this.CH = CH;
    // this.CHILDREN = new ArrayList<>();
    // }
    // }
}
