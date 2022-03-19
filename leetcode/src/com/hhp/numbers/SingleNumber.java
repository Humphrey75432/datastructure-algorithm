package com.hhp.numbers;

public class SingleNumber {

    /**
     * 异或的运算性质
     * 1. a ^ 0 = a;
     * 2. a ^ a = 0;
     * 3. 交换律：a ^ b = b ^ a
     * 4. 结合律：(a ^ b) ^ c = a ^ (b ^ c)
     * */
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber.singleNumber(nums));
    }
}
