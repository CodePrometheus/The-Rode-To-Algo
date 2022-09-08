package com.star.array;

import org.junit.Test;

/**
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给你一个整数数组flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数n ，能否在不打破种植规则的情况下种入n朵花？能则返回 true ，不能则返回 false。
 * 示例 1：
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 2
 * 输出：false
 * <p>
 *
 * @Author: zzStar
 * @Date: 02-24-2021 13:50
 */
public class CanPlaceFlowers605 {

    /**
     * 防御式编程思想：在 flowerbed 数组两端各增加一个 0，
     * 这样处理的好处在于不用考虑边界条件，任意位置处只要连续出现三个 0 就可以栽上一棵花。
     * 判断种花的条件是连续奇数个0，即3，5，7，但是在花坛边，连续两个0就可以在flowerbed[0]处种花，右边同理
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        /**
         * 看到问题的第一个想法就是判断这个元素前面有没有1，后面有没有1，如果都没有，该点就可以种花。
         * 但是会遇到边界问题，第一个元素不存在前一个元素，最后一个元素不存在后一个元素，判断起来好麻烦。
         * 于是就在种花数组的前后各补充一个0，第一个元素就有了前一个元素，且不会改变第一个元素是否能种花的情况。
         * 例如[0,1,0] -> [0,0,1,0,0]
         * 第一个元素是0，padding之后，它前面是0，后面是1，不能种花。
         * 每次判断完之后，更新种花数组里的值，继续模拟。
         */
        int[] temp = new int[flowerbed.length + 2];
        temp[0] = 0;
        temp[temp.length - 1] = 0;

        // 赋值
        for (int i = 0; i < flowerbed.length; i++) {
            temp[i + 1] = flowerbed[i];
        }
        int cnt = 0;
        for (int i = 1; i < temp.length - 1; i++) {
            // 第i个位置前后都没有花，可以种，记录总数，更新状态
            if (temp[i - 1] == 0 && temp[i + 1] == 0 && temp[i] == 0) {
                temp[i] = 1;
                cnt++;
            }
        }
        return cnt >= n;
    }

    /**
     * 贪心
     * 能够种花就种，不能种就往后继续尝试，直到所有格子都试过为止。
     */
    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (n <= 0) {
                return true;
            }
            if (flowerbed[i] == 1) {
                continue;
            }
            // 如果上一个格子已经种过花了，则当前这格不能种花
            if (i > 0 && flowerbed[i - 1] == 1) {
                continue;
            }
            // 如果下一个格子已经种过花了，则当前这格不能种花
            if (i < flowerbed.length - 1 && flowerbed[i + 1] == 1) {
                continue;
            }
            // 判断到这里说明可以种花，并维护次数
            flowerbed[i] = 1;
            n--;
        }
        return n <= 0;
    }

    @Test
    public void canPlaceFlowersTest() {
        int[] flow = {1, 0, 0, 0, 1, 0, 0};
        int n = 2;
        System.out.println(canPlaceFlowers(flow, n));
        System.out.println(canPlaceFlowers2(flow, n));
    }
}
