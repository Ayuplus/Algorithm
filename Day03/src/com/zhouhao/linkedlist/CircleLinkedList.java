package com.zhouhao.linkedlist;

public class CircleLinkedList {
    private Node first = null;

    /**
     * 设置游戏人数
     * @param num 加入游戏的人数
     */
    public void add(int num){
        //小于两个时无法开始游戏
        if (num < 2){
            System.out.println("游戏人数需两个以上");
            return;
        }
        //辅助节点
        Node tmp = null;
        for (int i = 1; i <= num; i++) {
            //根据输入数量来创建节点数量
            Node node = new Node(i);
            //当插入第一个节点时,初始化first
            if (i == 1){
                //first指向第一个节点
                first = node;
                //为了形成环形,next先指向自己
                first.next = first;
                //first不能动.因此需要一个辅助指针来增加元素
                tmp = first;
            }else {
                /**
                 * 每添加一个元素,就让辅助指针指向新元素,新的元素再指向first,
                 * 最后将辅助指针指向新的元素,方便下次添加
                 */
                node.next = first;
                tmp.next = node;
                tmp = node;
            }
        }
    }

    /**
     * 遍历环形链表
     */
    public void list(){
        if (this.first == null){
            System.out.println("空链表");
        }
        Node temp = this.first;
        while (true){
            System.out.println(temp.no);
            if (temp.next == first){
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 获取链表中元素个数
     * @return 返回链表长度
     */
    public int size(){
        if (first == null){
           return 0;
        }
        int count = 0;
        Node temp = first;
        while (true){
            count++;
            if (temp.next == first){
                break;
            }
            temp = temp.next;
        }
        return count;
    }

    /**
     * 约瑟夫问题
     */
    public void game(int startNo, int countNum){
        //检查参数,提示程序健壮性
        if (startNo > this.size() || startNo < 1 || countNum < 1){
            System.out.println("参数有误");
            return;
        }
        //指定一个辅助指针
        Node temp = first;
        //将指针指向first的前一个节点,方便删除节点
        while (temp.next != first) {
            temp = temp.next;
        }
        /**
         * 当指定从第startNo个开始时,first和temp要向后移动startNo - 1下
         *
         */
        for (int i = 0; i < startNo - 1; i++) {
            first = first.next;
            temp = temp.next;
        }

        while (temp != first) {
            /**
             * 每报一次数,temp和first向后移动countNum - 1下,
             * 例如 first指向2,temp指向1 报3次数后 first指向4 temp指向3
             * 此时first指向的就是要删除的节点,先打印出first的值,再让first指向first的下一节点(first.next),
             * 再将temp的下一节点(temp.next)指向first,最后没有变量指向原来的first,first会自动被回收(被删除)
             */

            for (int i = 0; i < countNum - 1; i++) {
                first = first.next;
                temp = temp.next;
            }
            System.out.println(first.no);
            first = first.next;
            temp.next = first;
        }
        System.out.println(first.no);
    }
}
