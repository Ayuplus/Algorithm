package com.zhouhao.stack;

public class ArrayStack {
    //栈的最大容量
    private int maxSize;
    //栈
    private final Object[] stack;
    //栈帧
    private int stackTop = -1;
    //初始化栈容量的构造器
    public ArrayStack(int maxSize){
        stack = new Object[maxSize];
    }

    //压栈方法
    public void push(Object obj){
        if (isFull()){
            System.out.println("栈已满");
            return;
        }
        stack[++stackTop] = obj;
    }
    //弹栈方法
    public Object pop(){
        if (isEmpty()){
            throw new RuntimeException("栈已空");
        }
        Object temp = stack[stackTop];
        stackTop--;
        return temp;
    }
    //遍历栈
    public void list(){
        for (int i = 0; i <= stackTop; i++) {
            System.out.println(stack[i]);
        }
    }
    //判断栈是否已满
    public boolean isFull(){
        return stackTop == stack.length-1;
    }
    //判断栈是否为空
    public boolean isEmpty(){
        return stackTop == -1;
    }
}
