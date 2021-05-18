package com.zhouhao.linkedstack;

public class LinkedListStackTest {
    public static void main(String[] args) {
        LinkedListStack lls = new LinkedListStack();
        lls.push(new LinkedListStack.Node(1));
        lls.push(new LinkedListStack.Node(2));
        lls.push(new LinkedListStack.Node(3));
        System.out.println(lls.pop());
        System.out.println(lls.pop());

        lls.list();
    }
}
