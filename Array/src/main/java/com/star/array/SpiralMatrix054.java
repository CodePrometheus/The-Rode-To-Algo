package com.star.array;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 03-15-2021 19:46
 */
public class SpiralMatrix054 {

    /**
     * 转圈遍历
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        LinkedList<Integer> ret = new LinkedList<>();
        if (matrix == null || matrix.length == 0) {
            return ret;
        }
        // 定义当前左右上下边界 l,r,t,b
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        // 总数
        int numEle = matrix.length * matrix[0].length;

        // 始终按照 从左到右 从上到下 从右到左 从下到上 填入顺序循环
        while (numEle >= 1) {
            for (int i = left; i <= right && numEle >= 1; i++) {
                ret.add(matrix[top][i]);
                numEle--;
            }
            // 更新边界：例如从左到右填完后，上边界 t += 1，相当于上边界向内缩 1。
            top++;

            for (int i = top; i <= bottom && numEle >= 1; i++) {
                ret.add(matrix[i][right]);
                numEle--;
            }
            right--;

            for (int i = right; i >= left && numEle >= 1; i--) {
                ret.add(matrix[bottom][i]);
                numEle--;
            }
            bottom--;

            for (int i = bottom; i >= top && numEle >= 1; i--) {
                ret.add(matrix[i][left]);
                numEle--;
            }
            left++;
        }

        return ret;
    }

    @Test
    public void spiralOrderTest() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(matrix));
    }
}
