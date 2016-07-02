package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] arr = constructDataArray(15);
        System.out.println("------------排序前------------");
        printArrayData(arr);
        System.out.println("------------排序后------------");
        printArrbubbleSort4ayData(arr);
        printArrayData(arr);


    }

    private static void printArrayData(int[] arr) {

        for (int d:arr)
            System.out.print(d+" ");
        System.out.println();
    }

    //冒泡算法
    private static int[] printArrbubbleSort4ayData(int[] arr) {
        boolean flag = true;
        int n = arr.length;
        while (flag) {
            flag = false;
            for (int j = 0; j < n - 1; j++) {
                if (arr[j] > arr[j + 1]) {   //数据交换
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    //设置标志位
                    flag = true;
                }
            }
            n--;
        }
      return arr;
    }

    private static int[] constructDataArray(int length) {
        int[] arr = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(length);
        }
        return arr;

    }
}
