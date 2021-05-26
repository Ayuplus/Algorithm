package com.zhouhao;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Test01 {
    public static void main(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = (int) (Math.random()*800);
        }
        shellSort(arr);
    }
    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int temp = 0;
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (min > arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if ( minIndex != i ){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

        }
    }

    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int valIndex = i;
            while (valIndex > 0 && val < arr[valIndex-1]){
                arr[valIndex] = arr[valIndex-1];
                valIndex--;
            }
            arr[valIndex] = val;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void shellSort(int[] arr){
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int val = arr[i];
                int index = i;

                while (index - gap >= 0 && val < arr[index-gap]){
                    arr[index] = arr[index - gap];
                    index-=gap;
                }
                arr[index] = val;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
