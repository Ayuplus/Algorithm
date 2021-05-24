package com.zhouhao.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class CalculatorTest02 {
    public static void main(String[] args) {
        //1+(2-3)*4+4/2
        List<String> list = infixToSuffix("1+(2-3)*4+4/2");
        int calculate = calculate(list);
        System.out.println(list);
        System.out.println(calculate);

    }
    //中缀表达式转后缀表达式    1+(2-3)*4+4/2 => 1 2 3 - 4 * + 4 2 / +
    public static List<String> infixToSuffix(String infix){
        //定义一个集合用于存储每个数字和符号
        List<String> list = new ArrayList<>();
        //定义一个集合存储数字
        List<String> suffix = new ArrayList<>();
        //定义一个栈存储符号
        Stack<String> operas = new Stack<>();
        for (int i = 0; i < infix.length(); i++) {
            if (infix.charAt(i) < 48 || infix.charAt(i) > 57){
                list.add(infix.charAt(i)+"");
            }else {
                //创建一个字符缓冲区
                StringBuilder sbu = new StringBuilder();
                int temp = i;
                while (i < infix.length() && infix.charAt(i) >= 48 && infix.charAt(i) <= 57 ){
                    sbu.append(infix.charAt(i));
                    i++;
                }
                list.add(sbu.toString());
                i = temp;
            }
        }
        //1+(2-3)*4+4/2
        //遍历集合
        for (String item : list) {
            //当集合元素为数值时
            if (item.matches("\\d+")){
                //将数字加入到数字集合中
                suffix.add(item);
            }
            //当集合元素为左括号时
            else if (item.equals("(") || operas.size() == 0){
                //直接压入到符号栈
                operas.push(item);
            }
            //当集合元素为右括号时
            else if (item.equals(")")){
                //弹出符号栈元素到数字集合中,直到找到左括号为止
                while ( !operas.peek().equals("(") ){
                    suffix.add(operas.pop());
                }
                //最后将当前找到的左括号弹出符号栈
                operas.pop();
            }
            //运算符逻辑
            else{
                //当前运算符优先级小于或者等于符号栈栈顶运算符时,需要将符号栈栈顶元素添加到数字集合中
                while (operas.size() != 0 && ArrayStack.getPriority(item.charAt(0)) <= ArrayStack.getPriority(operas.peek().charAt(0)) ){
                    suffix.add(operas.pop());
                }
                operas.push(item);
            }
        }
        while (operas.size() != 0){
            suffix.add(operas.pop());
        }
        return suffix;
    }
    //后缀表达式运算方法
    public static int calculate(List<String> list){
        //定义一个栈存储元素
        Stack<String> stack = new Stack<>();
        //将表达式遍历
        for (String s : list) {
            //如果字符串是多位数时,将字符串压入栈中
            if (s.matches("\\d+")){
                stack.push(s);
            }else {
                //当字符串是符号时
                int res = 0;
                //弹出两个元素,与当前符号运算
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                if (s.equals("+")){
                    res = num1 + num2;
                }else if (s.equals("-")){
                    res = num2 - num1;
                }else if (s.equals("*")){
                    res = num1*num2;
                }else if (s.equals("/")){
                    res = num2/num1;
                }else {
                    throw new RuntimeException("运算符有误");
                }
                //运算结果再压入栈中
                stack.push(res+"");
            }
        }
        //返回栈中最后的元素
        return Integer.parseInt(stack.pop());
    }
}
