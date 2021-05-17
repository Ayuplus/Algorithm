package com.zhouhao.linkedlist;

/**
 * @author
 */
public class SingleLinkedListDemo01 {

    public static void main(String[] args) {
        Node n1 = new Node(1,"zhangsan","zs");
        Node n2 = new Node(2,"lisi","ls");
        Node n3 = new Node(3,"wangwu","ww");
        Node n4 = new Node(4,"zhaoliu","zl");

        SingeLinkedList sll = new SingeLinkedList();
        sll.add(n1);
        sll.add(n2);
        sll.add(n3);
        sll.add(n4);
        System.out.println("删除前");
        sll.list();

        sll.delete(3);
        sll.delete(1);
        sll.delete(4);
        System.out.println("删除后");
        sll.list();

        sll.update(new Node(2,"卢俊义","玉麒麟"));
        System.out.println("修改后");
        sll.list();

        sll.addElement(new Node(1,"宋江","小宋"));
        sll.addElement(new Node(4,"吴用","智多星"));
        sll.addElement(new Node(3,"林冲","豹子头"));
        sll.addElement(new Node(3,"林冲","豹子头"));
        System.out.println("添加后");
        sll.list();
    }

}
