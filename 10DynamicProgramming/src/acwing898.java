import java.util.Scanner;

/**
 * 给定一个如下图所示的数字三角形，从顶部出发，在每一结点可以选择移动至其左下方的结点或移动至其右下方的结点，一直走到底层，要求找出一条路径，使路径上的数字的和最大。
 * <p>
 * 7
 * 3   8
 * 8   1   0
 * 2   7   4   4
 * 4   5   2   6   5
 * 输入格式
 * 第一行包含整数 n，表示数字三角形的层数。
 * <p>
 * 接下来 n 行，每行包含若干整数，其中第 i 行表示数字三角形第 i 层包含的整数。
 * <p>
 * 输出格式
 * 输出一个整数，表示最大的路径数字和。
 * <p>
 * 数据范围
 * 1≤n≤500,
 * −10000≤三角形中的整数≤10000
 * 输入样例：
 * 5
 * 7
 * 3 8
 * 8 1 0
 * 2 7 4 4
 * 4 5 2 6 5
 * 输出样例：
 * 30
 *
 * @Author: zzStar
 * @Date: 04-22-2021 16:15
 */
public class acwing898 {

    public static void main(String[] args) {
        int[][] a = new int[510][510];
        int[][] f = new int[510][510];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i + 1; j++) {
                f[i][j] = Integer.MIN_VALUE;
            }
        }

        // 起点
        f[1][1] = a[1][1];


        /**
         *         7
         *       3   8
         *     8   1   0
         *   2   7   4   4
         * 4   5   2   6   5
         */

        // 从2开始
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // 来自左上
                int max1 = f[i - 1][j - 1];
                // 来自右上
                int max2 = f[i - 1][j];
                // a[i][j]表示最后这个数自己
                f[i][j] = Math.max(max1, max2) + a[i][j];
            }
        }
        int res = Integer.MIN_VALUE;
        for (int k = 1; k <= n; k++) {
            res = Math.max(res, f[n][k]);
        }
        System.out.println(res);

    }


}
