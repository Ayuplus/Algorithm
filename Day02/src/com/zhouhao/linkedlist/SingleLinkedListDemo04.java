package com.zhouhao.linkedlist;

/**
 * @author
 */
public class SingleLinkedListDemo04 {
    public static void main(String[] args) {
        SingeLinkedList s1 = new SingeLinkedList();
        SingeLinkedList s2 = new SingeLinkedList();
        s1.addElement(new Node(1,"宋江","小宋"));
        s1.addElement(new Node(4,"吴用","智多星"));
        s2.addElement(new Node(3,"林冲","豹子头"));
        s2.addElement(new Node(2,"卢俊义","玉麒麟"));
        s2.addElement(new Node(5,"卢俊义","玉麒麟"));
        s2.addElement(new Node(6,"卢俊义","玉麒麟"));
        s1.list();
        s2.list();
        System.out.println("=========================");
        SingeLinkedList singeLinkedList = s1.copyOf(s2);
        singeLinkedList.list();
    }
}
