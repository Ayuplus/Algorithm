package com.zhouhao.doublelinkedlist;

import java.util.Stack;

/**
 * 双向链表
 *
 * @author
 */
public class DoubleLinkedList {
    /**
     * 定义头节点
     */
    private Node head = new Node(0,null,null);

    /**
     * 双链表在尾节点添加节点的方法
     * @param node 添加的节点
     */
    public void add(Node node){
        //使用辅助指针
        Node temp  = head;
        while (true){
            //当到达链表的末尾时,链表的next为空,此时可以添加新的节点
            if (temp.next == null){
                //将最后节点的next指向新节点
                temp.next = node;
                node.pre = temp;
                break;
            }
            //指针向后移动
            temp = temp.next;
        }
    }

    /**
     * 双链表遍历方法
     */
    public void list(){
        //先判断数组是否为空
        if (isEmpty()) {
            System.out.println("链表为空");
            return;
        }
        //利用头节点作为辅助指针
        Node temp = head;
        while (true){
            //当temp到达链表的最后节点时,即为null,表示没有元素可遍历了,退出循环
            if (temp.next == null){
                break;
            }
            //打印下个节点的信息
            System.out.println(temp.next);
            //指针移动
            temp = temp.next;
        }
    }

    /**
     * 判断链表是否为空
     */
    public boolean isEmpty(){
        return head.next == null;
    }

    /**
     * 按顺序插入节点的方法
     * @param node 插入的节点
     */
    public void addElement(Node node){

        //标记插入的节点是否已经存在
        boolean flag = false;
        //辅助指针
        Node temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            //当temp的next节点no大于节点的no时,说明插入的节点应在temp和temp.next节点之间插入
            if (temp.next.no > node.no){
                break;
            }
            //当节点与链表中元素存在no相同时,判定为元素已经存在
            else if (node.no == temp.next.no){
                flag = true ;
                break;
            }
            //指针后移
            temp = temp.next;
        }
        if (flag){
            System.out.println("当前元素已存在");
        }else {
            node.next = temp.next;
            temp.next = node;
            node.pre = temp;

        }
    }

    /**
     * 修改节点的方法
     */
    public void update(Node node){
        if (isEmpty()){
            System.out.println("链表为空");
            return;
        }
        //判断节点是否存在的标志
        boolean flag = false;
        Node temp = head.next;
        while (true){
            //当temp为null时,表示到达最后节点,打破循环
            if (temp == null){
                break;
            }
            //当节点no与新节点的no相等时,temp是要修改的节点
            if (node.no == temp.no){
                flag = true;
                break;
            }

            temp = temp.next;
        }

        if(flag){
            temp.name = node.name;
            temp.nickname = node.nickname;
        }else {
            System.out.println("元素不存在");
        }
    }

    /**
     * 删除节点的方法
     * @param no 删除节点的no
     */
    public void delete(int no){
        //判断是否有该节点
        boolean flag = false;
        //辅助指针
        Node temp = head.next;
        while(true){
            //当temp的下一节点指向null时,说明已经遍历完毕,打破循环
            if (temp == null){
                break;
            }
            //当temp的下一节点no与no相同时,找到节点
            if (temp.no == no){
                //将布尔标记改为true
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.pre.next = temp.next;
            if (temp.next != null){
                temp.next.pre = temp.pre;
            }
        }else {
            System.out.println("删除的节点不存在");
        }
    }

    /**
     * 获取链表中元素个数的方法
     */
    public int getLength(){
        if (isEmpty()){
            return 0;
        }
        //从头节点的下一个节点遍历
        Node temp = head.next;
        //计数器
        int count = 0 ;
        //当temp不为空,count自增
        while (temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    /**
     * 查找链表中倒数第k个元素
     */
    public void getReciprocalElement(int k){
        //当链表元素为空,直接返回
        if (head.next == null){
            return;
        }
        //当k大于链表长度或小于等于0时,直接返回
        if (k > this.getLength() || k <= 0){
            return;
        }
        //辅助指针表示
        Node temp = head.next;
        //长度减去k,得到辅助指针要移动的次数   size:5  k=2 移动三次得到第四个数据,即倒数第2个
        for (int i = 0; i < this.getLength()-k ; i++) {
            temp = temp.next;
        }
        System.out.println(temp);
    }

    /**
     * 翻转链表元素
     */
    public void reverse(){
        if (head.next == null|| head.next.next == null){
            return;
        }
        //定义一个辅助指针(变量)
        Node temp = head.next;
        //定义一个变量为辅助节点的下一节点(为了遍历)
        Node next = null;
        //定义一个新的头节点存储倒序的节点
        Node newHead = new Node(0,null,null);
        //利用辅助指针遍历整个链表
        while ( temp != null ){
            //用next接收temp下一节点
            next = temp.next;
            /**
             * 将新节点的next先赋给temp的next(关键)
             * newHead.next第一次是null,之后始终指向上一个添加的节点
             * 因此,temp.next指向newHead.next意为将temp的next指向了上一个节点
             * 再对newHead.next重新赋值,将temp赋值给newHead.next
             */
            temp.next = newHead.next;
            newHead.next = temp;
            //遍历
            temp = next;
        }
        //最后用head.next指向newHead.next(因为遍历用的是head)
        head.next = newHead.next;
    }

    /**
     * 逆序打印链表
     * 方式1:反转后打印
     * 方式二:利用栈打印
     */
    public void printReverse(){
        if (isEmpty()){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node temp = head.next;
        while (temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        while (stack.size()>0){
            System.out.println(stack.pop());
        }

    }

    /**
     * 合并链表的方法
     */
    public DoubleLinkedList copyOf(DoubleLinkedList s){
        Node next = null;
        boolean flag = false;
        Node temp1 = s.head.next;
        while (temp1 != null) {
            next = temp1.next;
            Node temp2 = this.head;
            while (true){
                if (temp2.next == null){
                    break;
                }
                if (temp2.next.no > temp1.no){
                    temp1.next = temp2.next;
                    temp2.next = temp1;
                    break;
                }
                temp2=temp2.next;
            }
            if (temp2.no < temp1.no){
                temp2.next = temp1;
            }
            temp1 = next;
        }
        return this;
    }
}
