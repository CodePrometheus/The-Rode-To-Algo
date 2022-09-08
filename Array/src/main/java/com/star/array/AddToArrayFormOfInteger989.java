package com.star.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 对于非负整数X而言，X的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果X = 1231，那么其数组形式为[1,2,3,1]。
 * <p>
 * 给定非负整数 X 的数组形式A，返回整数X+K的数组形式。
 * 示例 1：
 * <p>
 * 输入：A = [1,2,0,0], K = 34
 * 输出：    [1,2,3,4]
 * 解释：1200 + 34 = 1234
 * 示例 2：
 * <p>
 * 输入：A = [2,7,4], K = 181
 * 输出：    [4,5,5]
 * 解释：274 + 181 = 455
 * 示例 3：
 * <p>
 * 输入：A = [2,1,5], K = 806
 * 输出：    [1,0,2,1]
 * 解释：215 + 806 = 1021
 * 示例 4：
 * <p>
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：    [1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * 如果A.length > 1，那么A[0] != 0
 *
 * @Author: zzStar
 * @Date: 03-04-2021 20:07
 */
public class AddToArrayFormOfInteger989 {

    /**
     * 不可将A数组遍历得到sumA，与K做加法得到和，原因：A数组的长度可能很长，整数越界
     */
    public List<Integer> addToArrayForm(int[] a, int k) {
        int length = a.length;
        int num = k;
        LinkedList<Integer> res = new LinkedList<>();
        int i = length - 1;
        // 从k的各位开始
        while (i >= 0 || num > 0) {
            if (i >= 0) {
                num += a[i];
            }
            res.addFirst(num % 10);
            // 每次扔掉K的末位
            num /= 10;
            i--;
        }
        return res;
    }

    /**
     * 加法模板
     * 当前位 = (A 的当前位 + B 的当前位 + 进位carry) % 10
     * AB两数都加完后，最后判断一下进位 carry, 进位不为 0 的话加在前面
     * while ( A 没完 || B 没完)
     * A 的当前位
     * B 的当前位
     * <p>
     * 和 = A 的当前位 + B 的当前位 + 进位carry
     * <p>
     * 当前位 = 和 % 10;
     * 进位 = 和 / 10;
     * <p>
     * 判断还有进位吗
     */
    public List<Integer> addToArrayForm2(int[] A, int K) {
        int n = A.length;
        LinkedList<Integer> res = new LinkedList<>();
        int sum = 0, carry = 0;
        // 循环条件：两个数有一个没完
        for (int i = n - 1; i >= 0 || K != 0; K = K / 10, i--) {
            int x = i >= 0 ? A[i] : 0;
            int y = K != 0 ? K % 10 : 0;

            sum = x + y + carry;
            carry = sum / 10;
            res.addFirst(sum % 10);
        }
        if (carry != 0) {
            res.add(0, carry);
        }
        return res;
    }

    /**
     * while ( A 没完 || B 没完)
     * A 的当前位
     * B 的当前位
     * <p>
     * 和 = A 的当前位 + B 的当前位 + 进位carry
     * <p>
     * 当前位 = 和 % 10;
     * 进位 = 和 / 10;
     * <p>
     * 判断还有进位吗
     */
    public List<Integer> addToArrayForm3(int[] A, int K) {
        int n = A.length;
        List<Integer> res = new ArrayList<>();
        int i = n - 1, sum = 0, carry = 0;
        // 循环条件：两个数有一个没完
        while (i >= 0 || K != 0) {
            int x = i >= 0 ? A[i] : 0;
            int y = K != 0 ? K % 10 : 0;

            sum = x + y + carry;
            carry = sum / 10;
            K = K / 10;

            i--;
            res.add(0, sum % 10);
        }
        if (carry != 0) {
            res.add(0, carry);
        }
        return res;
    }


    @Test
    public void addToArrayFormTest() {
        int[] a = {2, 1, 5};
        int k = 806;
        System.out.println(addToArrayForm(a, k));
        System.out.println(addToArrayForm2(a, k));
        System.out.println(addToArrayForm3(a, k));
    }
}
