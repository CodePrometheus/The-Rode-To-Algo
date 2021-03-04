import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: zzStar
 * @Date: 03-04-2021 19:38
 */
public class SumOfEvenNumbersAfterQueries985 {

    /**
     * 不断调整 S，即每一步操作之后整个数组的偶数和。
     * 我们操作数组中的某一个元素 A[index] 的时候，数组 A 其他位置的元素都应保持不变。
     * 如果 A[index] 是偶数，我们就从 S 中减去它，然后计算 A[index] + val 对 S 的影响（如果是偶数则在 S 中加上它）
     */
    public int[] sumEvenAfterQueries(int[] a, int[][] queries) {
        int s = 0;
        for (int x : a) {
            // 是否偶数
            if (x % 2 == 0) {
                s += x;
            }
        }
        // 至此循环结束后得到原数组偶数和s
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            // 分别对应q的两个数
            int val = queries[i][0], index = queries[i][1];
            if (a[index] % 2 == 0) {
                s -= a[index];
            }
            a[index] += val;
            if (a[index] % 2 == 0) {
                s += a[index];
            }
            ans[i] = s;
        }
        return ans;
    }

    @Test
    public void sumEvenAfterQueriesTest() {
        int[] a = {1, 2, 3, 4};
        int[][] q = {{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};
        System.out.println(Arrays.toString(sumEvenAfterQueries(a, q)));
    }
}
