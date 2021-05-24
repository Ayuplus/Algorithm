package com.zhouhao;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 插入排序
 * 插入排序，一般也被称为直接插入排序。对于少量元素的排序，它是一个有效的算法 [1]  。
 * 插入排序是一种最简单的排序方法，它的基本思想是将一个记录插入到已经排好序的有序表中，从而一个新的、记录数增1的有序表。
 * 在其实现过程使用双层循环，外层循环对除了第一个元素之外的所有元素，内层循环对当前元素前面有序表进行待插入位置查找，并进行移动
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random()*8000000);
        }

        //测试插入排序时间  3s
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        int[] ints = insertSort(arr);
        System.out.println(sdf.format(new Date()));
    }
    public static int[] insertSort(int[] arr){
        //默认将arr[0]作为一个有序表,从arr[1]开始插入
        for (int i = 1; i < arr.length; i++) {
            //定义一个变量记录要插入的数据
            int val = arr[i];
            //定义一个变量记录要插入数据的前一个数据索引
            int indexVal = i-1;
            //当下标要大于等于0并且插入的数据比有序表中数据小时,表示没有找到插入位置
            while (indexVal >= 0 && val < arr[indexVal]){
                arr[indexVal+1] = arr[indexVal];
                indexVal--;
            }
            //当执行到这时,表示已经找到了插入位置
            arr[indexVal+1] = val;
        }
        return arr;
    }
}
