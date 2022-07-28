import org.junit.Test;

/**
 * 两个有序数组找第k小元素要求时间复杂度o(logn)
 *
 * @Author: zzStar
 * @Date: 12-03-2021 17:47
 */
public class KthSmallestInTwoSortedArray {
    public int getKth(int[] a, int i, int[] b, int j, int k) {
        if (i >= a.length) {
            return b[j + k - 1];
        }
        if (j >= b.length) {
            return a[i + k - 1];
        }
        if (k == 1) {
            return Math.min(a[i], b[j]);
        }
        int midA = (i + k / 2 - 1 < a.length) ? a[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midB = (j + k / 2 - 1 < b.length) ? b[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (midA < midB) {
            return getKth(a, i + k / 2, b, j, k - k / 2);
        } else {
            return getKth(a, i, b, j + k / 2, k - k / 2);
        }
    }
    @Test
    public void getKthTest() {
        int[] a = {1, 56, 78, 477};
        int[] b = {5, 6, 18, 118};
        System.out.println("getKt = " + getKth(a, 0, b, 0, 3));
    }

}
