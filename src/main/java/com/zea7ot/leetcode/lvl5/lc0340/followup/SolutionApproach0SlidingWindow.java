/**
 * to get the maximum length with at most K distinct characters in a data stream
 * 
 * 
 * NOT yet finished
 */
package com.zea7ot.leetcode.lvl5.lc0340.followup;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0SlidingWindow {
    private Map<Character, DLLNode> map;
    private DoublyLinkedList dll;
    private int index;

    private final int RANGE;
    private final int[] FREQ;
    private int runningLen;
    private int distinct;
    private int longest;

    public SolutionApproach0SlidingWindow(){
        this.map = new HashMap<Character, DLLNode>();
        this.dll = new DoublyLinkedList();
        this.index = 0;
        this.runningLen = 0;
        this.distinct = 0;
        this.longest = 0;

        this.RANGE = '\uFFFF' - '\u0000';
        this.FREQ = new int[RANGE];
    }

    public int lengthOfLongestSubstring(FakeCharAPI api, int k){
        char ch = api.generateAChar();
        lengthOfLongestSubstring(ch, k);
        return longest;
    }

    private void lengthOfLongestSubstring(char ch, int k){
        if(!map.containsKey(ch)) {
            DLLNode newNode = new DLLNode(ch, index);
            map.put(ch, newNode);
            dll.appendToLast(newNode);
            ++runningLen;
            if(++FREQ[ch] == 0) ++distinct;
        }else{
            DLLNode node = map.get(ch);
            node.index = index;
            ++FREQ[ch];
            ++runningLen;
        }

        trimDistinct(k);
        this.longest = Math.max(longest, runningLen);
        this.index++;
    }

    private void trimDistinct(int k){
        while(distinct > k){
            DLLNode node = dll.removeFirst();
            if(node == null) return;
            char ch = node.ch;
            if(--FREQ[ch] == 0) --distinct;
            int lastIdx = node.index;
            // ?
            runningLen -= lastIdx;
            node.index = index;
            dll.appendToLast(node);
            // no need to touch `map` at all
        }
    }

    private class DoublyLinkedList{
        protected DLLNode dummyHead;
        protected DLLNode dummyTail;

        protected DoublyLinkedList(){
            this.dummyHead = new DLLNode(null, -1);
            this.dummyTail = new DLLNode(null, -1);

            dummyHead.next = dummyTail;
            dummyTail.prev = dummyTail;
        }

        protected DLLNode removeFirst(){
            DLLNode node = dummyHead.next;
            if(node == dummyTail) return null;
            return remove(node);
        }

        protected DLLNode remove(DLLNode node){
            if(node == dummyHead || node == dummyTail) return null;
            DLLNode prev = node.prev, next = node.next;
            prev.next = next;
            next.prev = prev;
            return node;
        }

        protected void appendToLast(DLLNode node){
            DLLNode prev = dummyTail.prev;
            prev.next = node;
            node.prev = prev;
            node.next = dummyTail;
            dummyTail.prev = node;
        }
    }

    private class DLLNode{
        protected int index;
        protected Character ch;
        protected DLLNode prev;
        protected DLLNode next;

        protected DLLNode(Character ch){
            this.ch = ch;
        }

        protected DLLNode(Character ch, int index){
            this(ch);
            this.index = index;
        }
    }
}