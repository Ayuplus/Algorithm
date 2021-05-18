package com.zhouhao.linkedstack;

import java.util.LinkedList;

public class LinkedListStack {
    static class Node{
        private final int val;
        private Node next;
        private Node pre;
        public Node(int val){
            this.val = val;
        }
    }
    private Node first;
    private Node temp;
    public void push(Node node){
        if (first == null){
            first = node;
            temp = first;
        }else{
            temp.next = node;
            node.pre = temp;
            temp = node;
        }
    }

    public int pop(){
        if (isEmpty()){
            throw  new RuntimeException("栈空");
        }
        int res = temp.val;
        temp = temp.pre;
        return res;
    }
    public boolean isEmpty(){
        return temp == null;
    }
    public void list(){
        if (isEmpty()){
            System.out.println("栈空");
            return;
        }
        Node cur = first;
        while (cur != temp.next) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
