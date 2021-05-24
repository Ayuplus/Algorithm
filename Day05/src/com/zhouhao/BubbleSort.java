package com.zhouhao;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[8000];
        for (int i = 0; i < 8000; i++) {
            arr[i] = (int) (Math.random()*100);
        }
        //测试冒泡排序时间  9s
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        bubbleSort(arr);
        System.out.println(sdf.format(new Date()));
    }
    public static int[] bubbleSort(int[] arr){
        //标记if条件是否执行,未执行则表示数组顺序已经正确,可以提前退出排序
        boolean flag = false;
        //临时变量
        int temp;
        for (int i = 0; i <arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j] > arr[j+1]){
                    flag = true;
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
            if (!flag){
                break;
            }
        }
        return arr;
    }
}
