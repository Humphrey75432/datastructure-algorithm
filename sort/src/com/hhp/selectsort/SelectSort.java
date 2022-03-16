package com.hhp.selectsort;

import java.util.Arrays;

/**
 * <p>
 * 选择排序
 * </p>
 *
 * @author 胡海平(Humphrey Hu)
 * @date 2021/12/14 14:17:41
 */
public class SelectSort {

    public int[] selectSort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        // 外层循环从0一直到末尾的前一个元素
        // 内存循环根据外层循环指针的位置动态变化，一直到最末尾
        // 总共要经过N - 1轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            // 每轮需要比较N - 1次
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            // 将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
        return arr;
    }
}
