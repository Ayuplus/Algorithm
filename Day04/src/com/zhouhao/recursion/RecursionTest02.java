package com.zhouhao.recursion;

public class RecursionTest02 {
    //使用一个一维数组表示8个皇后,下标表示行号,下标的值表示皇后的位置
    int[] arr = new int[8];
    static int count = 0; //判断次数
    static int count2 = 0; //解法数量

    public static void main(String[] args) {
        RecursionTest02 rs = new RecursionTest02();
        rs.check(0);
        System.out.println(count);
        System.out.println(count2);
    }
    //打印得到的结果
    public void print(){
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    //判断皇后是否冲突,n表示第n个皇后
    public boolean judge(int n){
        for (int i = 0; i < n; i++) {
            count++;
            /**
             * n表示第n个皇后,循环i此表示与拿n之前的皇后与n进行比对,arr[n]和arr[i]表示皇后的位置
             * n和i分别表示当前 皇后和之前 皇后的行号
             * 当皇后与之前的皇后在同一列  或者   当皇后与其他皇后在同一斜线时,返回false便是冲突
             * 在同一斜线上,行1-列1 == 行2 - 列2   也就是 行1 - 行2 = 列1 - 列2
             * 运用在此处 也就是 当前皇后(n)的行号(n)-之前皇后(i)的行号(i) == 当前皇后(n)的位置arr[n]-之前皇后(i)的位置arr[i]表示在同一斜线
             */
            if (arr[i] == arr[n] || Math.abs(n-i) == Math.abs(arr[n] - arr[i])){
                return false;
            }
        }
        return true;
    }
    //编写方法放置皇后
    public void check(int n){
        //当第8个皇后判断不冲突到达此处
        if (n == 8){
            count2++;
            print();
        }else {
            //for循环依次将皇后放在0-7列
            for (int i = 0; i < 8; i++) {
                //将皇后放在第i列
                arr[n]  = i;
                //循环判断皇后是否与其他皇后冲突
                if (judge(n)){
                    //如果不冲突,则继续递归,放置第n+1个皇后
                    check(n+1);
                }
                //如果冲突,会继续执行循环,i++,也就是将皇后右移一列
            }
        }
    }
}
