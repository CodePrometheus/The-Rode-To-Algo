import org.junit.Test;

import java.util.Arrays;

/**
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 * <p>
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 * <p>
 * 如果是，则返回最大元素的索引，否则返回-1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [3, 6, 1, 0]
 * 输出: 1
 * 解释: 6是最大的整数, 对于数组中的其他整数,
 * 6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
 *
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [1, 2, 3, 4]
 * 输出: -1
 * 解释: 4没有超过3的两倍大, 所以我们返回 -1.
 *
 * <p>
 * 提示:
 * <p>
 * nums的长度范围在[1, 50].
 * 每个nums[i]的整数范围在[0, 100].
 * <p>
 *
 * @Author: zzStar
 * @Date: 02-25-2021 23:29
 */
public class LargestNumberAtLeastTwiceOfOthers747 {

    /**
     * 找到第二大的元素，将它的两倍的值与最大值进行比较
     */
    public int dominantIndex(int[] nums) {
        int max = 0, idx = 0, less = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                less = max;
                max = nums[i];
                idx = i;
            } else if (nums[i] > less) {
                less = nums[i];
            }
        }
        return max >= (less * 2) ? idx : -1;
    }

    /**
     * 线性扫描
     * 扫描数组找到唯一的最大元素 m，并记录它的索引 maxIndex。
     * 再次扫描数组，如果我们找到 x != m，m < 2*x，我们应该返回 -1。
     * 否则返回 maxIndex
     */
    public int dominantIndex2(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        for (int i = 0; i < nums.length; ++i) {
            if (maxIndex != i && nums[maxIndex] < 2 * nums[i]) {
                return -1;
            }
        }
        return maxIndex;
    }


    @Test
    public void dominantIndexTest() {
        int[] nums = {1, 2, 3, 4};
        System.out.println(dominantIndex(nums));
        System.out.println(dominantIndex2(nums));
    }
}
