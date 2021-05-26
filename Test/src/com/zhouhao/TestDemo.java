package com.zhouhao;


import org.junit.Test;

public class TestDemo {
    @Test
    public void testDoubleLinkedList(){

    }
    @Test
    public void testQueue(){
        Queue<String> queue = new Queue<>();
        queue.add("zs");
        queue.add("lisi");
        queue.add("ww");
//        System.out.println("queue.size() = " + queue.size());
        queue.list();
    }
    @Test
    public void testQueen(){
        EightQueens eq = new EightQueens();
        eq.check(0);
    }
}
