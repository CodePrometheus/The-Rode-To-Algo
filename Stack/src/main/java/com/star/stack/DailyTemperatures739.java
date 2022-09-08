package com.star.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: zzStar
 * @Date: 03-28-2022 15:18
 */
public class DailyTemperatures739 {

    public static void main(String[] args) {
        int[] tmp = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(tmp)));
    }

    static int[] dailyTemperatures(int[] tmp) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            while (!st.isEmpty() && tmp[i] > tmp[st.peek()]) {
                res[st.peek()] = i - st.pop();
            }
            st.push(i);
        }
        return res;
    }

}
