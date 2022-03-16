package com.hhp.quicksort;

import java.util.Arrays;

public class QuickSort {

    public int[] quickSort(int[] sourceArray) {
        int len = sourceArray.length;
        int[] arr = Arrays.copyOf(sourceArray, len);
        return recursiveQuickSort(arr, 0, len - 1);
    }

    private int[] recursiveQuickSort(int[] arr, int left, int right) {
        if (left < right) {
            // 获取分区因子
            int partitionIndex = partition(arr, left, right);
            // 对数组左半部分进行快速排序
            recursiveQuickSort(arr, left, partitionIndex - 1);
            // 对数组右半部分进行快速排序
            recursiveQuickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private int partition(int[] arr, int left, int right) {
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[left]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, left, index - 1);
        return index - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
