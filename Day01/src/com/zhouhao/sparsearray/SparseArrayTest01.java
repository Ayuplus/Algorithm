package com.zhouhao.sparsearray;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        //二维数组转稀疏数组
        int[][] sparesArray = getSparesArray(arr);
        write(new File("d:\\sparsearray.txt"),sparesArray);

        int[][] arrays = getArrays(sparesArray);

        read(new File("d:\\sparsearray.txt"));
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
    //存储稀疏数组
    public static void write(File file,int[][] arr){
        //创建写入流
        FileWriter fw = null;
        try {
            //实例化写入流
            fw = new FileWriter(file);
            for (int[] ints : arr) {
                for (int j = 0; j < ints.length; j++) {
                    if (j == arr.length - 1) {
                        fw.write(ints[j] + "");
                        break;
                    }
                    fw.write(ints[j] + "");
                    fw.write(",");
                }
                fw.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fw != null){
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //读取稀疏数组
    public static int[][]  read(File file){
        //创建读取流
        FileReader fr = null;
        //创建读取缓冲流
        BufferedReader br = null;
        //创建一个集合存储读取的数组文件
        List<String> list = new ArrayList<>();
        try {
            //创建读取流实例
            fr = new FileReader(file);
            //创建读取缓存流实例
            br = new BufferedReader(fr);
            //定义一个字符串存放读取到的数据
            String line = null;
            //循环读取
            while ( (line = br.readLine()) != null ){
                //将读取的内容添加到集合
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fr != null)
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        /**
         * 11,11,2
         * 1, 2, 1
         * 2, 3, 2
         */
        //稀疏数组的行数 为集合的个数
        int row = list.size();
        //稀疏数组的列数是集合中
        int column = list.get(0).split(",").length;
        //根据行和列创建稀疏数组
        int[][] arr = new int[row][column];
        for (int i = 0; i < list.size(); i++) {
            String[] split = list.get(i).split(",");
            for (int j = 0; j < split.length; j++) {
                arr[i][j] = Integer.parseInt(split[j]);
            }
        }
        return arr;
    }
}
