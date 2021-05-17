package com.zhouhao.doublelinkedlist;

import com.zhouhao.doublelinkedlist.Node;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.add(new Node(1,"宋江","小宋"));
        dll.add(new Node(4,"吴用","智多星"));
        dll.add(new Node(3,"林冲","豹子头"));
        dll.add(new Node(2,"卢俊义","玉麒麟"));
        System.out.println("==================测试add()========================");
        dll.list();

        dll.update(new Node(2,"zhangsan","zs"));
        System.out.println("====================测试update()======================");
        dll.list();

        System.out.println("======================测试delete()====================");
        dll.delete(2);
        dll.delete(1);
        dll.list();
        System.out.println("=======================测试倒数第k个===================");
        dll.getReciprocalElement(2);
        dll.getReciprocalElement(1);
        System.out.println("=======================测试翻转链表===================");
        dll.reverse();
        dll.list();
        System.out.println("=======================测试逆序打印===================");
        dll.printReverse();
        System.out.println("=======================测试顺序插入===================");
        dll.addElement(new Node(1,"宋江","小宋"));
        dll.addElement(new Node(2,"卢俊义","玉麒麟"));
        dll.addElement(new Node(5,"卢俊义","玉麒麟"));
        dll.list();
    }
}
