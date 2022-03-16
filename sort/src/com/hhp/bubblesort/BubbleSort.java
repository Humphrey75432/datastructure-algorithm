package com.hhp.bubblesort;

import java.util.Arrays;

public class BubbleSort {

    public int[] bubbleSort(int[] sourceArray) {
        // 拷贝一份，不改变原参数的内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        // 外层循环用于记录多少趟（避免越界，从1开始到尾部）
        // 内存循环用于比较两个相邻的元素是否需要交换（避免越界，从0开始到尾部的前一个元素）
        for (int i = 1; i < arr.length; i++) {
            // 设定标记，如果为true说明此次循环没有进行交换，减少交换的趟数
            boolean flag = true;
            for (int j = 0; j < arr.length - 1; j++) {
                // 降序排，换成大于号为升序排
                if (arr[j] > arr[j + 1]) {
                    // 执行两个数的交换
                    // 将flag置为false表示已经完成交换
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = false;
                }
            }
            // 如果为发生交换，直接跳过循环执行下一趟比较
            if (flag) {
                break;
            }
        }
        return arr;
    }
}
