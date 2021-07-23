package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] data = {5, 3, 9, 1, 7, 10, 6, 2, 4};
        new MergeSort().mergeSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }
}
