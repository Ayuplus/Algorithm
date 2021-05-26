package com.zhouhao;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculator {
    public static void main(String[] args) {
        calculator("31+2*6-2");
    }
    //"31+2*6-2"
    public static void calculator(String infix){
        List<String> list = new ArrayList<>();
        int index = 0;
        while ( index < infix.length()){
            StringBuilder sbn = new StringBuilder();
            if (infix.charAt(index) < 48 || infix.charAt(index) >57){
                list.add(infix.charAt(index)+"");
                index++;
            }else {
                while ( index < infix.length() && infix.charAt(index) >=48 && infix.charAt(index)<=57 ){
                    sbn.append(infix.charAt(index));
                    index++;
                }
                list.add(sbn.toString());
            }
        }
        //声明一个集合存放数字
        List<String> nums = new ArrayList<>();
        //声明一个栈存放符号
        Stack<String> operas = new Stack<>();
        for (String s : list) {
            //当遍历到数字时，直接放入数字集合
            if (s.matches("\\d+")){
                nums.add(s);
            //当遍历到左括号或者符号栈为空时，直接压入符号栈
            }else if (s.equals("(") || operas.size() == 0 ){
                operas.push(s);
            //当遍历到右括号时,弹出符号栈的元素知道出现左括号为止
            }else if (s.equals(")")){
                while ( !operas.peek().equals("(") ){
                    nums.add(operas.pop());
                }
                operas.pop();
            }else {
                if ( getPriority(s) <= getPriority(operas.peek()) ){
                    
                }
            }
        }
    }
    public static int getPriority(String opera){
        int res = 0;
        if ( opera.equals("+") || opera.equals("-") ){
            res = 1;
        }else if ( opera.equals("*") || opera.equals("/")){
            res = 2;
        }
        return res;
    }

}
