import org.junit.Test;

/**
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 * <p>
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 * <p>
 * 当给定的数组 A是单调数组时返回 true，否则返回 false。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,2,3]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：[6,5,4,4]
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：[1,3,2]
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：[1,2,4,5]
 * 输出：true
 * 示例5：
 * <p>
 * 输入：[1,1,1]
 * 输出：true
 *
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 50000
 * -100000 <= A[i] <= 100000
 *
 * @Author: zzStar
 * @Date: 02-27-2021 20:10
 */
public class MonotonicArray896 {

    public boolean isMonotonic(int[] A) {
        int a = 0, b = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                a = 1;
            }
            if (A[i] > A[i - 1]) {
                b = 1;
            }
            if (a + b == 2) {
                return false;
            }
        }
        return true;
    }

    /**
     * 比较第一位与最后一位元素的大小，便可得到整体走势，然后一次遍历挨个判断是否与首尾走势一致即可
     */
    public boolean isMonotonic2(int[] A) {
        // 首尾
        boolean grow = (A[0] <= A[A.length - 1]);
        for (int i = 0; i < A.length - 1; i++) {
            if (grow) {
                if (A[i] > A[i + 1]) {
                    return false;
                }
            } else {
                if (A[i] < A[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }


    @Test
    public void isMonotonicTest() {
        int[] A = {1, 3, 2};
        System.out.println(isMonotonic(A));
        System.out.println(isMonotonic2(A));
    }
}
