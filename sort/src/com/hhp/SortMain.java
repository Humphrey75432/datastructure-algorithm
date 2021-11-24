package com.hhp;

import com.hhp.bubblesort.BubbleSort;

import java.util.Arrays;

public class SortMain {

    public static void main(String[] args) {
        int[] input = {3, 2, 1, 6, 5, 4};

        // 冒泡排序
        BubbleSort bubbleSort = new BubbleSort();
        int[] sorted = bubbleSort.bubbleSort(input);
        System.out.println(Arrays.toString(sorted));
    }
}
