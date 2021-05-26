package com.zhouhao;


public class DoubleLinkedList<V>{
    //定义一个变量表示链表长度
    private int size = 0;
    //头节点
    private Node<V> first;

    //内部类节点,即构成链表的每一个节点
    class Node<V>{
        private V val;
        private Node<V> pre;
        private Node<V> next;

        public Node(V val) {
            this.val = val;
        }
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return first == null;
    }

    /**
     * @param val 传入的数据
     */
    public void addLast(V val){
        Node<V> node = new Node<V>(val);
        Node<V> temp = first;
        if (first != null){
            temp.next = node;
            temp = temp.next;
        }else {
            first = node;
        }
        size++;

    }
    public void add(V val){
        addLast(val);
    }

    //删除末尾元素
    public V deleteLast(){
        if (isEmpty()){
            System.out.println("链表为空");
            return null;
        }
        Node<V> temp = first;
        while ( temp.next != null ){
            temp = temp.next;
        }
        V v = temp.val;
        temp.pre.next = null;
        size--;
        return v;
    }
    public V delete(){
        return deleteLast();
    }

    //添加头元素
    public void addFirst(V val){
        Node<V> node = new Node<>(val);
        Node<V> temp = first;
        if (first != null){
            first = node;
            first.next = temp;
        }else {
            first = node;
        }
        size++;
    }

    //删除头元素
    public V deleteFirst(){
        if (isEmpty()){
            System.out.println("链表为空");
        }
        V v = first.val;
        first = first.next;
        size--;
        return v;
    }

    //遍历链表
    public void list(){
        Node<V> temp = first;
        while (temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    //获取链表长度
    public int size(){
        return size;
    }

    //通过下标获取节点元素
    public V getByIndex(int index){
        Node<V> temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }
    //获取链表第一个元素
    public V getFirst(){
        return first.val;
    }
    //获取链表的最后一个元素
    public V getLast(){
        Node<V> temp = first;
        while (temp.next != null){
            temp = temp.next;
        }
        return temp.val;
    }
    
}
