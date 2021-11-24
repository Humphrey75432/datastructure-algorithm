package com.hhp.bubblesort;

import java.util.Arrays;

public class BubbleSort {

    public int[] bubbleSort(int[] sourceArray) {
        // 拷贝一份，不改变原参数的内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int i = 1; i < arr.length; i++) {
            // 设定标记，如果为true说明此次循环没有进行交换，减少交换的趟数
            boolean flag = true;
            for (int j = 0; j < arr.length - 1; j++) {
                // 降序排，换成大于号为升序排
                if (arr[j] < arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return arr;
    }
}
