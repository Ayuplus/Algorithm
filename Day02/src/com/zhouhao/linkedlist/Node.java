package com.zhouhao.linkedlist;

/**
 * 链表中的节点元素
 *
 * @author
 */
public class Node {
     int no;
     String name;
     String nickname;
     Node next;
    //链表中下一节点的指针

    /**
     * 构造器赋值
     * @param no
     * @param name
     * @param nickname
     */
    public Node (int no , String name ,String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }


    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nikeName='" + nickname + '\'' +
                '}';
    }
}
