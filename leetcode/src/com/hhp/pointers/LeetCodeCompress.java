package com.hhp.pointers;

public class LeetCodeCompress {

    public int anotherCompress(char[] chars) {
        int n = chars.length, write = 0;
        for (int i = 0; i < n; ) {
            int j = i;
            while (j < n && chars[i] == chars[j]) {
                j++;
            }
            chars[write++] = chars[i];
            if (j - i > 1) {
                String tmp = Integer.toString(j - i);
                for (int k = 0; k < tmp.length(); k++) {
                    chars[write++] = tmp.charAt(k);
                }
            }
            i = j;
        }
        return write;
    }

    public int compress(char[] chars) {
        int left = 0, right = 0;
        int len = chars.length;

        while (right < len) {
            int index = right;
            while (right < len && chars[index] == chars[right]) {
                right++;
            }

            int repeats = right - index;
            chars[left] = chars[right - 1];

            if (repeats == 1) {
                left++;
            } else if (repeats <= 9) {
                chars[left + 1] = (char)(repeats + '0');
                left += 2;
            } else {
                String num = repeats + "";
                for (int i = 0; i < num.length(); i++) {
                    chars[left + 1 + i] = num.charAt(i);
                }
                left += num.length() + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        char[] chars = new char[]{
                'a', 'a', 'a',
                'b', 'b',
                'c', 'c', 'c'
        };
        LeetCodeCompress codeCompress = new LeetCodeCompress();
        System.out.println("compress: " + codeCompress.compress(chars));
        System.out.println("anotherCompress: " + codeCompress.anotherCompress(chars));
    }
}
