import org.junit.Test;

import java.util.Arrays;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 *
 * <p>
 * 进阶：
 * <p>
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 *
 * @Author: zzStar
 * @Date: 03-02-2021 19:53
 */
public class SquaresOfASortedArray977 {

    /**
     * 双指针
     * 利用「数组 nums 已经按照升序排序」这个条件。显然，如果数组 nums 中的所有数都是非负数，那么将每个数平方后，数组仍然保持升序；
     * 如果数组 nums 中的所有数都是负数，那么将每个数平方后，数组会保持降序。
     * 这样一来，如果我们能够找到数组 nums 中负数与非负数的分界线，那么就可以用类似「归并排序」的方法了。
     * 具体地，我们设 neg 为数组 nums 中负数与非负数的分界线，也就是说，[0]nums[0] 到 ]nums[neg] 均为负数，
     * 而 nums[neg+1] 到 nums[n−1] 均为非负数。当我们将数组 nums 中的数平方后，那么 nums[0] 到 nums[neg] 单调递减，
     * nums[neg+1] 到 nums[n−1] 单调递增。
     * 由于我们得到了两个已经有序的子数组，因此就可以使用归并的方法进行排序了。
     */
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int negative = -1;
        for (int i = 0; i < n; ++i) {
            if (nums[i] < 0) {
                negative = i;
            } else {
                break;
            }
        }

        int[] ans = new int[n];
        int index = 0, i = negative, j = negative + 1;
        while (i >= 0 || j < n) {
            if (i < 0) {
                ans[index] = nums[j] * nums[j];
                ++j;
            } else if (j == n) {
                ans[index] = nums[i] * nums[i];
                --i;
            } else if (nums[i] * nums[i] < nums[j] * nums[j]) {
                ans[index] = nums[i] * nums[i];
                --i;
            } else {
                ans[index] = nums[j] * nums[j];
                ++j;
            }
            ++index;
        }

        return ans;
    }


    /**
     * 可以使用两个指针分别指向位置 0 和 n−1，每次比较两个指针对应的数，
     * 选择较大的那个 逆序 放入答案并移动指针。这种方法无需处理某一指针移动至边界的情况
     */
    public int[] sortedSquares2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j; ) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                ans[pos] = nums[i] * nums[i];
                ++i;
            } else {
                ans[pos] = nums[j] * nums[j];
                --j;
            }
            --pos;
        }
        return ans;
    }

    /**
     * 首尾双指针法进行比较时，不用平方，直接左值取负与右值进行比较也能判断
     * 原数组是有序的，右边如果不是正数那平方后就一定是小于左边的平方
     */
    public int[] sortedSquares3(int[] nums) {
        int[] res = new int[nums.length];
        int l = 0;
        int r = nums.length - 1;
        // 从右边放
        int i = r;
        while (l <= r) {
            if (-nums[l] > nums[r]) {
                res[i] = nums[l] * nums[l];
                l += 1;
            } else {
                res[i] = nums[r] * nums[r];
                r -= 1;
            }
            // 向左走
            i--;
        }
        return res;
    }

    /**
     * 暴力
     */
    public int[] sortedSquares4(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    @Test
    public void sortedSquaresTest() {
        int[] num = {-11, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(num)));
        System.out.println(Arrays.toString(sortedSquares2(num)));
        System.out.println(Arrays.toString(sortedSquares3(num)));
        System.out.println(Arrays.toString(sortedSquares4(num)));
    }
}
