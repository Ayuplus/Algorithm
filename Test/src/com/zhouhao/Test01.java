package com.zhouhao;


import java.util.Arrays;

public class Test01 {
    public static void main(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = (int) (Math.random()*85);
        }
        selectSort(arr);
    }

    public static void bubbleSort(int[] arr){
        int temp = 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int min = arr[i];
            int minIndex = i;
            while (minIndex > 0 && min < arr[minIndex-1]){
                arr[minIndex] = arr[minIndex-1];
                minIndex--;
            }
            arr[minIndex] = min;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i+1; j < arr.length ; j++) {
                if (arr[minIndex] > arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            arr[minIndex] = arr[i];
            arr[i] = min;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void shellSort(int[] arr){
        for (int gap = arr.length / 2; gap > 0; gap /= 2 ) {
            for (int i = gap; i < arr.length; i++) {
                int val = arr[i];
                int valIndex = i;
                while (valIndex -gap >= 0 && val < arr[valIndex - gap]){
                    arr[valIndex] = arr[valIndex - gap];
                    valIndex -= gap;
                }
                arr[valIndex] = val;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void mergerSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {

        }
    }

}
