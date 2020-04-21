package main.java.lcidiot.data_structure.linkedlist;

public class ListNodeWithRandomPtr extends ListNode{
    public ListNodeWithRandomPtr random;

    public ListNodeWithRandomPtr(int val){
        super(val);
        this.random = null;
    }
}