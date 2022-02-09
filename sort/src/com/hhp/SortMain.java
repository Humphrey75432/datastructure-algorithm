package com.hhp;

import com.hhp.bubblesort.BubbleSort;
import com.hhp.insertsort.InsertSort;
import com.hhp.selectsort.SelectSort;
import com.hhp.shellsort.ShellSort;

import java.util.Arrays;

public class SortMain {

    public static void main(String[] args) {
        int[] input = {3, 2, 1, 6, 5, 4};

        // 冒泡排序
        BubbleSort bubbleSort = new BubbleSort();
        int[] sorted = bubbleSort.bubbleSort(input);
        System.out.println("冒泡排序的结果为：" + Arrays.toString(sorted));

        // 选择排序
        SelectSort selectSort = new SelectSort();
        sorted = selectSort.selectSort(input);
        System.out.println("选择排序的结果为：" + Arrays.toString(sorted));

        // 插入排序
        InsertSort insertSort = new InsertSort();
        sorted = insertSort.insertionSort(input);
        System.out.println("插入排序的结果为：" + Arrays.toString(sorted));

        // 希尔排序
        int[] copyInput = Arrays.copyOf(input, input.length);
        ShellSort shellSort = new ShellSort();
        shellSort.shellSort(copyInput);
        System.out.println("希尔排序的结果为：" + Arrays.toString(copyInput));
    }
}
