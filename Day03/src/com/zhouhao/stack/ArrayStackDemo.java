package com.zhouhao.stack;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack as = new ArrayStack(5);
        as.push(1);
        as.push(2);
        as.push(3);
        as.push(4);
        as.push(5);
        as.push(5);
        as.list();
        System.out.println(as.pop());
        System.out.println(as.pop());
        System.out.println(as.pop());
        System.out.println(as.pop());
        System.out.println(as.pop());

    }
}
