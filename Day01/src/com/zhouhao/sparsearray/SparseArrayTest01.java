package com.zhouhao.sparsearray;

import java.util.Arrays;

/**
 * @author
 */
public class SparseArrayTest01 {
    public static void main(String[] args) {
        //创建一个11*11的棋盘
        int[][] arr = new int[11][11];
        //1表示白子,2表示黑子
        arr[1][2] = 1;
        arr[2][3] = 2;
        int[][] sparesArray = getSparesArray(arr);

        for (int[] ints : sparesArray) {
            System.out.println(Arrays.toString(ints));
        }

        int[][] arrays = getArrays(sparesArray);
        for (int[] array : arrays) {
            System.out.println(Arrays.toString(array));
        }

    }

    /**
     * 二维数组转稀疏数组的方法
     *
     */
    public static int[][] getSparesArray(int[][] arr){
        //获取棋盘中棋子的数目
        int count = 0;
        for (int[] ints : arr) {
            for (int i : ints) {
                if (i != 0){
                    count++;
                }
            }
        }
        //根据棋子的数目来初始化稀疏数组
        int[][] sparseArray = new int[count+1][3];
        //第一行第一列表示棋盘的行
        sparseArray[0][0] = arr.length;
        //第一行第二列表示棋盘的列
        sparseArray[0][1] = arr[0].length;
        //第一行第三列表示棋盘的棋子数目
        sparseArray[0][2] = count;

        //遍历数组得到不为0的值,并存储在稀疏数组中
        //添加计数器用来表示稀疏数组的行索引
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0){
                    //每一次赋值行索引++
                    index++;
                    //i表示棋子的行号
                    sparseArray[index][0] = i;
                    //j表示棋子的列号
                    sparseArray[index][1] = j;
                    //arr[i][j]表示棋子的值
                    sparseArray[index][2] = arr[i][j];
                }
            }
        }
        return sparseArray;
    }

    /**
     *稀疏数组转二维数组的方法
     */
    public static int[][] getArrays(int [][] sparsearray){
        int [][] arr = new int[sparsearray[0][0]][sparsearray[0][1]];
        for (int i = 1; i < sparsearray.length; i++) {
            arr[sparsearray[i][0]][sparsearray[i][1]] = sparsearray[i][2];
        }
        return arr;
    }
}
