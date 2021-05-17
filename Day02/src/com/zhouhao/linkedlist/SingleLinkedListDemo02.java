package com.zhouhao.linkedlist;

public class SingleLinkedListDemo02 {
    public static void main(String[] args) {
        SingeLinkedList sll = new SingeLinkedList();
        sll.addElement(new Node(1,"宋江","小宋"));
        sll.addElement(new Node(4,"吴用","智多星"));
        sll.addElement(new Node(3,"林冲","豹子头"));
        sll.addElement(new Node(2,"卢俊义","玉麒麟"));
        sll.list();
        System.out.println("打印倒数第2个");
        sll.getReciprocalElement(2);

        sll.reverse();
        System.out.println("翻转后的链表");
        sll.list();

        System.out.println("逆序打印0");
        sll.printReverse();
    }
}
