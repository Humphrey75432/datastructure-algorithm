package com.hhp.numbers;

public class MajorityNumber {

    /**
     * Boyer Moore算法
     * */
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    public static void main(String[] args) {
        MajorityNumber majorityNumber = new MajorityNumber();
        int[] nums = {7, 7, 7, 7, 3, 2, 3};
        System.out.println(majorityNumber.majorityElement(nums));
    }
}
