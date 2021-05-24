package com.zhouhao.stack;

public class CalculatorTest {
    public static void main(String[] args) {
        //给一个要进行计算的公式
        String s = "31+2*6-2";
        //定义两个临时变量,方便后续做运算
        int num1 = 0;
        int num2 = 0;
        //定义一个字符串用于拼接多位数
        StringBuilder keepNum = new StringBuilder();
        //定义一个数字栈,一个符号栈
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operaStack = new ArrayStack(10);
        //遍历字符串
        for (int i = 0; i < s.length(); i++) {
            //当遍历到符号时,走符号逻辑
            if (ArrayStack.isOpera(s.charAt(i))){
                //当数组不为空时的逻辑
                if (!operaStack.isEmpty()){
                    /**
                     * 如果此时遍历到的符号优先级小于或者等于符号栈栈顶的符号时,弹出符号栈顶一个元素和数栈两个元素进行运算
                     * 运算得到的值再压入数栈,再将当前遍历到的符号压入符号栈
                     */
                    if (operaStack.getPriority(s.charAt(i))  <= operaStack.getPriority((char) operaStack.peek()) ){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        //运算
                        int res = ArrayStack.getRes(num1, num2, (char) operaStack.pop());
                        //将运算结果压入数栈
                        numStack.push(res);
                        //将遍历到的符号压入符号栈
                        operaStack.push(s.charAt(i));
                    }
                    //当数组为空时,直接将符号压入符号栈
                    else {
                        operaStack.push(s.charAt(i));
                    }
                }else {
                    operaStack.push(s.charAt(i));
                }
            }
            //当遍历到数字时,直接放入数栈
            else {
                //因遍历得到的结果为char类型,转成对应数字需要-48
                //numStack.push(s.charAt(i)-48);
                //处理多位数时,不能单个入栈
                keepNum.append(s.charAt(i));
                //当遍历到的数字为字符串的最后一位时,直接将数字压入数栈,
                if (i == s.length()-1){
                    numStack.push(Integer.parseInt(keepNum.toString()));
                    break;
                }
                    //当发现下一个字符是运算符时,直接将数字压入数栈,当到达字符串最后时,会出现越界异常,因此要加入逻辑筛选
                if (ArrayStack.isOpera(s.charAt(i+1))){
                    numStack.push(Integer.parseInt(keepNum.toString()));
                    keepNum = new StringBuilder();
                }
            }
        }
        //当遍历完字符串时,将数栈和符号栈弹出运算,可以得到最终结果(即数栈中最后一个元素)
        while (!operaStack.isEmpty()){
            num1 = numStack.pop();
            num2 = numStack.pop();
            int res = ArrayStack.getRes(num1, num2, (char) operaStack.pop());
            numStack.push(res);
        }
        System.out.println(numStack.pop());
    }
}
