import org.junit.Test;

import java.util.Arrays;

/**
 * 给你一个正整数n ，生成一个包含 1 到n2所有元素，且元素按顺时针顺序螺旋排列的n x n 正方形矩阵 matrix 。
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：[[1]]
 * 提示：
 * <p>
 * 1 <= n <= 20
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 03-16-2021 10:25
 */
public class SpiralMatrixII059 {

    /**
     * 模拟法，设定边界
     */
    public int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] ret = new int[n][n];

        int num = 1, tar = n * n;

        while (num <= tar) {

            // 左到右
            for (int i = l; i <= r; i++) {
                ret[t][i] = num++;
            }
            t++;

            // 上到下
            for (int i = t; i <= b; i++) {
                ret[i][r] = num++;
            }
            r--;

            // 右到左
            for (int i = r; i >= l; i--) {
                ret[b][i] = num++;
            }
            b--;

            // 下到上
            for (int i = b; i >= t; i--) {
                ret[i][l] = num++;
            }
            l++;
        }
        return ret;
    }

    @Test
    public void generateMatrixTest() {
        int n = 3;
        System.out.println(Arrays.deepToString(generateMatrix(n)));
    }
}
