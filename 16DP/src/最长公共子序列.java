import java.util.Scanner;

/**
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 *
 * @Author: zzStar
 * @Date: 03-26-2022 16:21
 */
public class 最长公共子序列 {

    /**
     * 两个数组，找最长公共子序列
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        System.out.println("n :" + n + " m :" + m);
        String a = sc.next(), b = sc.next();
        System.out.println("a :" + a + " b :" + b);
        a = " " + a;
        b = " " + b;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[n][m]);
    }

}
