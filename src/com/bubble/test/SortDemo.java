package com.bubble.test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Administrator on 2016/7/7.
 */
public class SortDemo {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 7, 9, 19};
        Arrays.sort(arr);
        for (int i=0;i<arr.length;i++)
            System.out.println(arr[i]);
    }
}
