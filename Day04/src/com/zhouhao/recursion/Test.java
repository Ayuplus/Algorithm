package com.zhouhao.recursion;

class Solution {
    static int count;
    public int totalNQueens(int n) {
        int[] arr = new int[n];
        check(0,n,arr);
        return count;
    }
    public boolean judge(int n,int[] arr){
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(n-i) == Math.abs(arr[n] - arr[i])){
                return false;
            }
        }
        return true;
    }
    public void check(int q,int n,int[] arr){
        if(q == n){
            count++;
        }else{
            for (int i = 0; i < n; i++) {
                arr[q]  = i;
                if (judge(q,arr)){
                    check(q+1,n,arr);
                }
            }
        }
    }
}
