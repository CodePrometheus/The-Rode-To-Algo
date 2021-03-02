import org.junit.Test;

/**
 * 给定一个整数数组 arr，如果它是有效的山脉数组就返回true，否则返回 false。
 * <p>
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 * <p>
 * arr.length >= 3
 * 在0 < i< arr.length - 1条件下，存在i使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [2,1]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：arr = [3,5,5]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：arr = [0,3,2,1]
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 104
 * 0 <= arr[i] <= 104
 *
 * @Author: zzStar
 * @Date: 03-02-2021 19:23
 */
public class ValidMountainArray941 {

    /**
     * 线性扫描
     */
    public boolean validMountainArray(int[] arr) {
        int i = 0;
        // 递增扫描
        while (i + 1 < arr.length && arr[i] < arr[i + 1]) {
            i++;
        }
        // 判断最高点
        if (i == 0 || i == arr.length - 1) {
            return false;
        }
        // 然后递减
        while (i + 1 < arr.length && arr[i] > arr[i + 1]) {
            i++;
        }
        // 如果符合题意，i就是arr.length-1
        return i == arr.length - 1;
    }

    /**
     * 双指针
     */
    public boolean validMountainArray2(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int l = 0, r = arr.length - 1;
        while (l < arr.length - 2 && arr[l] < arr[l + 1]) {
            l++;
        }
        while (r > 1 && arr[r] < arr[r - 1]) {
            r--;
        }
        // 如果符合题意，左右指针会相遇
        return l == r;
    }

    @Test
    public void validMountainArrayTest() {
        int[] arr = {0, 3, 2, 1};
        System.out.println(validMountainArray(arr));
        System.out.println(validMountainArray2(arr));
    }
}
