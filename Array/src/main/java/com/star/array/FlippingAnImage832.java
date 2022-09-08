package com.star.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个二进制矩阵A，我们想先水平翻转图像，然后反转图像并返回结果。
 * <p>
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转[1, 1, 0]的结果是[0, 1, 1]。
 * <p>
 * 反转图片的意思是图片中的0全部被1替换，1全部被0替换。例如，反转[0, 1, 1]的结果是[1, 0, 0]。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[1,1,0],[1,0,1],[0,0,0]]
 * 输出：[[1,0,0],[0,1,0],[1,1,1]]
 * 解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 * 然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 * 示例 2：
 * <p>
 * 输入：[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 * 然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j]<=1
 *
 * @Author: zzStar
 * @Date: 02-26-2021 14:36
 */
public class FlippingAnImage832 {

    /**
     * 一次遍历
     * 翻转部分：使用双指针进行数字交换
     * 反转部分：将数字存储进目标位置前，使用「异或」对 0 1 进行翻转
     */
    public int[][] flipAndInvertImage(int[][] image) {
        for (int[] num : image) {
            int n = num.length;
            int low = 0;
            int high = n - 1;
            while (low <= high) {
                int temp = num[low];
                num[low++] = num[high] ^ 1;
                num[high--] = temp ^ 1;
            }
        }
        return image;
    }

    @Test
    public void flipAndInvertImage() {
        int[][] image = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        System.out.println(Arrays.deepToString(flipAndInvertImage(image)));
    }
}
