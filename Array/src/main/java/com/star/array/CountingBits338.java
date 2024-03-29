package com.star.array;

/**
 * 给定一个非负整数num。对于0 ≤ i ≤ num 范围中的每个数字i，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: [0,1,1]
 * 示例2:
 * <p>
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 * <p>
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的__builtin_popcount）来执行此操作。
 *
 * @Author: zzStar
 * @Date: 03-03-2021 22:57
 */
public class CountingBits338 {

    /**
     * i中二进制1的个数等于 (i 右移一位后1的个数) + (i的最低位) 例如 i = 10 = (1010) 则 bits(i) = bits(1010) = bits(101) + bits(0) 由于之前已经计算过了高位的1的个数，所以可以直接使用,然后加上最低位
     */
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            // 当 i 的最低位是0，则 i 中1的个数和i >> 1中1的个数相同；当i的最低位是1，i 中1的个数是 i >> 1中1的个数再加1
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
}
