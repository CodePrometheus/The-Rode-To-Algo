package com.star.plus;

/**
 * 大数相减
 *
 * @Author: Starry
 * @Date: 09-13-2022 10:21
 */
public class BigSubNum {
    public static void main(String[] args) {
        System.out.println(BigSubNum.func("1000000000000001", "12"));
    }

    public static String func(String a, String b) {
        int[] aa = new int[a.length()];
        int[] bb = new int[b.length()];
        for (int i = 0; i < a.length(); i++) {
            aa[i] = Integer.parseInt(String.valueOf(a.charAt(i)));
        }
        for (int i = 0; i < b.length(); i++) {
            bb[i] = Integer.parseInt(String.valueOf(b.charAt(i)));
        }
        int index = b.length();
        for (int i = a.length() - 1; i >= 0; i--) {
            if (index >= 1) {
                if (aa[i] >= bb[index - 1]) {
                    aa[i] = aa[i] - bb[index - 1];
                } else {
                    int temp = 1;
                    while (aa[i - temp] == 0) {
                        aa[i - temp] = 9;
                        temp++;
                    }
                    aa[i - temp]--;
                    aa[i] = aa[i] + 10 - bb[index - 1];
                }
                index--;
            }
        }
        int start = a.length() - 1;
        for (int i = 0; i < a.length(); i++) { // 去零
            if (aa[i] != 0) {
                start = i;
                break;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = start; i < a.length(); i++) {
            result.append(aa[i]);
        }
        return result.toString();
    }
}
