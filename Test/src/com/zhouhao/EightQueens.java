package com.zhouhao;

public class EightQueens {
    int[] arr = new int[8];
    //打印方法
    public void print(){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    /**
     * @param n n表示第n个皇后
     * @return 返回值表示皇后的位置是否正确
     */
    public boolean judge(int n){
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(i - n) == Math.abs(arr[i] - arr[n])){
                return false;
            }
        }
        return true;
    }


    public void check(int n){
        if (n == 8){
            print();
            return;
        }else {
            for (int i = 0; i < 8; i++) {
                arr[n] = i;
                if (judge(n)) {
                    check(n + 1);
                }
            }
        }
    }
}
