package com.null7ptr.data_structure.linkedlist;

public class ListNodeWithRandomPtr{
    public int val;
    public ListNodeWithRandomPtr random;
    public ListNodeWithRandomPtr next;

    public ListNodeWithRandomPtr(int val){
        this.val = val;
        this.random = null;
        this.next = null;
    }
}