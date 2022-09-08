package com.star.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
 * <p>
 * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
 * <p>
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 * <p>
 * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 * @Author: zzStar
 * @Date: 02-13-2021 22:06
 */
public class ReshapeTheMatrix566 {

    /**
     * 维护一个count 新矩阵的indexRow = count/col indexCol = count%col 循环填入即可
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (r * c != nums.length * nums[0].length) {
            return nums;
        }

        int[][] res = new int[r][c];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                res[count / c][count % c] = nums[i][j];
                count++;
            }
        }
        return res;
    }

    @Test
    public void matrixReshapeTest() {
        int[][] nums = {{1, 2},
                {3, 4}};
        int r = 2, c = 4;
        System.out.println(Arrays.deepToString(matrixReshape(nums, r, c)));
    }
}
