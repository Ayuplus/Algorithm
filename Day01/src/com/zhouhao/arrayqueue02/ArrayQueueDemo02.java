package com.zhouhao.arrayqueue02;

import java.util.Scanner;

/**
 * @author
 */
public class ArrayQueueDemo02 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("这是一个队列");
        System.out.println("请输入队列的长度");
        int length = s.nextInt();
        Queue02 queue = new Queue02(length);
        boolean flag = true;
        while (flag){
            System.out.println("********功能列表********");
            System.out.println("[0] 退出");
            System.out.println("[1] 查询队列");
            System.out.println("[2] 添加数据");
            System.out.println("[3] 取出数据");
            System.out.println("[4] 查看头数据");
            int key = s.nextInt();
            switch(key){
                case 0 :
                    System.out.println("已退出");
                    flag = false;
                    break;
                case 1:
                    queue.listQueue();
                    break;
                case 2:
                    System.out.println("请输入存储元素");
                    int num = s.nextInt();
                    queue.addElement(num);
                    break;
                case 3:
                    queue.getElement();
                    break;
                case 4:
                    queue.getHeadElement();
                    break;
            }

        }
    }
}
