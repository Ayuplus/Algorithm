package com.zhouhao;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random()*8000000);
        }
        //测试选择排序时间  2s
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        selectSort(arr);
        System.out.println(sdf.format(new Date()));
    }
    public static int[] selectSort(int[] arr ){
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            int min = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if (min > arr[j]){
                    min = arr[j];
                    index = j;
                }
            }
            if (index != i){
                arr[index] = arr[i];
                arr[i] = min;
            }
        }

        return arr;
    }
}
