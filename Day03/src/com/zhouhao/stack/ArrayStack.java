package com.zhouhao.stack;

public class ArrayStack {
    //栈的最大容量
    private int maxSize;
    //栈
    private final int[] stack;
    //栈帧
    private int stackTop = -1;
    //初始化栈容量的构造器
    public ArrayStack(int maxSize){
        stack =  new int[maxSize];
    }

    //压栈方法
    public void push(int num){
        if (isFull()){
            System.out.println("栈已满");
            return;
        }
        stack[++stackTop] = num;
    }
    //弹栈方法
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈已空");
        }
        int temp = stack[stackTop];
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
    //查看栈顶元素
    public int peek(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        return stack[stackTop];
    }
    //判断是否为运算符
    public static boolean isOpera(char opera){
        return opera == '+' || opera == '-' || opera == '*' || opera=='/';
    }
    //设置运算符优先级
    public static int getPriority(char opera){
        if (opera == '/' || opera =='*'){
            return 2;
        }else if (opera == '+' || opera == '-'){
            return 1;
        }
        return -1;
    }
    //设置运算方法
    public static int getRes(int num1,int num2,char opera){
        int res = 0;
        switch (opera) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num2 * num1;
                break;
            case '/':
                res = num2 / num1;
                break;
        }
        return res;
    }
}
