package com.star.array;

/**
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1,col1) ，右下角为 (row2,col2) 。
 * <p>
 * <p>
 * 上图子矩阵左上角(row1, col1) = (2, 1)，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 * <p>
 *
 * <p>
 * 示例：
 * <p>
 * 给定 matrix = [
 * [3, 0, 1, 4, 2],
 * [5, 6, 3, 2, 1],
 * [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7],
 * [1, 0, 3, 0, 5]
 * ]
 * <p>
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 *
 * <p>
 * 提示：
 * <p>
 * 你可以假设矩阵不可变。
 * 会多次调用sumRegion方法。
 * 你可以假设row1 ≤ row2 且col1 ≤ col2 。
 *
 * @Author: zzStar
 * @Date: 03-02-2021 13:21
 */
public class RangeSumQuery2dImmutable304 {

    /**
     * 推导出两减一加
     * preSum[row2][col2]-preSum[row2][col1−1]−preSum[row1−1][col2]+preSum[row1−1][col1−1]
     */
    int[][] sums;

    public RangeSumQuery2dImmutable304(int[][] matrix) {
        int m = matrix.length;
        if (m > 0) {
            int n = matrix[0].length;
            // 目的是不需要对row1=0和col1=0的情况特殊处理
            sums = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    /**
                     * f(i,j)=f(i−1,j)+f(i,j−1)−f(i−1,j−1)+matrix[i][j] = sums[i + 1][j + 1]
                     */
                    sums[i + 1][j + 1] = sums[i][j + 1] + sums[i + 1][j] - sums[i][j] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
    }
}
