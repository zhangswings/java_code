package com.bubble.test;

import java.lang.reflect.Array;
import java.util.Random;

/**
 * Created by Administrator on 2016/7/2.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = constructDataArray(15);
        System.out.println("------------排序前------------");
        printArrayData(arr);
        int result = binarySearck(arr, 0, 10, 5);
        System.out.println("The result is : " + result);
    }

    private static void printArrayData(int[] arr) {

        for (int d : arr)
            System.out.print(d + " ");
        System.out.println();
    }

    //针对int类型数组的二分查找,key为要查找数的下标
    private static int binarySearck(int[] arr, int fromIndex, int toIndex, int key) {
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];
            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid;//key found
        }
        return -(low - 1);//key not found
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
