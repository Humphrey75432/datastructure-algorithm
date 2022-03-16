package com.hhp.insertsort;

import java.util.Arrays;

public class InsertSort {

    public int[] insertSort(int[] sourceArr) {
        // 对源数组进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);
        // 从下标为1的位置开始选择插入，假定下标为0的位置是有序的
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];

            // 从已经排序序列最右边开始比较，找到比其小的数
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            // 存在比其小的数，插入
            if (j != i) {
                arr[j] = tmp;
            }
        }
        return arr;
    }
}
