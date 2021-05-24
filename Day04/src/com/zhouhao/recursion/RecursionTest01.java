package com.zhouhao.recursion;

import java.util.Arrays;

public class RecursionTest01 {
    public static void main(String[] args) {
        int[][] maze =new int[8][8];
        for (int i = 0; i < maze.length; i++) {
            maze[i][0] = 1;
            maze[i][7] = 1;
            maze[0][i] = 1;
            maze[7][i] = 1;
        }
        maze[1][4] = 1;
        maze[2][4] = 1;
        maze[3][4] = 1;

        /**
         * [1, 1, 1, 1, 1, 1, 1, 1]
         * [1, 0, 0, 0, 1, 0, 0, 1]
         * [1, 0, 0, 0, 1, 0, 0, 1]
         * [1, 0, 0, 0, 1, 0, 0, 1]
         * [1, 0, 0, 0, 0, 0, 0, 1]
         * [1, 0, 0, 0, 0, 0, 0, 1]
         * [1, 0, 0, 0, 0, 0, 0, 1]
         * [1, 1, 1, 1, 1, 1, 1, 1]
         */
        for (int[] ints : maze) {
            System.out.println(Arrays.toString(ints));
        }
        solution01(maze,1,1);
        for (int[] ints : maze) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static boolean solution01(int[][] maze,int i,int j){
        if (maze[6][6] == 2){
            return true;
        }else {
            if (maze[i][j] == 0) {
                maze[i][j] = 2;
                if (solution01(maze, i + 1, j)) {  //向下
                    return true;
                } else if (solution01(maze, i, j + 1)) { //向右
                    return true;
                } else if (solution01(maze, i, j - 1)) {  //向左
                    return true;
                } else if (solution01(maze, i - 1, j)) {  //向上
                    return true;
                } else {
                    maze[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
