package com.star.math;

import org.junit.Test;

/**
 * 统计所有小于非负整数n的质数的数量。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 * <p>
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：n = 1
 * 输出：0
 *
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 5 * 106
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-primes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 04-30-2021 11:23
 */
public class CountPrimes204 {

    /**
     * 朴素解法 -> 超时
     * 注意 ii 遍历到最大 根号n即可，因为如果n不是质数，那么至少有一个因子是小于等于根号n的
     */
    public int countPrimes1(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(int num) {
        int max = (int) Math.sqrt(num);
        for (int i = 2; i <= max; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * 埃氏筛法
     * 也就是排除掉n的倍数
     */
    public int countPrimes(int n) {
        int count = 0;
        boolean[] flag = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!flag[i]) {
                count++;
                // 翻一番
                for (int j = i + i; j < n; j += i) {
                    flag[j] = true;
                }
            }
        }
        return count;
    }


    @Test
    public void countPrimesT1est() {
        int n = 4;
        System.out.println(countPrimes(n));
        System.out.println(countPrimes1(n));
    }
}
