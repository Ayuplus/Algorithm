package com.zhouhao;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random()*8000000);
        }
        //测试希尔排序交换法时间  30s
        //测试希尔排序移动法时间  1s
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        shellSort02(arr);
        System.out.println(sdf.format(new Date()));
    }
    //交换法
    public static void shellSort01(int[] arr){
        //对数组进行分组,每次分组在排序好后再分上一次的一半,直到分不了组
        for (int gap = arr.length / 2; gap > 0; gap = gap/2) {
            //定义一个临时变量
            int temp = 0;
            //分组的每个元素进行比较
            for (int i = gap; i < arr.length; i++) {
                for (int j = i-gap; j >= 0 ; j--) {
                    if (arr[j] > arr[j+gap]){
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
        }
    }

    //移动法
    public static void shellSort02(int[] arr){
        for (int gap = arr.length / 2; gap > 0 ; gap = gap / 2) {
            for (int i = gap; i < arr.length ; i++) {
                int index = i;
                int val = arr[index];
                while ( index - gap >= 0 && val < arr[index - gap]){
                    arr[index] = arr[index - gap];
                    index -= gap;
                }
                arr[index] = val;
            }
        }
    }
}
